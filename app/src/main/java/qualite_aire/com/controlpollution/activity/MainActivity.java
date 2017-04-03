package qualite_aire.com.controlpollution.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import qualite_aire.com.controlpollution.R;

import qualite_aire.com.controlpollution.adapter.Citiesadapter;
import qualite_aire.com.controlpollution.model.City;
import qualite_aire.com.controlpollution.model.CityReponse;
import qualite_aire.com.controlpollution.rest.ApiClient;
import qualite_aire.com.controlpollution.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    SearchView searchView;

    // insert your API KEY here
    private final static String API_KEY = "fe74e0b525908d08ff696aabce918b22ff096fee";
    public String ville = "grenoble";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cities_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from first!", Toast.LENGTH_LONG).show();
            return;
        }

        searchView = (SearchView) findViewById(R.id.search_bar);
        searchView.setQueryHint("Search View");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                ville = query;
                ApiInterface apiService =
                        ApiClient.getClient().create(ApiInterface.class);

                Call<CityReponse> call = apiService.getTopRatedMovies(API_KEY,ville);
                call.enqueue(new Callback<CityReponse>() {
                    @Override
                    public void onResponse(Call<CityReponse> call, Response<CityReponse> response) {
                        int statusCode = response.code();
                        List <City> cities = response.body().getData();

                        recyclerView.setAdapter(new Citiesadapter(cities, R.layout.list_item_city, getApplicationContext()));


                    }


                    public void onFailure(Call<CityReponse> call, Throwable t) {
                        // Log error here since request failed
                        Log.e(TAG, t.toString());
                    }
                });

                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<CityReponse> call = apiService.getTopRatedMovies(API_KEY,ville);
        call.enqueue(new Callback<CityReponse>() {
            @Override
            public void onResponse(Call<CityReponse> call, Response<CityReponse> response) {
                int statusCode = response.code();
                List <City> cities = response.body().getData();


                recyclerView.setAdapter(new Citiesadapter(cities, R.layout.list_item_city, getApplicationContext()));



            }


            public void onFailure(Call<CityReponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
    //Méthode qui se déclenchera lorsque vous appuierez sur le bouton menu du téléphone
    public boolean onCreateOptionsMenu(Menu menu) {
        //Création d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML spécifier en un objet Menu
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    //Méthode qui se déclenchera au clic sur un item
    public boolean onOptionsItemSelected(MenuItem item) {
        //On regarde quel item a été cliqué grâce à  son id et on déclenche une action
        switch (item.getItemId()) {

            case R.id.favoris:

                Intent intent = new Intent(MainActivity.this, FavActivity.class);  //Lancer l'activité DisplayVue
                startActivity(intent);
                return true;

        }
        return false;
    }



}

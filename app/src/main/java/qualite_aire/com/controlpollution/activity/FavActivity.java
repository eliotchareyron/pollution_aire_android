package qualite_aire.com.controlpollution.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import qualite_aire.com.controlpollution.R;
import qualite_aire.com.controlpollution.adapter.Citiesadapter;
import qualite_aire.com.controlpollution.adapter.favoriesadapter;
import qualite_aire.com.controlpollution.model.City;
import qualite_aire.com.controlpollution.model.CityReponse;
import  qualite_aire.com.controlpollution.model.favories_city;
import qualite_aire.com.controlpollution.model.Cityfav;
import qualite_aire.com.controlpollution.model.favoriesReponse;
import qualite_aire.com.controlpollution.rest.ApiClient;
import qualite_aire.com.controlpollution.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by etudiant on 01/04/2017.
 */

public class FavActivity extends Activity{
    // insert your API KEY here
    private final static String API_KEY = "fe74e0b525908d08ff696aabce918b22ff096fee";
    public String ville = "grenoble";

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.citiesfav);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.citiesfav_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from first!", Toast.LENGTH_LONG).show();
            return;
        }

        long valeur = Cityfav.count(Cityfav.class);
        Log.d("nb", String.valueOf(valeur));

        List<Cityfav> favories = Cityfav.listAll(Cityfav.class);
//// TODO: 02/04/2017 ajouter boucle pour lister favories dans la view
        for (int i = 0; i <= valeur-1; i++) {

            ville = favories.get(i).getname().toString();

            Log.d("valeur", favories.get(i).toString());
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<favoriesReponse> call = apiService.getfavories(API_KEY, ville);

            call.enqueue(new Callback<favoriesReponse>() {
                @Override
                public void onResponse(Call<favoriesReponse> call, Response<favoriesReponse> response) {
                    int statusCode = response.code();
                    List<favories_city> cities = response.body().getData();

                    recyclerView.setAdapter(new favoriesadapter(cities, R.layout.liste_favories, getApplicationContext()));
                    

                }

                public void onFailure(Call<favoriesReponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }
    }
}

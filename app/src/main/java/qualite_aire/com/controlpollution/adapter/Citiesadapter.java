package qualite_aire.com.controlpollution.adapter;

/**
 * Created by etudiant on 27/03/2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;
import qualite_aire.com.controlpollution.R;
import qualite_aire.com.controlpollution.model.City;
import qualite_aire.com.controlpollution.model.Cityfav;

import java.io.IOError;
import java.util.List;

public class Citiesadapter extends RecyclerView.Adapter<Citiesadapter.CityViewHolder> {

    private List<City> cities;
    private int rowLayout;
    private Context context;



    public static class CityViewHolder extends RecyclerView.ViewHolder {
        LinearLayout CityLayout;
        TextView cityname;
        TextView aqi;
        TextView time;
        TextView id;
        ImageButton bouton;



        public CityViewHolder(View v) {
            super(v);
            CityLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            cityname = (TextView) v.findViewById(R.id.title);
            aqi = (TextView) v.findViewById(R.id.subtitle);
            time = (TextView) v.findViewById(R.id.description);
            bouton= (ImageButton) v.findViewById(R.id.fav);
            id = (TextView) v.findViewById(R.id.id_city);

            bouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SugarContext.init(v.getContext());
                    Toast.makeText(v.getContext(), "ajouter au favoris", Toast.LENGTH_LONG).show();
                    Log.d("test" ,aqi.getText().toString());

                    Cityfav favories = new Cityfav(id.getText().toString(), cityname.getText().toString());
                    favories.save();

                }
            });

        }



    }


    public Citiesadapter(List<City> city, int rowLayout, Context context) {
        this.cities = city;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public Citiesadapter.CityViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CityViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, final int position) throws IOError {
        holder.cityname.setText(cities.get(position).getName());
        holder.time.setText(cities.get(position).getTime());
        holder.aqi.setText(cities.get(position).getAqi());
        holder.id.setText(cities.get(position).getId());

        int pollution;

        try {
            String test ;
            test = holder.aqi.getText().toString();

             Integer.parseInt(test);
            pollution = Integer.valueOf(holder.aqi.getText().toString());
        } catch (NumberFormatException e){

            pollution = 0;
        }


        if (pollution < 50 ) {
            holder.itemView.findViewById(R.id.pollution).setBackgroundColor(Color.GREEN);
        } else if ( pollution >= 50 && pollution < 100) {
            holder.itemView.findViewById(R.id.pollution).setBackgroundColor(Color.rgb(255,140,0));

        } else {
            holder.itemView.findViewById(R.id.pollution).setBackgroundColor(Color.RED);
        }

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }



}


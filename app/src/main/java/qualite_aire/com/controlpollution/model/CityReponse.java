package qualite_aire.com.controlpollution.model;

/**
 * Created by etudiant on 27/03/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.List;

//recuperation de tous les donnees reçus pas l'api
public class CityReponse {

    @SerializedName("data")
    private List <City> data;


    public List<City> getData() {
        return data;
    }

    public void setData(List<City> data) {
        this.data = data;
    }
}

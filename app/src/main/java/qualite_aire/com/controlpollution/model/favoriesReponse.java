package qualite_aire.com.controlpollution.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by etudiant on 02/04/2017.
 */
//recuperation de tous les donnees reçus pas l'api
public class favoriesReponse {
    @SerializedName("data")
    private List <favories_city> data;


    public List<favories_city> getData() {
        return data;
    }
    public  favories_city getlastdata() {return data.get(data.size()-1);}

    public void setData(List<favories_city> data) {
        this.data = data;
    }
}

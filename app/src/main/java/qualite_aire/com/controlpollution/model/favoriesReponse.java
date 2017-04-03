package qualite_aire.com.controlpollution.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by etudiant on 02/04/2017.
 */

public class favoriesReponse {
    @SerializedName("data")
    private List <favories_city> data;


    public List<favories_city> getData() {
        return data;
    }

    public void setData(List<favories_city> data) {
        this.data = data;
    }
}

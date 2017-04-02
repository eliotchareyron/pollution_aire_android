package qualite_aire.com.controlpollution.model;

/**
 * Created by etudiant on 27/03/2017.
 */

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("aqi")
    private String  aqi;
    @SerializedName("station")
    private Name name;
    @SerializedName("time")
    public Time time;
    @SerializedName("uid")
    private String id;


    private String nom;
    private String stime;


    public String getName() {return name.toString(); }
    public void SetName(String val){ this.nom = val ;}

    public String getId() {return  id;}
    public void setId(String id){ this.id = id;}


    public String getAqi() {
        return aqi;
    }
    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getTime() { return time.toString();}
    public void setTime(String time) {this.stime = time;}

    public City(String name, String aqi, String time,String id ){
        this.nom = name;
        this.aqi = aqi;
        this.stime = time;
        this.id = id;
    }
}

class Name {
@SerializedName("name")
    private String nom;

    public String getName(){return nom;}
    public void setName(String name) {
        this.nom = name;
    }
    public  String toString(){return  nom.toString();}
}

class Time {
    @SerializedName("stime")
    private String time;
    public String getTime() {return  time;}
    public void setTime(String Time) { this.time = Time; }
    public  String toString(){return  time.toString();}

}
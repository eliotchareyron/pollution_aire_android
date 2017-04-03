package qualite_aire.com.controlpollution.model;

import com.orm.SugarRecord;

/**
 * Created by etudiant on 01/04/2017.
 */

public class Cityfav extends SugarRecord {

    private String idapi;
    private  String name;

    public  String getname(){ return name;}
    public  void setname(String name) {this.name = name;}

    public String getid_api() { return  idapi;}
    public void  setid_api(String id) {this.idapi = id;}

    public Cityfav(){
    }

    public Cityfav(String id_api , String name){
        this.idapi = id_api;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cityfav{" +
                "idapi='" + idapi + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

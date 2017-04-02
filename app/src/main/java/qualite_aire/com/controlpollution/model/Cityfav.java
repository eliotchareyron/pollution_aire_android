package qualite_aire.com.controlpollution.model;

import com.orm.SugarRecord;

/**
 * Created by etudiant on 01/04/2017.
 */

public class Cityfav extends SugarRecord {

    private String id_api;
    private  String name;

    public  String getname(){ return name;}
    public  void setname(String name) {this.name = name;}

    public String getid_api() { return  id_api;}
    public void  setid_api(String id) {this.id_api = id;}

    public Cityfav(){
    }

    public Cityfav(String id_api , String name){
        this.id_api = id_api;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cityfav{" +
                "id_api='" + id_api + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

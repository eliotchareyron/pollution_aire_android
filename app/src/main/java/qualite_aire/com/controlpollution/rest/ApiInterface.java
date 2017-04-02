package qualite_aire.com.controlpollution.rest;

/**
 * Created by etudiant on 27/03/2017.
 */

import qualite_aire.com.controlpollution.model.CityReponse;
import qualite_aire.com.controlpollution.model.favoriesReponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search/")
    Call<CityReponse> getTopRatedMovies(@Query("token") String apiKey, @Query("keyword") String keyword);

    @GET("search/")
    Call<favoriesReponse> getfavories(@Query("token") String apiKey, @Query("keyword") String keyword);
}
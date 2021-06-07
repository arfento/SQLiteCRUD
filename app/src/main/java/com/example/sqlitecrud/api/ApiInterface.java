package com.example.sqlitecrud.api;


import com.example.sqlitecrud.model.PendingResponse;
import com.example.sqlitecrud.model.ResponseRoute;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

//    @GET("movie/top_rated")
//    Call<Movie> getTopRatedMovies(@Query("API_KEY") String apiKey);
//
//    @GET("movie/{id}")
//    Call<Movie> getMovieDetails(@Path("id") int id, @Query("API_KEY") String apiKey);

    @POST("api/QRInfoDetail/getDataDetaiPendingNewQR/{staffCode}")
    Call<PendingResponse> getDataDetaiPendingNewQR (@Path("staffCode") String staffCode);

    //https://maps.googleapis.com/maps/api/directions/
    // json?origin=Cirebon,ID&destination=Jakarta,ID&api_key=YOUR_API_KEY
    @GET("json")
    Call<ResponseRoute> request_route(
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("api_key") String api_key
    );
}

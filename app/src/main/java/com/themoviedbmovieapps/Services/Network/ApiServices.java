package com.themoviedbmovieapps.Services.Network;

import com.themoviedbmovieapps.Services.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("3/movie/top_rated?api_key=ac5f083985e059dd57bfcca6d052f746")
    Call<MovieModel> getTopRatedMovieList();
}

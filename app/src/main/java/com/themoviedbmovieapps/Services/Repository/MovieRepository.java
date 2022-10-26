package com.themoviedbmovieapps.Services.Repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.themoviedbmovieapps.Services.Model.MovieModel;
import com.themoviedbmovieapps.Services.Model.Result;
import com.themoviedbmovieapps.Services.Network.ApiServices;
import com.themoviedbmovieapps.Services.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;
    private MovieModel movieModel;
    private List<Result> mResult;
    private MutableLiveData mLiveData;


    @SuppressLint("StaticFieldLeak")
    private static MovieRepository instance;
    public static MovieRepository getInstance(Context context){
        if (instance==null){
            mContext=context;
            instance= new MovieRepository();
        }
        return instance;
    }


    public MutableLiveData<List<Result>> getTopRatedMovieList(){
        if (mLiveData ==null){
            mLiveData = new MutableLiveData();}

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> call= apiServices.getTopRatedMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(@NonNull Call<MovieModel> call, @NonNull Response<MovieModel> response) {
                movieModel= response.body();
                assert movieModel != null;
                mResult= movieModel.getResults();
                mLiveData.postValue(mResult);
                Toast.makeText(mContext, "Success again", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<MovieModel> call, @NonNull Throwable t) {

            }
        });
        return mLiveData;
    }
}

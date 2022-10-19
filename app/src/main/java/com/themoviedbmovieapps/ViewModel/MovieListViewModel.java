package com.themoviedbmovieapps.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.themoviedbmovieapps.Services.Model.Result;
import com.themoviedbmovieapps.Services.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private MovieRepository mMovieRepository;

    public MovieListViewModel(@NonNull Application application) {
        super(application);

        mMovieRepository= MovieRepository.getInstance(application);
    }


    public LiveData<List<Result>> getTopRatedMovieLists(){
        return mMovieRepository.getTopRatedMovieList();
    }
}

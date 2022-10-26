package com.themoviedbmovieapps.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.themoviedbmovieapps.Services.Model.Result;
import com.themoviedbmovieapps.Services.Repository.MovieRepositoryImpl;
import com.themoviedbmovieapps.Services.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private MovieRepository mMovieRepository;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        mMovieRepository= MovieRepositoryImpl.getInstance(application);
    }

    public MutableLiveData<List<Result>> getTopRatedMovieLists(){
        return mMovieRepository.getTopRatedMovieList();
    }
}

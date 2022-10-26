package com.themoviedbmovieapps.Services.Repository;

import androidx.lifecycle.MutableLiveData;

import com.themoviedbmovieapps.Services.Model.Result;

import java.util.List;

public interface MovieRepository {

    public MutableLiveData<List<Result>> getTopRatedMovieList();
}

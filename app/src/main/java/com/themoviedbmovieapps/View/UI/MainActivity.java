package com.themoviedbmovieapps.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.themoviedbmovieapps.R;
import com.themoviedbmovieapps.Services.Model.Result;
import com.themoviedbmovieapps.View.Adapter.TopMovieListAdapter;
import com.themoviedbmovieapps.ViewModel.MovieListViewModel;
import com.themoviedbmovieapps.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerView recyclerView;
    MovieListViewModel mViewModel;
    TopMovieListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView= binding.recyclerviewId;
//        GridLayoutManager layoutManager= new GridLayoutManager(this,2);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mViewModel= new ViewModelProvider(this).get(MovieListViewModel.class);
        mViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                mListAdapter= new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setAdapter(mListAdapter);
            }
        });
    }
}
package com.themoviedbmovieapps.View.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.themoviedbmovieapps.R;
import com.themoviedbmovieapps.Services.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.mViewHolder>{
    Context context;
    List<Result> mResultList;

    public TopMovieListAdapter(Context context, List<Result> mResultList) {
        this.context = context;
        this.mResultList = mResultList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_single_row,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.movieName.setText(mResultList.get(position).getTitle());
        holder.rating.setText(mResultList.get(position).getVoteAverage().toString()+"");
        holder.release.setText(mResultList.get(position).getReleaseDate());
        String address= "https://api.themoviedb.org/3/movie/"+mResultList.get(position).getId()+mResultList.get(position).getPosterPath()+"?api_key=ac5f083985e059dd57bfcca6d052f746&language=en-US";
        Glide.with(context).load(address).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mResultList.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView movieName, rating, release;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            movieName= itemView.findViewById(R.id.titleName);
            rating= itemView.findViewById(R.id.rating);
            release= itemView.findViewById(R.id.releaseDate);
        }
    }
}

package com.example.ytsmovie.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.ytsmovie.DetailActivity;
import com.example.ytsmovie.R;
import com.example.ytsmovie.models.Movie;
import com.example.ytsmovie.models.YtsData;
import com.example.ytsmovie.utils.Define;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private static final String TAG = MovieAdapter.class.getName();
    private Context context;

    public MovieAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View movieItemView = inflater.inflate(R.layout.item_movie_card, parent, false);


        return new MyViewHolder(movieItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Define.PARAM_MOVIE_OBJ, movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    // ?????? ?????????
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView posterIv;
        TextView titleTv;
        TextView ratingTv;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"aaaaaaa");
                }
            });
        }

        public void setItem(Movie movie) {
            titleTv.setText(movie.getTitle());
            ratingTv.setText(String.valueOf(movie.getRating()));
            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new CenterCrop(),new RoundedCorners(20))
                    .into(posterIv);
            Log.d(TAG, "movie.getRating() : " + movie.getRating());
            ratingBar.setRating(movie.getRating());

        }
    }

    // ???????????? ???????????? ???????????? ?????? ???????????? ???????????? ?????? ?????? ??????.
    @SuppressLint("NotifyDataSetChanged")
    public void addItems(List<Movie> list) {
        this.list = list;

        this.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void EachItem(Movie movie){
        this.list.add(movie);
        this.notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItem(List<Movie> addList) {
        this.list.addAll(list.size(), addList);
        this.notifyDataSetChanged();
    }
}

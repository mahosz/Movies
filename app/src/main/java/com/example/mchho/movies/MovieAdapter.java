package com.example.mchho.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by mchho on 05/10/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<Result> resultList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, rating;
        private ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.movie_title);
            rating = (TextView) view.findViewById(R.id.movie_rating);
            photo = (ImageView) view.findViewById(R.id.movie_poster);
        }
    }


    public MovieAdapter(Context context, List<Result> resultList) {
        this.resultList = resultList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.title.setText(result.getTitle());
        holder.rating.setText(result.getVoteAverage().toString());
        Glide.with(context).load("https://image.tmdb.org/t/p/w1280"+result.getPosterPath()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}

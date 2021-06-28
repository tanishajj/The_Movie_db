package com.example.themoviedb.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themoviedb.R;
import com.example.themoviedb.model.MovieModel;
import com.example.themoviedb.utils.Credentials;
import com.example.themoviedb.utils.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.ViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public PopularMovieAdapter(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
    }

    @NonNull
    @Override
    public PopularMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_popular, parent, false);
        return new PopularMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMovieAdapter.ViewHolder holder, int position) {

        final MovieModel movieModel = movieModelArrayList.get(position);

        if(!TextUtils.isEmpty(movieModel.getTitle())) {
            holder.txt_popular_title.setText(movieModel.getTitle());
        }
        String poster = movieModel.getPoster_path();
        Glide.with(holder.itemView).load(Credentials.MOVIE_BASE_URL + poster).into(holder.img_popular);

        holder.layout_popular.setTag(movieModel);

    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_popular_title;
        ImageView img_popular;
        RelativeLayout layout_popular;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_popular_title = itemView.findViewById(R.id.txt_popular_title);
            img_popular = itemView.findViewById(R.id.img_popular);
            layout_popular = itemView.findViewById(R.id.layout_popular);

            layout_popular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), v);
                    }
                }
            });

        }
    }
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}

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

public class PlayingMovieAdapter extends RecyclerView.Adapter<PlayingMovieAdapter.ViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public PlayingMovieAdapter(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
    }

    @NonNull
    @Override
    public PlayingMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_playing, parent, false);
        return new PlayingMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayingMovieAdapter.ViewHolder holder, int position) {

        final MovieModel movieModel = movieModelArrayList.get(position);

        if(!TextUtils.isEmpty(movieModel.getTitle())) {
            holder.txt_playing_title.setText(movieModel.getTitle());
        }
        String poster = movieModel.getPoster_path();
        Glide.with(holder.itemView).load(Credentials.MOVIE_BASE_URL + poster).into(holder.img_playing);

        holder.layout_playing.setTag(movieModel);

    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_playing_title;
        ImageView img_playing;
        RelativeLayout layout_playing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_playing_title = itemView.findViewById(R.id.txt_playing_title);
            img_playing = itemView.findViewById(R.id.img_playing);
            layout_playing = itemView.findViewById(R.id.layout_playing);

            layout_playing.setOnClickListener(new View.OnClickListener() {
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

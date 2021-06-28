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

public class UpcomingMovieAdapter extends RecyclerView.Adapter<UpcomingMovieAdapter.ViewHolder>{

    private ArrayList<MovieModel> movieModelArrayList;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public UpcomingMovieAdapter(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
    }

    @NonNull
    @Override
    public UpcomingMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_upcoming, parent, false);
        return new UpcomingMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMovieAdapter.ViewHolder holder, int position) {

        final MovieModel movieModel = movieModelArrayList.get(position);

        if(!TextUtils.isEmpty(movieModel.getTitle())) {
            holder.txt_upcoming_title.setText(movieModel.getTitle());
        }
        String poster = movieModel.getPoster_path();
        Glide.with(holder.itemView).load(Credentials.MOVIE_BASE_URL + poster).into(holder.img_upcoming);

        holder.layout_upcoming.setTag(movieModel);


    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView txt_upcoming_title;
        ImageView img_upcoming;
        RelativeLayout layout_upcoming;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_upcoming_title = itemView.findViewById(R.id.txt_upcoming_title);
            img_upcoming = itemView.findViewById(R.id.img_upcoming);
            layout_upcoming = itemView.findViewById(R.id.layout_upcoming);

            layout_upcoming.setOnClickListener(new View.OnClickListener() {
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

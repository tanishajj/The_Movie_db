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

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.ViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public TopMovieAdapter(ArrayList<MovieModel> movieModelArrayList) {
        this.movieModelArrayList = movieModelArrayList;
    }

    @NonNull
    @Override
    public TopMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_top, parent, false);
        return new TopMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieAdapter.ViewHolder holder, int position) {

        final MovieModel movieModel = movieModelArrayList.get(position);

        if(!TextUtils.isEmpty(movieModel.getTitle())) {
            holder.txt_top_title.setText(movieModel.getTitle());
        }
        String poster = movieModel.getPoster_path();
        Glide.with(holder.itemView).load(Credentials.MOVIE_BASE_URL + poster).into(holder.img_top);

        holder.layout_top.setTag(movieModel);

    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_top_title;
        ImageView img_top;
        RelativeLayout layout_top;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_top_title = itemView.findViewById(R.id.txt_top_title);
            img_top = itemView.findViewById(R.id.img_top);
            layout_top = itemView.findViewById(R.id.layout_top);

            layout_top.setOnClickListener(new View.OnClickListener() {
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

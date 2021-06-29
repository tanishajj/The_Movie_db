package com.example.themoviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.themoviedb.adapter.PlayingMovieAdapter;
import com.example.themoviedb.adapter.PopularMovieAdapter;
import com.example.themoviedb.adapter.TopMovieAdapter;
import com.example.themoviedb.adapter.UpcomingMovieAdapter;
import com.example.themoviedb.model.MovieModel;
import com.example.themoviedb.model.MovieResponseModel;
import com.example.themoviedb.rests.ApiClient;
import com.example.themoviedb.rests.ApiInterface;
import com.example.themoviedb.utils.Credentials;
import com.example.themoviedb.utils.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    private static final String API_KEY = "a985a1d6f6144f16f45adb6f37d811b3";
    RecyclerView recyclerview_popular, recyclerview_playing, recyclerview_top, recyclerview_upcoming;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview_popular = findViewById(R.id.recyclerview_popular);
        recyclerview_popular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerview_playing = findViewById(R.id.recyclerview_playing);
        recyclerview_playing.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerview_top = findViewById(R.id.recyclerview_top);
        recyclerview_top.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerview_upcoming = findViewById(R.id.recyclerview_upcoming);
        recyclerview_upcoming.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        getPopularMovies();
        getPlayingMovies();
        getTopMovies();
        getUpcomingMovies();

    }

    public void getPopularMovies(){

        Call<MovieResponseModel> responseCall = apiInterface.getPopularMovie(API_KEY,"en-US","1");
        responseCall.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {

                List<MovieModel> movieModelList = response.body().getMovies();
                final PopularMovieAdapter popularMovieAdapter = new PopularMovieAdapter((ArrayList<MovieModel>) movieModelList);
                popularMovieAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                recyclerview_popular.setAdapter(popularMovieAdapter);

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {

            }
        });

    }

    public void getPlayingMovies(){

        Call<MovieResponseModel> responseCall = apiInterface.getPlayingMovie(API_KEY,"en-US","2");
        responseCall.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {

                List<MovieModel> movieModelList = response.body().getMovies();
                final PlayingMovieAdapter playingMovieAdapter = new PlayingMovieAdapter((ArrayList<MovieModel>) movieModelList);
                playingMovieAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                recyclerview_playing.setAdapter(playingMovieAdapter);

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {

            }
        });

    }

    public void getTopMovies(){

        Call<MovieResponseModel> responseCall = apiInterface.getTopMovie(API_KEY,"en-US","1");
        responseCall.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {

                List<MovieModel> movieModelList = response.body().getMovies();
                final TopMovieAdapter topMovieAdapter = new TopMovieAdapter((ArrayList<MovieModel>) movieModelList);
                topMovieAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                recyclerview_top.setAdapter(topMovieAdapter);

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {

            }
        });

    }

    public void getUpcomingMovies(){

        Call<MovieResponseModel> responseCall = apiInterface.getUpcomingMovie(API_KEY,"en-US","1");
        responseCall.enqueue(new Callback<MovieResponseModel>() {
            @Override
            public void onResponse(Call<MovieResponseModel> call, Response<MovieResponseModel> response) {

                List<MovieModel> movieModelList = response.body().getMovies();
                final UpcomingMovieAdapter upcomingMovieAdapter = new UpcomingMovieAdapter((ArrayList<MovieModel>) movieModelList);
                upcomingMovieAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                recyclerview_upcoming.setAdapter(upcomingMovieAdapter);

            }

            @Override
            public void onFailure(Call<MovieResponseModel> call, Throwable t) {

            }
        });

    }


    @Override
    public void onItemClick(int adapterPosition, View v) {

        switch (v.getId()){
            case R.id.layout_popular:
                MovieModel movieModelPopular = (MovieModel) v.getTag();
                if(!TextUtils.isEmpty(movieModelPopular.getTitle())) {
                    Intent webActivity = new Intent(this,MovieDetailsActivity.class);
                    webActivity.putExtra("title",movieModelPopular.getTitle());
                    webActivity.putExtra("date",movieModelPopular.getRelease_date());
                    webActivity.putExtra("average",movieModelPopular.getVote_average());
                    webActivity.putExtra("overview",movieModelPopular.getOverview());
                    webActivity.putExtra("language",movieModelPopular.getOriginal_language());
                    webActivity.putExtra("path",Credentials.MOVIE_BASE_URL + movieModelPopular.getPoster_path());
                    startActivity(webActivity);
                }
                break;
            case R.id.layout_playing:
                MovieModel movieModelPlaying = (MovieModel) v.getTag();
                if(!TextUtils.isEmpty(movieModelPlaying.getTitle())) {
                    Intent webActivity = new Intent(this,MovieDetailsActivity.class);
                    webActivity.putExtra("title1",movieModelPlaying.getTitle());
                    webActivity.putExtra("date1",movieModelPlaying.getRelease_date());
                    webActivity.putExtra("average1",movieModelPlaying.getVote_average());
                    webActivity.putExtra("overview1",movieModelPlaying.getOverview());
                    webActivity.putExtra("language1",movieModelPlaying.getOriginal_language());
                    webActivity.putExtra("path1",Credentials.MOVIE_BASE_URL + movieModelPlaying.getPoster_path());
                    startActivity(webActivity);
                }
                break;
            case R.id.layout_top:
                MovieModel movieModelTop = (MovieModel) v.getTag();
                if(!TextUtils.isEmpty(movieModelTop.getTitle())) {
                    Intent webActivity = new Intent(this,MovieDetailsActivity.class);
                    webActivity.putExtra("title2",movieModelTop.getTitle());
                    webActivity.putExtra("date2",movieModelTop.getRelease_date());
                    webActivity.putExtra("average2",movieModelTop.getVote_average());
                    webActivity.putExtra("overview2",movieModelTop.getOverview());
                    webActivity.putExtra("language2",movieModelTop.getOriginal_language());
                    webActivity.putExtra("path2",Credentials.MOVIE_BASE_URL + movieModelTop.getPoster_path());
                    startActivity(webActivity);
                }
                break;
            case R.id.layout_upcoming:
                MovieModel movieModelUpcoming = (MovieModel) v.getTag();
                if(!TextUtils.isEmpty(movieModelUpcoming.getTitle())) {
                    Intent webActivity = new Intent(this,MovieDetailsActivity.class);
                    webActivity.putExtra("title3",movieModelUpcoming.getTitle());
                    webActivity.putExtra("date3",movieModelUpcoming.getRelease_date());
                    webActivity.putExtra("average3",movieModelUpcoming.getVote_average());
                    webActivity.putExtra("overview3",movieModelUpcoming.getOverview());
                    webActivity.putExtra("language3",movieModelUpcoming.getOriginal_language());
                    webActivity.putExtra("path3",Credentials.MOVIE_BASE_URL + movieModelUpcoming.getPoster_path());
                    startActivity(webActivity);
                }
                break;
        }
    }
}
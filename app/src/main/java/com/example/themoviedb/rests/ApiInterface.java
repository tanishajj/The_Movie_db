package com.example.themoviedb.rests;

import com.example.themoviedb.model.MovieResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("3/movie/popular")
    Call<MovieResponseModel> getPopularMovie (@Query("api_key") String key,
                                              @Query("language") String language,
                                              @Query("page") String page);

    @GET("3/movie/now_playing")
    Call<MovieResponseModel> getPlayingMovie (@Query("api_key") String key,
                                              @Query("language") String language,
                                              @Query("page") String page);

    @GET("3/movie/top_rated")
    Call<MovieResponseModel> getTopMovie (@Query("api_key") String key,
                                              @Query("language") String language,
                                              @Query("page") String page);

    @GET("3/movie/upcoming")
    Call<MovieResponseModel> getUpcomingMovie (@Query("api_key") String key,
                                          @Query("language") String language,
                                          @Query("page") String page);



}

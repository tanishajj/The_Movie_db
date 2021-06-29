package com.example.themoviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView txt_title, txt_language, txt_release_date, txt_vote_average, txt_overview;
    ImageView image;
    String title,language,date,average,overview,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        txt_title = findViewById(R.id.txt_title);
        txt_language = findViewById(R.id.txt_language);
        txt_release_date = findViewById(R.id.txt_release_date);
        txt_vote_average = findViewById(R.id.txt_vote_average);
        txt_overview = findViewById(R.id.txt_overview);
        image = findViewById(R.id.image);

        if(title == getIntent().getAction()){
            detailPopular();
        }
        if(title == getIntent().getAction()){
            detailPlaying();
        }
        if(title == getIntent().getAction()){
            detailTop();
        }
        if(title == getIntent().getAction()){
            detailUpcoming();
        }
    }

    public void detailPopular(){
        title = getIntent().getStringExtra("title");
        txt_title.setText(title);
        language = getIntent().getStringExtra("language");
        txt_language.setText(language);
        date = getIntent().getStringExtra("date");
        txt_release_date.setText(date);
        average = getIntent().getStringExtra("average");
        txt_vote_average.setText(average);
        overview = getIntent().getStringExtra("overview");
        txt_overview.setText(overview);
        img = getIntent().getStringExtra("path");
        Glide.with(this).load(img).into(image);
    }
    public void detailPlaying(){
        title = getIntent().getStringExtra("title1");
        txt_title.setText(title);
        language = getIntent().getStringExtra("language1");
        txt_language.setText(language);
        date = getIntent().getStringExtra("date1");
        txt_release_date.setText(date);
        average = getIntent().getStringExtra("average1");
        txt_vote_average.setText(average);
        overview = getIntent().getStringExtra("overview1");
        txt_overview.setText(overview);
        img = getIntent().getStringExtra("path1");
        Glide.with(this).load(img).into(image);
    }
    public void detailTop(){
        title = getIntent().getStringExtra("title2");
        txt_title.setText(title);
        language = getIntent().getStringExtra("language2");
        txt_language.setText(language);
        date = getIntent().getStringExtra("date2");
        txt_release_date.setText(date);
        average = getIntent().getStringExtra("average2");
        txt_vote_average.setText(average);
        overview = getIntent().getStringExtra("overview2");
        txt_overview.setText(overview);
        img = getIntent().getStringExtra("path2");
        Glide.with(this).load(img).into(image);
    }
    public void detailUpcoming(){
        title = getIntent().getStringExtra("title3");
        txt_title.setText(title);
        language = getIntent().getStringExtra("language3");
        txt_language.setText(language);
        date = getIntent().getStringExtra("date3");
        txt_release_date.setText(date);
        average = getIntent().getStringExtra("average3");
        txt_vote_average.setText(average);
        overview = getIntent().getStringExtra("overview3");
        txt_overview.setText(overview);
        img = getIntent().getStringExtra("path3");
        Glide.with(this).load(img).into(image);
    }
}
package com.example.themoviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView txt_title, txt_release_date, txt_vote_average, txt_overview;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        txt_title = findViewById(R.id.txt_title);
        txt_release_date = findViewById(R.id.txt_release_date);
        txt_vote_average = findViewById(R.id.txt_vote_average);
        txt_overview = findViewById(R.id.txt_overview);
        image = findViewById(R.id.image);

        detailPopular();
//        detailPlaying();
//        detailTop();
//        detailUpcoming();
    }

    public void detailPopular(){
        String title,date,average,overview,img;
        title = getIntent().getStringExtra("title");
        txt_title.setText(title);
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
        String title1,date1,average1,overview1,img1;
        title1 = getIntent().getStringExtra("title1");
        txt_title.setText(title1);
        date1 = getIntent().getStringExtra("date1");
        txt_release_date.setText(date1);
        average1 = getIntent().getStringExtra("average1");
        txt_vote_average.setText(average1);
        overview1 = getIntent().getStringExtra("overview1");
        txt_overview.setText(overview1);
        img1 = getIntent().getStringExtra("path1");
        Glide.with(this).load(img1).into(image);
    }
    public void detailTop(){
        String title2,date2,average2,overview2,img2;
        title2 = getIntent().getStringExtra("title2");
        txt_title.setText(title2);
        date2 = getIntent().getStringExtra("date2");
        txt_release_date.setText(date2);
        average2 = getIntent().getStringExtra("average2");
        txt_vote_average.setText(average2);
        overview2 = getIntent().getStringExtra("overview2");
        txt_overview.setText(overview2);
        img2 = getIntent().getStringExtra("path2");
        Glide.with(this).load(img2).into(image);
    }
    public void detailUpcoming(){
        String title3,date3,average3,overview3,img3;
        title3 = getIntent().getStringExtra("title3");
        txt_title.setText(title3);
        date3 = getIntent().getStringExtra("date3");
        txt_release_date.setText(date3);
        average3 = getIntent().getStringExtra("average3");
        txt_vote_average.setText(average3);
        overview3 = getIntent().getStringExtra("overview3");
        txt_overview.setText(overview3);
        img3 = getIntent().getStringExtra("path3");
        Glide.with(this).load(img3).into(image);
    }
}
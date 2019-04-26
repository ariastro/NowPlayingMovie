package com.astronout.nowplayingmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_overview)
    TextView detailOverview;
    @BindView(R.id.detail_poster)
    ImageView detailPoster;
    @BindView(R.id.detail_rating)
    TextView detailRating;
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.backdrop_movie)
    ImageView backdropMovie;
    @BindView(R.id.detail_release_date)
    TextView detailReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("EXTRA_TITLE");
        String releaseDate = intent.getExtras().getString("EXTRA_RELEASE_DATE");
        String overview = intent.getExtras().getString("EXTRA_OVERVIEW");
        Double ratingMovie = intent.getExtras().getDouble("EXTRA_RATING");
        String rating = ratingMovie.toString();
        String poster = intent.getExtras().getString("EXTRA_POSTER");
        String backdrop = intent.getExtras().getString("EXTRA_BACKDROP");

        Glide.with(this)
                .load(poster)
                .into(detailPoster);
        Glide.with(this)
                .load(backdrop)
                .into(backdropMovie);

        detailOverview.setText(overview);
        detailRating.setText("Rating : "+rating + "/10");
        detailReleaseDate.setText("Release Date :" + releaseDate);
        detailTitle.setText(title);

        if (getSupportActionBar()!= null) {
            getSupportActionBar().setTitle(title);
        }

    }
}

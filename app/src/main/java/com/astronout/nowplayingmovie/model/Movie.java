package com.astronout.nowplayingmovie.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("original_title")
    private String mTitle;
    @SerializedName("vote_average")
    private Double mRating;
    @SerializedName("poster_path")
    private String mPoster;
    @SerializedName("backdrop_path")
    private String mBackdrop;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("overview")
    private String mOverview;

    public Movie(String mTitle, Double mRating, String mPoster, String mBackdrop, String mReleaseDate, String mOverview) {
        this.mTitle = mTitle;
        this.mRating = mRating;
        this.mPoster = mPoster;
        this.mBackdrop = mBackdrop;
        this.mReleaseDate = mReleaseDate;
        this.mOverview = mOverview;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Double getmRating() {
        return mRating;
    }

    public void setmRating(Double mRating) {
        this.mRating = mRating;
    }

    public String getmPoster() {
        return "https://image.tmdb.org/t/p/w500" + mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public String getmBackdrop() {
        return "https://image.tmdb.org/t/p/w500/" + mBackdrop;
    }

    public void setmBackdrop(String mBackdrop) {
        this.mBackdrop = mBackdrop;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }
}

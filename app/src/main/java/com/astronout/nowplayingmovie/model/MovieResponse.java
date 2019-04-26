package com.astronout.nowplayingmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    private List<Movie> mResult;

    public List<Movie> getmResult() {
        return mResult;
    }

    public void setmResult(List<Movie> mResult) {
        this.mResult = mResult;
    }
}

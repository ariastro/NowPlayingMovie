package com.astronout.nowplayingmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.astronout.nowplayingmovie.DetailActivity;
import com.astronout.nowplayingmovie.R;
import com.astronout.nowplayingmovie.model.Movie;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleMovie.setText(movieList.get(position).getmTitle());
        holder.overviewMovie.setText(movieList.get(position).getmOverview());
        String rating = Double.toString(movieList.get(position).getmRating());
        holder.ratingMovie.setText(rating);

        Glide.with(context)
                .load(movieList.get(position).getmPoster())
                .into(holder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.title_movie)
        TextView titleMovie;
        @BindView(R.id.rating_movie)
        TextView ratingMovie;
        @BindView(R.id.img_movie)
        ImageView imgMovie;
        @BindView(R.id.overview_movie)
        TextView overviewMovie;

        public ViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
//                    Toast.makeText(context, movieList.get(pos).getmTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("EXTRA_TITLE", movieList.get(pos).getmTitle());
                    intent.putExtra("EXTRA_POSTER", movieList.get(pos).getmPoster());
                    intent.putExtra("EXTRA_BACKDROP", movieList.get(pos).getmBackdrop());
                    intent.putExtra("EXTRA_RATING", movieList.get(pos).getmRating());
                    intent.putExtra("EXTRA_RELEASE_DATE", movieList.get(pos).getmReleaseDate());
                    intent.putExtra("EXTRA_OVERVIEW", movieList.get(pos).getmOverview());
                    context.startActivity(intent);

                }
            });
        }
    }

}

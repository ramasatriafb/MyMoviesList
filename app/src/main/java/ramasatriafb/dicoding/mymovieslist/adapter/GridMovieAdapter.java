package ramasatriafb.dicoding.mymovieslist.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import ramasatriafb.dicoding.mymovieslist.R;

import ramasatriafb.dicoding.mymovieslist.data.MovieData;
import ramasatriafb.dicoding.mymovieslist.detail.DetailMovieActivity;

public class GridMovieAdapter extends RecyclerView.Adapter<GridMovieAdapter.GridViewHolder>{

    public GridMovieAdapter() {

    }

    public ArrayList<MovieData> getMovieData() {
        return movieData;
    }

    public void setMovieData(ArrayList<MovieData> movieData) {
        this.movieData = movieData;
    }

    private ArrayList<MovieData> movieData;

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_movie, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, final int position) {



        Glide.with(holder.itemView.getContext())
                .load(movieData.get(position).getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPosterMovie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithObjectIntent = new Intent(v.getContext(), DetailMovieActivity.class);
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, getMovieData().get(position));
                v.getContext().startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPosterMovie;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPosterMovie = itemView.findViewById(R.id.img_poster_movie);
        }
    }
}

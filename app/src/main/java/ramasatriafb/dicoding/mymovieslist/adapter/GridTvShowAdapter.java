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
import ramasatriafb.dicoding.mymovieslist.data.TvShowData;
import ramasatriafb.dicoding.mymovieslist.detail.DetailTvShowActivity;

public class GridTvShowAdapter extends RecyclerView.Adapter<GridTvShowAdapter.GridViewHolder>{

    public GridTvShowAdapter() {

    }

    public ArrayList<TvShowData> getTvShowData() {
        return tvShowData;
    }

    public void setTvShowData(ArrayList<TvShowData> tvShowData) {
        this.tvShowData = tvShowData;
    }

    private ArrayList<TvShowData> tvShowData;

    @NonNull
    @Override
    public GridTvShowAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_tvshow, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridTvShowAdapter.GridViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(tvShowData.get(position).getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPosterTvShow);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithObjectIntent = new Intent(v.getContext(), DetailTvShowActivity.class);
                moveWithObjectIntent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, getTvShowData().get(position));
                v.getContext().startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShowData.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPosterTvShow;

        GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPosterTvShow = itemView.findViewById(R.id.img_poster_tvshow);
        }
    }
}

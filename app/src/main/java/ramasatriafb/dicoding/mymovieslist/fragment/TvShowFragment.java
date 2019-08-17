package ramasatriafb.dicoding.mymovieslist.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ramasatriafb.dicoding.mymovieslist.R;
import ramasatriafb.dicoding.mymovieslist.adapter.GridTvShowAdapter;
import ramasatriafb.dicoding.mymovieslist.data.TvShowData;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private ArrayList<TvShowData> tvShows = new ArrayList<>();


    private String[] dataTitle;
    private String[] dataReleaseDate;
    private String[] dataGenre;
    private String[] dataRating;
    private String[] dataSynopsis;
    private TypedArray dataPoster;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prepareDataTvShow();
        addTvShow();
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_tvshow);
        GridTvShowAdapter gridTvShowAdapter = new GridTvShowAdapter();
        gridTvShowAdapter.setTvShowData(tvShows);
        recyclerView.setAdapter(gridTvShowAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    private void prepareDataTvShow() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tvshow);
        dataTitle = getResources().getStringArray(R.array.data_title_tvshow);
        dataReleaseDate = getResources().getStringArray(R.array.data_releasedate_tvshow);
        dataGenre = getResources().getStringArray(R.array.data_genre_tvshow);
        dataRating = getResources().getStringArray(R.array.data_rating_tvshow);
        dataSynopsis = getResources().getStringArray(R.array.data_synopsis_tvshow);

    }

    //method addTvShow digunakan untuk menyimpan semua data yangg telah berisi data dummy dalam sebuah array list agar dapat diproses oleh TvShowAdapter
    private void addTvShow() {
        tvShows = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            TvShowData tvShowData = new TvShowData();
            tvShowData.setPoster(dataPoster.getResourceId(i, -1));
            tvShowData.setTitle(dataTitle[i]);
            tvShowData.setReleaseDate(dataReleaseDate[i]);
            tvShowData.setGenre(dataGenre[i]);
            tvShowData.setRating(dataRating[i]+"%");
            tvShowData.setSynopsis(dataSynopsis[i]);
            tvShows.add(tvShowData);
        }
    }

}

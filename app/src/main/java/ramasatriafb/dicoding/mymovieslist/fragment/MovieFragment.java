package ramasatriafb.dicoding.mymovieslist.fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ramasatriafb.dicoding.mymovieslist.R;
import ramasatriafb.dicoding.mymovieslist.adapter.GridMovieAdapter;
import ramasatriafb.dicoding.mymovieslist.data.MovieData;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private ArrayList<MovieData> movies = new ArrayList<>();


    private String[] dataTitle;
    private String[] dataReleaseDate;
    private String[] dataGenre;
    private String[] dataRating;
    private String[] dataSynopsis;
    private TypedArray dataPoster;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prepareDataMovie();
        addMovie();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_movie);

        GridMovieAdapter gridMovieAdapter = new GridMovieAdapter();
        gridMovieAdapter.setMovieData(movies);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        return view;
    }

    private void prepareDataMovie() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_movie);
        dataTitle = getResources().getStringArray(R.array.data_title_movie);
        dataReleaseDate = getResources().getStringArray(R.array.data_releasedate_movie);
        dataGenre = getResources().getStringArray(R.array.data_genre_movie);
        dataRating = getResources().getStringArray(R.array.data_rating_movie);
        dataSynopsis = getResources().getStringArray(R.array.data_synopsis_movie);

    }

    //method addMovie digunakan untuk menyimpan semua data yangg telah berisi data dummy dalam sebuah array list agar dapat diproses oleh GridMovieAdapter
    private void addMovie() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            MovieData movieData = new MovieData();
            movieData.setPoster(dataPoster.getResourceId(i, -1));
            movieData.setTitle(dataTitle[i]);
            movieData.setReleaseDate(dataReleaseDate[i]);
            movieData.setGenre(dataGenre[i]);
            movieData.setRating(dataRating[i]+"%");
            movieData.setSynopsis(dataSynopsis[i]);
            movies.add(movieData);
        }
    }


}

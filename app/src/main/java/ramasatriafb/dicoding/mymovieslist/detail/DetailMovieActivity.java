package ramasatriafb.dicoding.mymovieslist.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ramasatriafb.dicoding.mymovieslist.R;
import ramasatriafb.dicoding.mymovieslist.data.MovieData;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    //inisialisasi obyek detail activity
    private ImageView posterMovie;
    private ImageView posterMovieSmall;
    TextView titleMovie;
    TextView releaseDateMovie;
    TextView genreMovie;
    TextView ratingMovie;
    TextView synopsisMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        //mengaktifikan actionbar back home
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        posterMovie = findViewById(R.id.img_poster_movie);
        posterMovieSmall = findViewById(R.id.img_poster_movie_small);
        titleMovie = findViewById(R.id.tv_title_movie);
        releaseDateMovie = findViewById(R.id.tv_releaseDate_movie);
        genreMovie = findViewById(R.id.tv_genre_movie);
        ratingMovie = findViewById(R.id.tv_rating_movie);
        synopsisMovie = findViewById(R.id.tv_synopsis_movie);

        //Menerima objek intent dari Main Activity
        MovieData movieData = getIntent().getParcelableExtra(EXTRA_MOVIE);
        //Menyeting nilai Obyek Detail Activity dengan nilai Obyek Movie Data dari obyek Intent
        posterMovie.setImageResource(movieData.getPoster());
        posterMovieSmall.setImageResource(movieData.getPoster());
        posterMovie.setAdjustViewBounds(true);
        posterMovie.setScaleType(ImageView.ScaleType.CENTER_CROP);
        titleMovie.setText(movieData.getTitle());
        releaseDateMovie.setText(movieData.getReleaseDate());
        genreMovie.setText(movieData.getGenre());
        ratingMovie.setText(movieData.getRating());
        synopsisMovie.setText(movieData.getSynopsis());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ) {
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }


}

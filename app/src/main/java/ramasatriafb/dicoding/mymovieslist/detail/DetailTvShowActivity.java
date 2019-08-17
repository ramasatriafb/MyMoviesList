package ramasatriafb.dicoding.mymovieslist.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import ramasatriafb.dicoding.mymovieslist.R;
import ramasatriafb.dicoding.mymovieslist.data.TvShowData;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_TVSHOW";

    //inisialisasi obyek detail activity
    private ImageView posterTvShow;
    private ImageView posterTvShowSmall;
    TextView titleTvShow;
    TextView releaseDateTvShow;
    TextView genreTvShow;
    TextView ratingTvShow;
    TextView synopsisTvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        //mengaktifikan actionbar back home
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        posterTvShow = findViewById(R.id.img_poster_tvshow);
        posterTvShowSmall = findViewById(R.id.img_poster_tvshow_small);
        titleTvShow = findViewById(R.id.tv_title_tvshow);
        releaseDateTvShow = findViewById(R.id.tv_releaseDate_tvshow);
        genreTvShow = findViewById(R.id.tv_genre_tvshow);
        ratingTvShow = findViewById(R.id.tv_rating_tvshow);
        synopsisTvShow = findViewById(R.id.tv_synopsis_tvshow);

        //Menerima objek intent dari Main Activity
        TvShowData TvShowData = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        //Menyeting nilai Obyek Detail Activity dengan nilai Obyek Tv Show Data dari obyek Intent
        posterTvShow.setImageResource(TvShowData.getPoster());
        posterTvShowSmall.setImageResource(TvShowData.getPoster());
        posterTvShow.setAdjustViewBounds(true);
        posterTvShow.setScaleType(ImageView.ScaleType.CENTER_CROP);
        titleTvShow.setText(TvShowData.getTitle());
        releaseDateTvShow.setText(TvShowData.getReleaseDate());
        genreTvShow.setText(TvShowData.getGenre());
        ratingTvShow.setText(TvShowData.getRating());
        synopsisTvShow.setText(TvShowData.getSynopsis());
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

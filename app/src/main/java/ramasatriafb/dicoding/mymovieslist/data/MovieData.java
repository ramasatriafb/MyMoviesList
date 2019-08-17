package ramasatriafb.dicoding.mymovieslist.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {

    //Inisialisasi data
    public String Title;
    public int Poster;
    public String Genre;
    public String Rating;
    public String ReleaseDate;
    public String Synopsis;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPoster() {
        return Poster;
    }

    public void setPoster(int poster) {
        Poster = poster;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public MovieData(){

    }

    protected MovieData(Parcel in) {
        Title = in.readString();
        Poster = in.readInt();
        Genre = in.readString();
        Rating = in.readString();
        ReleaseDate = in.readString();
        Synopsis = in.readString();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeInt(Poster);
        dest.writeString(Genre);
        dest.writeString(Rating);
        dest.writeString(ReleaseDate);
        dest.writeString(Synopsis);
    }
}

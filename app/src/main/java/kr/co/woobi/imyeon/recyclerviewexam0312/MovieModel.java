package kr.co.woobi.imyeon.recyclerviewexam0312;

public class MovieModel {
    int movieImage;
    String title;
    double rating;


    public MovieModel(int movieImage, String title, double rating) {
        this.movieImage = movieImage;
        this.title = title;
        this.rating = rating;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

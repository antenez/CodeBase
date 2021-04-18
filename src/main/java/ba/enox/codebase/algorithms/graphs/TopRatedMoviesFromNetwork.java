package ba.enox.codebase.algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/*
 * Get top rated movies from network of movies.
 * Every node contains unique identifier and rating
 * design a way to return N highest rated movies in network of related movies without requested one.
 */
public class TopRatedMoviesFromNetwork {
  public class Movie {
    private int movieId;
    private float rating;
    private List<Movie> similarMovies; // Similarity is bidirectional

    public Movie(int movieId, float rating) {
      this.movieId = movieId;
      this.rating = rating;
      similarMovies = new ArrayList<Movie>();
    }

    public int getId() {
      return movieId;
    }

    public float getRating() {
      return rating;
    }

    public void addSimilarMovie(Movie movie) {
      similarMovies.add(movie);
      movie.similarMovies.add(this);
    }

    public List<Movie> getSimilarMovies() {
      return similarMovies;
    }
  }

  /*
   * Implement a function to return top rated movies in the network of movies
   * reachable from the current movie
   * eg:            A(Rating 1.2)
   *               /   \
   *            B(2.4)  C(3.6)
   *              \     /
   *               D(4.8)
   * In the above example edges represent similarity and the number is rating.
   * getMovieRecommendations(A,2)should return C and D (sorting order doesn't matter so it can also return D and C)
   * getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
   * getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter,
   *                            return the highest  rated.
   *
   *     @param movie
   *     @param numTopRatedSimilarMovies
   *                      number of movies we want to return
   *     @return List of top rated similar movies
   */

  public LinkedHashSet<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
    LinkedHashSet<Movie> visited = new LinkedHashSet<TopRatedMoviesFromNetwork.Movie>();
    return getMovieRecommendations(movie, numTopRatedSimilarMovies, visited);
  }

  public LinkedHashSet<Movie> getMovieRecommendations(
      Movie movie, int numTopRatedSimilarMovies, LinkedHashSet<Movie> visited) {

    visited.add(movie);
    for (Movie m : movie.getSimilarMovies()) {
      if (!visited.contains(m)) getMovieRecommendations(m, -1, visited);
    }
    if (numTopRatedSimilarMovies > -1) {
      System.out.println("+++ByRating descending+++");
      LinkedHashSet<Movie> sorted = new LinkedHashSet<>();
      visited.stream()
          .sorted(
              (Movie m1, Movie m2) -> {
                Float rating1 = Float.valueOf(m1.getRating());
                Float rating2 = Float.valueOf(m2.getRating());
                return rating2.compareTo(rating1);
              })
          .limit(numTopRatedSimilarMovies)
          .forEach(
              e -> {
                System.out.println("Movie ID " + e.movieId + " rating: " + e.getRating());
                sorted.add(e);
              });

      System.out.println("+++ByRating descending REPRINT to see persisted changes+++");
      visited.stream()
          .forEach(e -> System.out.println("Movie ID " + e.movieId + " rating: " + e.getRating()));

      System.out.println("+++Sorted descending REPRINT but only sorted limited+++");
      sorted.stream()
          .forEach(e -> System.out.println("Movie ID " + e.movieId + " rating: " + e.getRating()));
      return sorted;
    }
    return visited;
  }
}

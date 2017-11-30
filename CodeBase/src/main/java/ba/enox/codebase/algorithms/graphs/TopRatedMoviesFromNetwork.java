package ba.enox.codebase.algorithms.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Get top rated movies from network of movies.
 * Every node contains unique identifier and rating
 * design a way to return N highest rated movies in network of related movies without requested one.
 */
public class TopRatedMoviesFromNetwork {
	public class Movie{
		 private  int movieId;
	        private  float rating;
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
	        public SortedSet<Movie> visited = new TreeSet<TopRatedMoviesFromNetwork.Movie>();
	        public Set<Movie>getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies){
	       
	                visited.add(movie);
	                for (Movie m : movie.getSimilarMovies()){
	                    if (!visited.contains(m))
	                        getMovieRecommendations(m, -1);
	                }
	                if(numTopRatedSimilarMovies > -1)
	                    return null // TODO visited.
	                return null;
	            }

	}
	
	private boolean DepthFirstSearch(Movie movie,  Set sortedMovies, int numberOfRecomendations, HashSet<Integer> visited ){
		return true;
	}
	
	
}

package ba.enox.codebase.algorithms.graphs;

import java.util.Comparator;
import java.util.HashSet;
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
		int id;
		int rating;
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		Set<Movie>relatedMovies;
	}
	
	public Set<Movie>getMovieRecommendations(Movie movie, int numberOfRecomendations){
		
		SortedSet<Movie> sortedMovies = new  TreeSet<Movie>(new Comparator<Movie>() {			
			public int compare(Movie o1, Movie o2) {
				// TODO Auto-generated method stub
				return Integer.valueOf(o1.getRating()).compareTo(Integer.valueOf(o2.getRating()));
			};
		});
		
		HashSet<Integer>visited = new HashSet<Integer>();
		
		return null;
		
	}
	
	private boolean DepthFirstSearch(Movie movie,  Set sortedMovies, int numberOfRecomendations, HashSet<Integer> visited ){
		return true;
	}
	
	
}

package ba.enox.codebase.algorithms.graphs;

import static org.junit.Assert.*;
import ba.enox.codebase.algorithms.graphs.TopRatedMoviesFromNetwork.Movie;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TopRatedMoviesFromNetworkTest {
	TopRatedMoviesFromNetwork trm = new TopRatedMoviesFromNetwork();

	@Test
	public void test() {
		
		Movie m1 = trm.new Movie(1, 5);
		Movie m2 = trm.new Movie(2, 6);
		Movie m3 = trm.new Movie(3, 3);
		Movie m4 = trm.new Movie(4, 8);
		Movie m5 = trm.new Movie(5, 10);
		Movie m6 = trm.new Movie(6, 8);
		
		//1->(2,3)
		m1.addSimilarMovie(m2);
		m1.addSimilarMovie(m3);
		//2->(4,5);
		m2.addSimilarMovie(m4);
		m2.addSimilarMovie(m5);
		
		//3 -> 6
		m3.addSimilarMovie(m6);
		
		Set<Movie> s =  new HashSet<>();
		s.add(m1);
		s.add(m2);
		s.add(m3);
		
		
		trm.getMovieRecommendations(m1, 2);
		
		
		fail("Not yet implemented");
	}
	
	private Set<Movie> prepareRelatedMovies(){
		Movie m1 = trm.new Movie(1, 5);
		Movie m2 = trm.new Movie(2, 6);
		Movie m3 = trm.new Movie(3, 3);
		Movie m4 = trm.new Movie(4, 8);
		Movie m5 = trm.new Movie(5, 10);
		Movie m6 = trm.new Movie(6, 8);
		
		//1->(2,3)
		m1.addSimilarMovie(m2);
		m1.addSimilarMovie(m3);
		//2->(4,5);
		m2.addSimilarMovie(m4);
		m2.addSimilarMovie(m5);
		
		//3 -> 6
		m3.addSimilarMovie(m6);
		
		Set<Movie> s =  new HashSet<>();
		s.add(m1);
		s.add(m2);
		s.add(m3);
		return s;
	}

}

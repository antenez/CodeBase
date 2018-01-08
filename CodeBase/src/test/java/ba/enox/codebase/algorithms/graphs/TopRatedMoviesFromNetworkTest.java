package ba.enox.codebase.algorithms.graphs;

import static org.junit.Assert.*;
import ba.enox.codebase.algorithms.graphs.TopRatedMoviesFromNetwork.Movie;

import java.util.HashSet;
import java.util.LinkedHashSet;
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
		
		LinkedHashSet<Movie> result = trm.getMovieRecommendations(m1, 4);
		Movie[] array=  result.toArray(new Movie[result.size()]);
		assertEquals("id not equals "+5,5,array[0].getId());
		assertEquals("id not equals "+4,4,array[1].getId());
		assertEquals("id not equals "+5,5,array[2].getId());
		assertEquals("id not equals "+2,2,array[3].getId());
		assertEquals("rating not equals "+10+".0",10+".0",array[0].getRating()+"");
		assertEquals("rating not equals "+8+".0",8+".0",array[1].getRating()+"");
		assertEquals("rating not equals "+8+".0",8+".0",array[2].getRating()+"");
		assertEquals("rating not equals "+6+".0",6+".0",array[3].getRating()+"");
		
		
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

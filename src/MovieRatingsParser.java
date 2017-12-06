/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, PriorityQueue<Integer>> moveTreeMap = new TreeMap<String, PriorityQueue<Integer>>();
		if(allUsersRatings == null || allUsersRatings.isEmpty()) return moveTreeMap;
        for(int i = 0; i < allUsersRatings.size(); i++) {
        		if(checkMoveRating(allUsersRatings.get(i))) {
        			UserMovieRating movie = allUsersRatings.get(i);
        			try {
	        			String movieName = movie.getMovie().toLowerCase();
	        			if(moveTreeMap.get(movieName) == null) {
	        				// add new movie
	        				PriorityQueue<Integer> newRating = new PriorityQueue<Integer>();
	        				newRating.add(movie.getUserRating());
	        				moveTreeMap.put(movieName, newRating);
	        				
	        			} else {
	        				// add rating to PriorityQueue
	        				PriorityQueue<Integer> movieRatings = moveTreeMap.get(movieName);
	        				movieRatings.add(movie.getUserRating());
	        			}
        			} catch(Exception e) {
        				System.out.println(e);
        			}
        		}
        }
		return moveTreeMap; // this line is here only so this code will compile if you don't modify it
	}
	
	
	private static boolean checkMoveRating(UserMovieRating rating) {
		if(rating == null) return false;
		if(rating.getMovie() == null || rating.getMovie().length() == 0 || 
				rating.getUserRating() < 0) return false;
		return true;
	}

}

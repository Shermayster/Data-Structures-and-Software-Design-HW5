/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movieList = new ArrayList<String>();
		if(movieRatings == null || movieRatings.isEmpty()) return movieList;
		
		movieList = new ArrayList<String>(movieRatings.keySet());
		
		return movieList; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movieList = new ArrayList<String>();
		if(movieRatings == null || movieRatings.isEmpty()) return movieList;
		for(Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
			  String key = entry.getKey();
			  PriorityQueue<Integer> reverseQ = new PriorityQueue<Integer>(Collections.reverseOrder());
			  reverseQ = entry.getValue();
			  Integer value = reverseQ.peek();
			  if(value > rating) {
				  movieList.add(key);
			  }

			  
			}
		
		return movieList; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, Integer> resultMap = new TreeMap<String, Integer>();
		if(movieRatings == null || movieRatings.isEmpty()) return resultMap;
		List<String> movieToDelete = new ArrayList<>();
		for(Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
			  String key = entry.getKey();
			  PriorityQueue<Integer> queue = entry.getValue();
			Integer length = queue.size();
			queue = removeBelowRating(queue, rating);
			if(queue != null && queue.size() != 0) {
				if(length != queue.size()) {
					resultMap.put(key, length - queue.size());
				}
			} else {
				resultMap.put(key, length);
				movieToDelete.add(key);
				}
			}
		
		for(int i = 0; i < movieToDelete.size(); i++) {
			movieRatings.remove(movieToDelete.get(i));
		}
		
		return resultMap; // this line is here only so this code will compile if you don't modify it
	}
	
	private static PriorityQueue<Integer> removeBelowRating (PriorityQueue<Integer> ratings, int rating) {
		if(ratings == null) return ratings;
		int lowerRating = ratings.peek();
		System.out.println(lowerRating + " => " + rating);
		if(lowerRating < rating) {
			System.out.println("delete");
			ratings.poll();
			if(ratings.size() == 0) return ratings;
			removeBelowRating(ratings, rating);
		} else {
			System.out.println("not delete");
			return ratings;
		}
		return ratings;
	}
}

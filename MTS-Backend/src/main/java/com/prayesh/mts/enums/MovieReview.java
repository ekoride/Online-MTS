package com.prayesh.mts.enums;

import java.util.HashMap;
import java.util.Map;

public enum MovieReview {
    EXCELLENT("Excellent",5),
    GOOD("Good",4),
    AVERAGE("Average",3),
    BAD("Bad",2),
    WORST("Worst",1);

    public final String reviewLevel;
    public final int reviewValue;

    MovieReview(String level, int value){
        this.reviewLevel = level;
        this.reviewValue = value;
    }
    private static final Map<String, MovieReview> map = new HashMap<>();
	private static final Map<Integer, MovieReview> intMap = new HashMap<>();
	static {
		for (MovieReview movieRating: MovieReview.values()) {
			map.put(movieRating.reviewLevel, movieRating);
			intMap.put(movieRating.reviewValue, movieRating);
		}
			
	}
	
	public static MovieReview fromString(String level) {
		return map.get(level);
	}
	
	
	public static MovieReview fromInt(int value) {
		return intMap.get(value);
	}
}

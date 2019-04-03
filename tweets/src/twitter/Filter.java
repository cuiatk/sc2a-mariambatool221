/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Filter {

    
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
       
        List<Tweet> tweetsfromusername = new ArrayList<>();
        for (Tweet tweet : tweets) {
            if (tweet.getAuthor().toLowerCase().equals(username.toLowerCase())) {
                tweetsfromusername.add(tweet);
            }

        }
        return tweetsfromusername;
        // throw new RuntimeException("not implemented");
    }

    
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        List<Tweet> tweetsintimeSpan = new ArrayList<>();
        for (Tweet tweet : tweets) {
            
            if (tweet.getTimestamp().isBefore(timespan.getEnd()) && tweet.getTimestamp().isAfter(timespan.getStart())) {
                tweetsintimeSpan.add(tweet);
            }
        }
        return tweetsintimeSpan;

        // throw new RuntimeException("not implemented");
    }

    
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        List<String> loweredList = new ArrayList<>();
        for (String lowered : words) {
            loweredList.add(lowered.toLowerCase());
        }

        List<Tweet> tweetsWithKeyWords = new ArrayList<>();
        for (Tweet tweet : tweets) {
            
            List<String> wordsfromtweet = new ArrayList<String>(Arrays.asList(tweet.getText().split(" ")));
            for (String st : wordsfromtweet) {
                if (loweredList.contains(st.toLowerCase())) {
                    tweetsWithKeyWords.add(tweet);
                    break;
                }

            }
        }
        return tweetsWithKeyWords;
        // throw new RuntimeException("not implemented");
    }

}

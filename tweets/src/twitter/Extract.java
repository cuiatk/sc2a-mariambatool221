
package twitter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {

	 public static Instant getStart(List<Tweet> tweets) {
	        
	        if(tweets.isEmpty()){
	            return Instant.now();
	        }
	        Instant starttime = Instant.MAX;
	        for (Tweet tweet : tweets) {
	            if (tweet.getTimestamp().isBefore(starttime)) {
	                starttime = tweet.getTimestamp();
	            }
	        }
	        return starttime;
	    }

	    public static Instant getEnd(List<Tweet> tweets) {
	        if (tweets.isEmpty()){
	            return Instant.now();
	        }
	        Instant endtime = Instant.MIN;
	        for (Tweet tweet : tweets) {
	            if (tweet.getTimestamp().isAfter(endtime)) {
	                endtime = tweet.getTimestamp();
	            }
	        }
	        return endtime;
	    }

	    public static Timespan getTimespan(List<Tweet> tweets) {
	        if (tweets.isEmpty()) {
	            return new Timespan(Instant.now(), Instant.now());
	        } else {
	            Instant start = getStart(tweets);
	            Instant end = getEnd(tweets);
	            return new Timespan(start, end);

	        }

	    }
	

     static Set<String> getMentionedUsers(List<Tweet> tweets) {
            Pattern pattern = Pattern.compile("@(\\w+|\\W+)");
            Set<String>MentionedUsers = new HashSet<String>();
            for (Tweet tweet : tweets) {
                String substring = tweet.getText();
                Matcher matcher = pattern.matcher(substring.toLowerCase());
                List<String> MentionedUsersLowerCase = new ArrayList<String>();
                while(matcher.find()){
                    System.out.println(matcher.group(1));
                    MentionedUsersLowerCase.add(matcher.group(1)); 
                    }
                      MentionedUsers.addAll( MentionedUsersLowerCase);
                }
                   return MentionedUsers;
            
               
        }
    
}

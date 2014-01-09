package jongo;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Einfaches Beispiel für die Verwendung des Jongo O/D-Mappers.
 * 
 * @author Tobias Trelle
 *
 */
public class JongoBeispiel {

	public static void main(String argv[]) throws UnknownHostException {
		
		// Mongo Java Treiber
		DB twitterDB = new MongoClient().getDB("twitter");
		
		// Jongo API
		Jongo jongo = new Jongo(twitterDB);
		MongoCollection tweetCollection = jongo.getCollection("tweets");
		
		// alle zählen
		System.out.println( tweetCollection.count() );
		
		Iterable<Tweet> tweets;
		
		// Tweets von Usern mit deutscher Sprache
		tweets = tweetCollection.find("{\"user.lang\": \"de\"}").as(Tweet.class);
		for (Tweet t: tweets) {
			System.out.println(t);
		}

		// Tweets von Usern mit vielen Followern
		tweets = tweetCollection.find("{\"user.followers_count\": {$gt: 50000} }").as(Tweet.class);
		for (Tweet t: tweets) {
			System.out.println(t);
		}
	
	}
}

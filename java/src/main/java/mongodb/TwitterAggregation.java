package mongodb;

import java.net.UnknownHostException;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/** 
 * Verwendung des Aggregation-Frameworks auf der Twitter-Datenbank. 
 *  
 * @author Tobias Trelle
 */
public class TwitterAggregation {
	
	public static void main(String argv[]) throws UnknownHostException {
		DBCollection collection =  new MongoClient().getDB("twitter").getCollection("tweets");

		// Pipeline zusammenstellen
		DBObject match = new BasicDBObject("user.lang", "de");
		DBObject group = new BasicDBObject("_id", new BasicDBObject("name", "$user.name"));
		group.put("follower_count", new BasicDBObject("$max", "$user.followers_count"));
		DBObject sort = new BasicDBObject("follower_count", -1);
		
		// Aggregation
		AggregationOutput ao = collection.aggregate(
				new BasicDBObject("$match", match),
				new BasicDBObject("$group", group),
				new BasicDBObject("$sort",  sort),
				new BasicDBObject("$limit", 3)
		);
		for (DBObject doc: ao.results()) { 
			System.out.println(doc); 
		}
		
	}
	
}
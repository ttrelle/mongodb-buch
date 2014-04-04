package mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
		
		List<DBObject> pipeline = new ArrayList<DBObject>();
		pipeline.add(new BasicDBObject("$match", match));
		pipeline.add(new BasicDBObject("$group", group));
		pipeline.add(new BasicDBObject("$sort",  sort));
		pipeline.add(new BasicDBObject("$limit", 3));
		
		// Aggregation
		AggregationOutput ao = collection.aggregate( pipeline );
		for (DBObject doc: ao.results()) { 
			System.out.println(doc); 
		}
		
	}
	
}
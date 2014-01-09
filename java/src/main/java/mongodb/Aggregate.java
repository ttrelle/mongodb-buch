package mongodb;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/** 
 * Verwendung des Aggregation-Frameworks. 
 *  
 * @author Tobias Trelle
 */
public class Aggregate {
	
	public static void main(String argv[]) throws UnknownHostException {
		DBCollection collection =  new MongoClient().getDB("test").getCollection("foo");

		// Testdaten vorbereiten
		collection.remove( new BasicDBObject() );
		collection.insert(create("Doc 1", "cc", "mongodb", "nosql"));
		collection.insert(create("Doc 2", "cc", "nosql"));
		collection.insert(create("Doc 3", "cc", "agile"));
		
		// Aggregation Framework
		DBObject projection = new BasicDBObject("_id", 0);
		projection.put("tags", 1);
		DBObject group = new BasicDBObject("_id", "$tags");
		group.put("n", new BasicDBObject("$sum", 1));
		
		AggregationOutput ao = collection.aggregate(
				new BasicDBObject("$project", projection),
				new BasicDBObject("$unwind", "$tags"),
				new BasicDBObject("$group", group),
				new BasicDBObject("$sort", new BasicDBObject("n", -1) )
		);
		for (DBObject doc: ao.results()) { 
			System.out.println(doc); 
		}
		
	}
	
	private static DBObject create(String title, String... tags) {
		DBObject doc = new BasicDBObject("t", title);
		doc.put("tags", Arrays.asList(tags));
		
		return doc;
	}
	
}
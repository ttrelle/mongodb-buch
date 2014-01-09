package mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/** 
 * Demonstriert die Verwendung der verschiedenen Datentypen. 
 *  
 * @author Tobias Trelle
 */
public class Datentypen {
	
	public static void main(String argv[]) throws UnknownHostException {
		MongoClient mongo = new MongoClient();
		DBCollection collection = mongo.getDB("test").getCollection("typen");
		
		collection.drop();
		DBObject doc = new BasicDBObject();

		doc.put( "string", "Hallo MongoDB" );
		doc.put( "grüße", "Hallo MongoDB" );
		doc.put( "int32", (int) Math.pow(2, 30) );
		doc.put( "int64", (long) - Math.pow(2, 60) );
		doc.put( "double", Math.PI / 2 );
		doc.put( "binary", "Hallo MongoDB".getBytes() );
		
		collection.insert(doc);
		System.out.println( collection.findOne() );
	}
	
}
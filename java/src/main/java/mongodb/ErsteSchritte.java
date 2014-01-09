package mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/** 
 * Erste Schritte: Dokument anlegen und Suchen. 
 *  
 * @author Tobias Trelle
 */
public class ErsteSchritte {
	
	public static void main(String argv[]) throws UnknownHostException {
		MongoClient mongo = new MongoClient();
		DBCollection collection = mongo.getDB("test").getCollection("foo");
		
		collection.insert( new BasicDBObject("hello", "MongoDB") );
		System.out.println( collection.findOne() );
	}
	
}
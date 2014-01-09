package mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/** 
 * Anzeige aller Datenbanken und Collections samt Dokumentenanzahl. 
 *  
 * @author Tobias Trelle
 */
public class Browser {
	
	public static void main(String argv[]) throws UnknownHostException {
		MongoClient mongo = new MongoClient();
		
		for ( String dbName: mongo.getDatabaseNames() ) {
			System.out.println(dbName + ":");
			
			DB db = mongo.getDB(dbName);
			for ( String collName: db.getCollectionNames()) {
				DBCollection coll = db.getCollection(collName);
				
				System.out.println("   - " + coll.getName() + " (" + coll.count() + ")");
			}
			
		}
		
	}
	
}
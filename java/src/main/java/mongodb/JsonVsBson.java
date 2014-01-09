package mongodb;

import java.net.UnknownHostException;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Demonstriert den Unterschied zw. JSON und BSON. Dies setzt voraus,
 * dass per Mongo-Shell ein entsprechendes Dokument im JSON-Format 
 * eingefügt wurde.
 * 
 * @author tobias.trelle
 */
public class JsonVsBson {
	
	public static void main(String argv[]) throws UnknownHostException {

		DBObject doc = new MongoClient().getDB("test").getCollection("foo").findOne();
		System.out.println( doc.get("a") );
		System.out.println( doc.get("a") instanceof Double);
		
		System.out.println( doc.get("i") );
		System.out.println( doc.get("i") instanceof Integer);

		System.out.println( doc.get("l") );
		System.out.println( doc.get("l") instanceof Long);
	}
	
}
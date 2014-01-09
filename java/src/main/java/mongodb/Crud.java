package mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/** 
 * Crud-Operationen. 
 *  
 * @author Tobias Trelle
 */
public class Crud {
	
	public static void main(String argv[]) throws UnknownHostException {

		// einfuegen
		DBCollection foo = new MongoClient().getDB("test").getCollection("foo");
		foo.remove( new BasicDBObject() );
		DBObject doc;
		
		doc = new BasicDBObject("a", 1);
		doc.put("b", "zwei");
		foo.insert( doc );
		
		doc =  new BasicDBObject("a", 2);
		doc.put("b", "drei");
		foo.insert( doc );
		
		/*
		DBObject doc = new BasicDBObject();
		doc.put("hello", "MongoDB");
		doc.put("hello", "Java");
		*/
		
		// suchen
		DBCursor crsr;
		crsr = foo.find();
		while ( crsr.hasNext() ) {
			System.out.println( crsr.next() );
		}
		crsr.close();

		// suchen mit Kriterien
		// Query = {a: {$gt: 1}}
		crsr = foo.find( new BasicDBObject("a", new BasicDBObject("$gt",1)) );
		while ( crsr.hasNext() ) {
			System.out.println( crsr.next() );
		}
		crsr.close();
		
		// Update
		foo.update( 
			new BasicDBObject("a",1), 
			new BasicDBObject("$set", new BasicDBObject("b", "vier"))
		);
		
		// Remove
		foo.remove( new BasicDBObject("a",2) );
		
		// Sichtkontrolle
		crsr = foo.find();
		while ( crsr.hasNext() ) {
			System.out.println( crsr.next() );
		}
		crsr.close();	
		
		
	}
	
	
}
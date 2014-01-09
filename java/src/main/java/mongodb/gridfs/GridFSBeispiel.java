package mongodb.gridfs;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

/**
 * Einfaches Beispiel für GridFS-Zugriff.
 *  
 * @author Tobias Trelle
 */
public class GridFSBeispiel {

	public static void main(String[] argv) throws UnknownHostException {
		// localhost:27017
		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("grid");
		db.dropDatabase();
		
		// GridFS
		GridFS grid = new GridFS( db, "data" );
		
		// Einfügen
		GridFSInputFile gridFile = grid.createFile( new byte[1000] );
		gridFile.setFilename( "data.bin" );
		gridFile.setContentType( "application/binary" );
		gridFile.setChunkSize( 250 );
		gridFile.setMetaData( new BasicDBObject("key", "value") );
		gridFile.save();
		
		// Auflisten
		DBCursor crsr = grid.getFileList();
		while ( crsr.hasNext() ) {
			System.out.println( crsr.next() );
		}
		
		// Suchen
		System.out.println(
			grid.findOne( new BasicDBObject("metadata.key", "value") )
		);
		
	}
	
}

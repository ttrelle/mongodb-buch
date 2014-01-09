require 'mongo'

connection = Mongo::Connection.new
connection.database_names.each { |db_name| 
	print db_name, ":\n"
	
	db 	= connection.db(db_name)
	db.collection_names.each { |cn| 
		collection = db.collection(cn)
		print " - " +  cn + " (", collection.count, ")\n"
	}
	
}

require 'mongo'

collection = Mongo::Connection.new["test"]["foo"]
collection.remove

collection.insert "t" => "Doc 1", "tags" => ["cc", "mongodb", "nosql"]
collection.insert "t" => "Doc 2", "tags" => ["cc", "nosql"]
collection.insert "t" => "Doc 3", "tags" => ["cc", "agile"]
collection.find.each { |doc| puts doc }

puts "Aggregate:"
collection.aggregate( [
	{"$project" => {"_id" => 0, "tags" => 1}},
	{"$unwind" => "$tags"},
	{"$group" => {"_id" => "$tags", "n" => {"$sum" => 1} } },
	{"$sort" => {"n" => -1} }
]).each { |doc| puts doc }
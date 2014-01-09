require 'mongo'

tweets = Mongo::MongoClient.new["twitter"]["tweets"]

tweets.aggregate( [
	{"$match" => {"user.lang" => "de"}},
	{"$group" => {
		"_id" => {"name" => "$user.name"}, 
		"follower_count" => {"$max" => "$user.followers_count"} } },
	{"$sort" => {"follower_count" => -1} },
	{"$limit" => 3}
]).each { |doc| puts doc }
require 'mongoid'

class Tweet 
	include Mongoid::Document
	field :text, type: String
	embeds_one :user
	
	def to_s
		"Tweet [text: " + text + ", " + user.to_s + "]"
	end
end

class User
	include Mongoid::Document
	field :name, type: String
	field :lang, type: String
	field :retweet_count, type: Integer
	embedded_in :tweet
	
	def to_s
		"User = [name: " + name + ", lang: " + lang + 
		", followers_count: " +  followers_count.to_s + "]"
	end
	
end	

# Verbindung zur lokalen MongoDB
Mongoid.load!("mongoid.yml", :development)

# Tweets zählen
n = Tweet.count
puts n

# Tweets in deutscher Sprache finden
Tweet.where( "user.lang" => "de" ).each {
	|tweet| puts tweet
}

# Tweets mit vielen Followern finden
Tweet.where( "user.followers_count" => {"$gt" => 50000} ).each {
	|tweet| puts tweet
}


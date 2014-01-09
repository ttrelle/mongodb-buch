require 'mongo'

collection = Mongo::Connection.new["test"]["foo"]
collection.remove

puts "Einfuegen:"
collection.insert "a" => 1, "b" => "zwei"
collection.insert "a" => 2, "b" => "drei"

puts "Suchen: alle"
crsr = collection.find # alle Dokumente
puts crsr.inspect
crsr.each { |doc| puts doc }

puts "Suchen: a > 1"
crsr = collection.find "a" => {"$gt" => 1}
crsr.each { |doc| puts doc }

puts "Update:"
collection.update( {"a" => 1}, {"$set" => {"b" => "vier"} } )
collection.find.each { |doc| puts doc }

puts "Loeschen:"
collection.remove "a" => 2
collection.find.each { |doc| puts doc }
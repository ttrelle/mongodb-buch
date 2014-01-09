#
# Einfacher REST-Client
#
require 'rest_client'

response = RestClient.get("http://localhost:28017/twitter/tweets/?limit=5")

puts response.body
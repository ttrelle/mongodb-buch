db.pois.drop();
db.pois.ensureIndex({name: "text", desc: "text", "tags": "text"}, {name:"TextIndex", weights: {name:10, tags: 5, desc:1}, default_language: "german"});
db.pois.ensureIndex({ location: "2dsphere" }, {name: "GeoIndex"});


db = db.getSiblingDB('admin');

var user =  "disco_owner";
var pwd = "disco_password";

db.createUser({
    user: user,
    pwd: pwd,
    roles: [{ role: "userAdmin", db: "discodb" }]
});

db = db.getSiblingDB('discodb');

db.createCollection("disquera");
db.disquera.insert([
    {
        "nombre": "+MasLabel"
    }
]);

db.createCollection("artistas");
db.artistas.insert([
    {
        "nombre": "Armin Van Buuren"
    }
]);
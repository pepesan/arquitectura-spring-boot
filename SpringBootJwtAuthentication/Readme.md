# API REST de LOGIN; REGISTRO Y API TOKEN

Aplicación de ejemplo hecho con Spring Boot que sirve un API REST con los datos de la pokedex

# Ejecución
mvn spring-boot:run

# URL principal
[http://localhost:8080](http://localhost:8080)

# ENDPoint Signup
POST [http://localhost:8080/api/auth/signup](http://localhost:8080/api/auth/signup)
Content-Type: application/json
{
  "name": "admin",
  "username": "admin",
  "email": "admin@local",
  "password": "admin1234",
  "role": ["user","admin"]
}

# ENDPoint Signin
POST [http://localhost:8080/api/auth/signin](http://localhost:8080/api/auth/signin)
Content-Type: application/json
{
	"username":"admin",
	"password":"admin1234"
}

# ENDPoint
Authorization: Beared APIKEY_DEVUELTO
[http://localhost:8080/api/test/user](http://localhost:8080/api/test/user)
#Documentación del Servicio Rest
[http://localhost:8080/swagger-ui.html]
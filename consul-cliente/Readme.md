# Cliente de Consul y servicio Rest 

Para que funcione todo es necesario lanzar el servidor de consul

$ consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1
### Descarga
(https://www.consul.io/downloads.html)

# Acceso al servidor de consul
(http//127.0.0.1:8500/)

# Arranque del servicio 
mvn spring-boot:run

# Acceso al microservicio
(http//127.0.0.1:9098/)

# Comprobaciones
* Desde la consola de Consul se ve el servicio

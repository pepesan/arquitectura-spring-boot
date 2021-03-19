# Cliente de Consul y servicio Rest 

Para que funcione todo es necesario lanzar el servidor de consul
### Descarga
(https://www.consul.io/downloads.html)
# Instalación
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install consul
# Arranque del agente del consul
$consul agent -dev
####otra manera de arranque
$ consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1

# Acceso al servidor de consul
(http//127.0.0.1:8500/)

# Arranque del servicio 
mvn spring-boot:run

# Acceso al microservicio
(http//127.0.0.1:9098/)

# Comprobaciones
* Desde la consola de Consul se ve el servicio


# Referencias
* [guia de consul de baeldung](https://www.baeldung.com/spring-cloud-consul)
* [Tutorial de instalación de consul](https://learn.hashicorp.com/tutorials/consul/get-started-agent?in=consul/getting-started)
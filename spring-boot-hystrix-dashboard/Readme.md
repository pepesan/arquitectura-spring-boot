# Ejemplo de Hyxtrix Dashboard

mvn spring-boot:run

# Habilitado el stream
management:
  endpoints:
    web:
      exposure:
        include: hystrix.stream

#URL Servicio Cliente
[http://localhost:8010/employeeDetails/111]

# Hystrix Dashboard
[http://localhost:8010/hystrix]
# Hystrix Stream
[http://localhost:8010/actuator/hystrix.stream]
# Comprobar el Hystrix Dashboard
http://localhost:9295/hystrix
y metiendo la URL
http://localhost:9191/actuator/hystrix.stream
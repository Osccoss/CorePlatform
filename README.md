PRUEBA INDITEX 

Requisitos 
- REST
- Microservicios
- H2

Añadidos
- Arquitectura Hexagonal
- JPA

URL para la base de datos H2 

    - http://localhost:8080/h2-console
    - cambiar configuracion url=jdbc:h2:mem:testinditexdb el resto es extandar
    
Mejoras a Futuro 

- Realizar un checkstyle más exaustivo y completo. Ignorando en la cobertura entidades y mappers.

Curls para las pruebas:

curl --location --request GET 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
"brandId": "1",
"productId": "35455",
"searchDate": "2020-06-14T10:00:00"
}'

curl --location --request GET 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
"brandId": "1",
"productId": "35455",
"searchDate": "2020-06-14T16:00:00"
}'

curl --location --request GET 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
"brandId": "1",
"productId": "35455",
"searchDate": "2020-06-14T21:00:00"
}'

curl --location --request GET 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
"brandId": "1",
"productId": "35455",
"searchDate": "2020-06-15T10:00:00"
}'

curl --location --request GET 'http://localhost:8080/api/v1/product' \
--header 'Content-Type: application/json' \
--data '{
"brandId": "1",
"productId": "35455",
"searchDate": "2020-06-16T21:00:00"
}'
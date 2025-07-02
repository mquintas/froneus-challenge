#Froneus Challenge

#Requisitos

- POST /dinosaur
- GET /dinosaur
- GET /dinosaur/{id}
- PUT /dinosaur/{id}
- DELETE /dinosaur/{id}

#reglas:
- El nombre del dinosaurio debe ser único.
- El valor de discoveryDate no puede ser mayor o igual al valor de extinctionDate.
- Los valores posibles para status son ALIVE, ENDANGERED y EXTINCT.
- El status inicial debe ser ALIVE.
- No se puede modificar un dinosaurio EXTINCT.

#Swagger UI
[http://localhost:8080/swagger-ui/index.html
]()

#Para Ejecutar el proyecto:

Con docker desktop levantado, ejecutar el siguiente comando en la terminal:

```bash
`./gradlew build bootRun
`
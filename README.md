# Pixup DISCO Microservice Endpoints

Este repositorio contiene la definición de los Endpoints de "Disco Service" para los siguientes dominios del sistema Pixup:
- Disquera (Nuevo)
- Artista

### Version

- Versión actual: v2

# Recursos Docker 🐳

La aplicación PIXUP hace uso de las siguientes imágenes.

### MongoDB

- [Mongodb 4.2.24](https://hub.docker.com/layers/library/mongo/4.2.24/images/sha256-e43605102083aca04677b02446d9289ef495b0e97251d298c9840abe1f0256a1?context=explore)
- [Dockerfile](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/mongo.Dockerfile)
- [init-mongo.js](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/db/mongo/init-mongo.js)
- Ver imagen personalizada en [Dockerhub](https://hub.docker.com/r/pxrsival/mongo-disco-img)
- Si se desea utilizar una BD sin inicializar, ELIMINAR la siguiente línea del Dockerfile (o modifica el init-mongo.js con la información deseada).

```Dockerfile
COPY init-mongo.js /docker-entrypoint-initdb.d/
```

### Maven

- [maven:3.8.4-openjdk-17](https://hub.docker.com/layers/library/maven/3.8.4-openjdk-17/images/sha256-d07c45c45755f0f90b779bad869467e602f1bfff4d0b5eb1ff73f2882bc38187?context=explore)
- [Dockerfile](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/maven.Dockerfile)
- No olvides modificar las ```ENVIRONMENT_VARIABLES``` de acuerdo a tus configuraciones.

# Recursos Kubernetes ☸️

### Mongodb

- [deployment.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/mongo-deployment.yaml)
- [service.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/mongo-service.yaml)
  
### PIXUP (Java App)

- [deployment.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-deployment.yaml)
- [service.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-service.yaml)
- [ingress.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-ingress.yaml)


# Recursos API para DISQUERA 💽

**DISQUERA** tiene la siguiente estructura:

```json
[
    {
        "id": "00000000000000000000000000",
        "nombre": "VALOR"
    }
]
```

La estructura del `JSON` para los métodos HTTP que lo requieran se ve algo así.

```json
{
   "nombre": "VALOR"
}
```

| Método | Acción      | Ruta | Parámetros vía JSON | Respuestas |
| :----- | :---------- | :--- | :--------- | :--------- |
| `POST` | Crea una Disquera | `/disqueras` | `nombre` | `201 [CREATED]` - Se agregó correctamente. |
| `GET` | Obtiene el listado completo de Disqueras | `/disqueras` | N/A | `200 [OK]` - Se ha completado la acción correctamente. |
| `GET` | Obtiene la disquera con el `id` especificado | `/disqueras/{id}` | N/A | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe una Disquera con el ID proporcionado. |
| `PUT` | Actualiza el `nombre` de la Disquera con el `id` especificado en el Path | `/disqueras/{id}` | `nombre` | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe una Disquera con el ID proporcionado. |
| `DELETE` | Elimina la disquera con el `id` especificado | `/disqueras/{id}` | N/A | `204 [NO CONTENT]` - Se ha completado la acción correctamente (No valida la existencia). |

### TEST

Los microservicios se encuentran expuestos a través de un puerto. Para esta demostración se utilizó `localhost` y el puerto `:8083`.
Utiliza Postman o ejecuta un comando `curl` para validar el despliegue del servicio utilizado cualquiera de los métoddos HTTP descritos en la tabla:

```bash
curl -X 'MÉTODO_HTTP' \
  'http://localhost:8083/api/disqueras' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
       "nombre": "VALOR"
      }' 
```

# Recursos API para ARTISTA 🎤

**ARTISTA** tiene la siguiente estructura:

```json
[
    {
        "id": "00000000000000000000000000",
        "nombre": "VALOR"
    }
]
```

La estructura del `JSON` para los métodos HTTP que lo requieran se ve algo así.

```json
{
   "nombre": "VALOR"
}
```

> Lista de métodos implementados.

| Método | Acción      | Ruta | Parámetros vía JSON | Respuestas |
| :----- | :---------- | :--- | :--------- | :--------- |
| `POST` | Crea un Artista | `/artistas` | `nombre` | `201 [CREATED]` - Se agregó correctamente. |
| `GET` | Obtiene el listado completo de Artistas | `/artistas` | N/A | `200 [OK]` - Se ha completado la acción correctamente. |
| `GET` | Obtiene al Artista con el `id` especificado | `/artistas/{id}` | N/A | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe un Artista con el ID proporcionado. |
| `PUT` | Actualiza el `nombre` del Artista con el `id` especificado en el Path | `/artistas/{id}` | `nombre` | `200 [OK]` - Se ha completado la acción correctamente .<br><br>`404 [NOT FOUND]` - No existe un Artista con el ID proporcionado. |
| `DELETE` | Elimina al Artista con el `id` especificado | `/artistas/{id}` | N/A | `204 [NO CONTENT]` - Se ha completado la acción correctamente (No valida la existencia). |

### TEST

Los microservicios se encuentran expuestos a través de un puerto. Para esta demostración se utilizó `localhost` y el puerto `:8083`.
Utiliza Postman o ejecuta un comando `curl` para validar el despliegue del servicio utilizado cualquiera de los métoddos HTTP descritos en la tabla:

```bash
curl -X 'MÉTODO_HTTP' \
  'http://localhost:8083/api/artistas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
       "nombre": "VALOR"
      }' 
```

### Artista

```json
{
    "id": "",
    "nombre": ""
}
```

### POST
- **Descripción:** Agrega un Artista.
- **Método HTTP:**
  - `POST`
- **Ruta:**
  - `/artistas`
- **Parámetros:**
  - `nombre` (json, string, requerido)
- **Cuerpo de la solicitud:**
  - `application/json`
- **Respuestas:**
  - `Código 200`: Se ha actualizado la información correctamente.
  - `Código 404`: No se encontró registro con el ID especificado.

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'POST' \
  'http://localhost:8083/api/artistas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
        "nombre": "ACDS"
      }' 
```

La respuesta será algo como:

```json
{
    "id": "651f6e2aa379fd208eb858c4",
    "nombre": "ACDS"
}
```

### GET


- **Descripción:** Obtiene el listado completo de Artistas.
- **Método HTTP:**
  - `GET`
- **Ruta:**
  - `/artistas`
- **Respuestas:**
  - `Código 200`: Se ha completado la operación con éxito.

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'GET' \
  'http://localhost:8083/api/artistas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```json
[
    {
        "id": "65078323cbd92b0e0b83c5ad",
        "nombre": "Armin Van Buuren"
    },
    {
        "id": "650792cdbf3d122a825c88eb",
        "nombre": "Sor Chescuina"
    },
    {
        "id": "65079331bf3d122a825c88ed",
        "nombre": "Sor Chummarra"
    },
    {
        "id": "65088196ec2dc56376b9110d",
        "nombre": "Linkin Park"
    },
    {
        "id": "6508828cef49d7612c93ec6b",
        "nombre": "Green Day"
    },
    {
        "id": "6508b7d1bd313f68736fdeb0",
        "nombre": "Belanova"
    },
    {
        "id": "6508b861bd033d5308d9fa15",
        "nombre": "+Label"
    },
    {
        "id": "651f6e2aa379fd208eb858c4",
        "nombre": "ACDS"
    }
]
```

### GET {id}

- **Descripción:** Obtiene un Artista a través de un ID.
- **Método HTTP:**
  - `GET`
- **Ruta:**
  - `/artistas/{id}`
- **Parámetros:**
  - `id` (en la ruta, requerido)
- **Respuestas:**
  - `Código 200`: Se ha actualizado la información correctamente.
  - `Código 404`: No se encontró registro con el ID especificado.

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'GET' \
  'http://localhost:8083/api/artistas/651f6e2aa379fd208eb858c4' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```json
{
    "id": "651f6e2aa379fd208eb858c4",
    "nombre": "ACDS"
}
```

### PUT {id}

- **Descripción:** Actualiza el nombre de la Artista con el ID especificado en el PATH.
- **Método HTTP:**
  - `PUT`
- **Ruta:**
  - `/artistas/{id}`
- **Parámetros:**
  - `id` (en la ruta, `string`, requerido)
  - `nombre` (json, `string` requerido)
- **Cuerpo de la solicitud:**
  - `application/json`
- **Respuestas:**
  - `Código 200`: Se ha actualizado la información correctamente.
  - `Código 404`: No se encontró registro con el ID especificado.
 
Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'PUT' \
  'http://localhost:8083/api/artistas/651f6e2aa379fd208eb858c4' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
        "nombre": "ACDC"
      }' 
```

La respuesta será algo como:

```json
{
    "id": "651f6e2aa379fd208eb858c4",
    "nombre": "ACDC"
}
```

### DELETE {id}
- **Descripción:** Eliminar un Artista por ID
- **Método HTTP:**
  - `DELETE`
- **Ruta:**
  - `/artistas/{id}`
- **Parámetros:**
  - `id` (en la ruta, requerido)
- **Respuestas:**
  - `Código 204`: Operación de borrado completada (No valida la existencia).

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'DELETE' \
  'http://localhost:8083/api/artistas/651f6e2aa379fd208eb858c4' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```php
HttpStatus: 204 - No Content
```


## Información de Contacto
- **Autor:** UNAM - Josué Israel Hernández Balcón
- **Sitio web:** [UNAM](https://www.unam.mx/)
- **Correo electrónico:** [israel.hernandez@unam.mx](mailto:israel.hernandez@unam.mx)


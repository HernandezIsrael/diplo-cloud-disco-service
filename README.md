# Pixup DISCO Microservice Endpoints

## Contenido

1. Introducción
2. Version
3. Recursos API
   - Disquera (Nuevo)
   - Artista
4. Ejecutar Localmente
5. Información de Contacto

## Introducción

Este repositorio contiene la definición de los Endpoints de "Disco Service" para los siguientes dominios del sistema Pixup:
- Disquera (Nuevo)
- Artista

## Version

- Versión actual: v2

## Recursos API

Estos microservicios se encontrarán expuestos a través del puerto `:8083`.

### Disquera

```json
{
    "id": "",
    "nombre": ""
}
```

### POST
- **Descripción:** Agrega una Disquera.
- **Método HTTP:**
  - `POST`
- **Ruta:**
  - `/disqueras`
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
  'http://localhost:8083/api/disqueras' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
       "nombre": "+MasNescafe"
      }' 
```

La respuesta será algo como:

```json
{
    "id": "651f5b18a379fd208eb858c3",
    "nombre": "+MasNescafe"
}
```

### GET


- **Descripción:** Obtiene el listado completo de Disqueras.
- **Método HTTP:**
  - `GET`
- **Ruta:**
  - `/disqueras`
- **Respuestas:**
  - `Código 200`: Se ha completado la operación con éxito.

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'GET' \
  'http://localhost:8083/api/disqueras' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```json
[
    {
        "id": "651f1280706d262e1c58668a",
        "nombre": "+MasLabel"
    },
    {
        "id": "651f13c8706d262e1c58668b",
        "nombre": "Sector"
    },
    {
        "id": "651f13d7706d262e1c58668c",
        "nombre": "Sony Music"
    },
    {
        "id": "651f1409706d262e1c58668d",
        "nombre": "Spinnin' Records"
    },
    {
        "id": "651f143a706d262e1c58668e",
        "nombre": "+Nescafe"
    },
    {
        "id": "651f145d706d262e1c586690",
        "nombre": "Epic Records"
    },
    {
        "id": "651f1470706d262e1c586691",
        "nombre": "+Mas"
    }
]
```

### GET {id}

- **Descripción:** Obtiene una Disquera a través de un ID.
- **Método HTTP:**
  - `GET`
- **Ruta:**
  - `/disqueras/{id}`
- **Parámetros:**
  - `id` (en la ruta, requerido)
- **Respuestas:**
  - `Código 200`: Se ha actualizado la información correctamente.
  - `Código 404`: No se encontró registro con el ID especificado.

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'GET' \
  'http://localhost:8083/api/disqueras/651f1280706d262e1c58668a' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```json
{
    "id": "651f1280706d262e1c58668a",
    "nombre": "+MasLabel"
}
```

### PUT {id}

- **Descripción:** Actualiza el nombre de la Disquera con el ID especificado en el PATH.
- **Método HTTP:**
  - `PUT`
- **Ruta:**
  - `/disqueras/{id}`
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
  'http://localhost:8083/api/disqueras/651f13c8706d262e1c58668b' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Sector"
  }' 
```

La respuesta será algo como:

```json
{
    "id": "651f13c8706d262e1c58668b",
    "nombre": "Sector"
}
```

### DELETE {id}
- **Descripción:** Eliminar una Disquera por ID
- **Método HTTP:**
  - `DELETE`
- **Ruta:**
  - `/disqueras/{id}`
- **Parámetros:**
  - `id` (en la ruta, requerido)
- **Respuestas:**
  - `Código 204`: Operación de borrado completada (No valida la existencia).

Ejecuta el siguiente comando `curl` para validar el despliegue del servicio:

```bash
curl -X 'DELETE' \
  'http://localhost:8083/api/disqueras/651f1454706d262e1c58668f' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
```

La respuesta será algo como:

```php
HttpStatus: 204 - No Content
```

## Artista

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


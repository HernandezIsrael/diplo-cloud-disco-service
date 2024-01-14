# 🚨 Aviso de cambio de repositorio

```diff
- Tal y se mencionó en el Foro destinado a epecificar la URL de nuestro proyecto, hago la aclaración aquí también de que se ha actualizado el repositorio y con ello el enlace al mismo.
- El nuevo repositorio puede encontrarse en el siguiente enlace:

- https://github.com/HernandezIsrael/tacos-feos

```



## Pixup - Recurso DISCO Endpoints

### Getting Started

Este repositorio contiene la definición de los Endpoints de "Disco Service". Con estos microservicios vas a poder consultar, insertar, editar y eliminar información de los siguientes dominios:
- Disquera
- Artista

### Contenido

- [Happy Path](#happy-path-)
- [Prepara tu área de trabajo](#prepara-tu-área-de-trabajo-️)
- [Recursos Docker](#recursos-docker-)
- [Recursos Kubernetes](#recursos-kubernetes-️)
- [Aplica los recursos de Kubernetes](#aplica-los-recursos-de-kubernetes-️)
- [It Works!](#it-works-)
- [Recursos API para DISQUERA](#recursos-api-para-disquera-)
- [Recursos API para ARTISTA](#recursos-api-para-artista-)
- [Información de Contacto](#información-de-contacto)

### Version

- Versión: v2
- Descripción: Implementación del dominio DISQUERA

# Happy Path 🥳

1. Utiliza los recursos de Docker y Kubernetes que se proporcionan en este documento o modificalos según tus necesidades.
2. Crea los recursos de Kubernetes.
3. Despliega la aplicación.
4. Verifica que está funcionando desde tu navegador.
5. Consume los microservicios.

# Prepara tu área de trabajo 🗂️

Utiliza un área de trabajo que te facilite ubicar y entender mejor tus archivos y estructura.

```bash
├── Pixup
│   ├── MongoDB
│   │   ├── Dockerfile
│   │   ├── mongo-init.js
│   │   ├── mongo-deployment.yaml
│   │   ├── mongo-service.yaml
│   ├── App
│   │   ├── diplo-cloud-disco-service
│   │   ├── Dockerfile
│   │   ├── app-deployment.yaml
│   │   ├── app-service.yaml
│   │   ├── app-ingress.yaml
```

# Recursos Docker 🐳

### MongoDB

Puedes utilizar la imagen personalizada disponible en [Dockerhub](https://hub.docker.com/r/pxrsival/mongo-disco-img) que ya cuenta con el `USER`, `PASSOWRD`, `DATABASE`, `COLLECTIONS` y algunos datos de prueba para `Artista` y `Disquera`.

<details>
<summary>💡 Si prefieres personalizar la imagen con tus configuraciones o datos, da clic AQUÍ.</summary>

<p></p>

1. Utiliza la imagen oficial de [Mongodb 4.2.24](https://hub.docker.com/layers/library/mongo/4.2.24/images/sha256-e43605102083aca04677b02446d9289ef495b0e97251d298c9840abe1f0256a1?context=explore).
2. Puedes utilizar el archivo [init-mongo.js](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/db/mongo/init-mongo.js) para especificar `USER`, `PASSOWRD`, `DATABASE`, `COLLECTIONS` y contenido según lo requieras.
3. Utiliza el [Dockerfile](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/mongo.Dockerfile) para especificar el archivo de inicialización, exponer puertos y otras configuraciones que requieras.
4. Construye la nueva imagen y publícala en Dockerhub.

```bash

$ docker build -t usuario_docker/nombre_imagen:tag .

$ docker push usuario_docker/nombre_imagen:tag

```

</details>

<hr/>

### Maven

- Imagen oficial de [maven:3.8.4-openjdk-17](https://hub.docker.com/layers/library/maven/3.8.4-openjdk-17/images/sha256-d07c45c45755f0f90b779bad869467e602f1bfff4d0b5eb1ff73f2882bc38187?context=explore)
- Clona este proyecto en tu carpeta de trabajo.
```bash
git clone https://github.com/HernandezIsrael/diplo-cloud-disco-service.git
``` 
- Utiliza el siguiente [Dockerfile](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/maven.Dockerfile).
- No olvides modificar las ```ENVIRONMENT_VARIABLES``` de acuerdo a tus configuraciones.
- Construye la nueva imagen y publícala en Dockerhub.

<details>
<summary>💡 Ver cómo construir la imagen.</summary>

<p></p>

```bash

$ docker build -t usuario_docker/nombre_imagen:tag .

$ docker push usuario_docker/nombre_imagen:tag

```

</details>

# Recursos Kubernetes ☸️

Utiliza los recursos proporcionados o modifícalos según tus nececidades.

### Mongodb

- [deployment.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/mongo-deployment.yaml)
- [service.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/mongo-service.yaml)
  
### PIXUP (Java App)

- [deployment.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-deployment.yaml)
- [service.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-service.yaml)
- [ingress.yaml](https://github.com/HernandezIsrael/diplo-cloud-disco-service/blob/main/resources/manifests/pixup-ingress.yaml)


# Aplica los recursos de Kubernetes ⚙️

Para Mongodb:

```bash

$ kubectl apply -f mongo-deployment.yaml

$ kubectl apply -f mongo-service.yaml

```

Para Pixup:

```bash

$ kubectl apply -f pixup-deployment.yaml

$ kubectl apply -f pixup-service.yaml

$ kubectl apply -f pixup-ingress.yaml

```

# It Works! ✅

Puedes verificar que la aplicación funciona correctamente si intentas acceder a la [documentación de los endpoints](http://k8s.nuup.ninja/api/swagger-ui/index.html). En el archivo `app-ingress.yaml` se especificó el siguiente HOST y PATH (a menos de que se haya modificado):

```bash
http://k8s.nuup.ninja/api
```


# Recursos API para DISQUERA 💽

<details>
<summary>💡 Estructura del dominio DISQUERA.</summary>

<p></p>

| CAMPO | TIPO |
| :---- | :--- |
| id | String |
| nombre | String |

</details>

<details>
<summary>💡 Así se envían los datos en formato JSON (solo si el método HTTP lo requiere).</summary>

<p></p>

Si es un solo dato:

```json
{
  "nombre": "VALOR"
}
```

Si son varios datos:

```json
[
  {
    "nombre": "VALOR_1"
  },
  {
    "nombre": "VALOR_2"
  },
  {
    "nombre": "VALOR_3"
  },
]
```

</details>

<details>
<summary>💡 Así puedes probar la funcionalidad de los endpoints.</summary>

<p></p>
Para este ejemplo se empleará el método POST.

#### Con el comando CURL ⌨️

Ejecuta el siguiente comando `curl`:

```bash
curl -X 'POST' \
  'http://localhost:8083/api/disqueras' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
       "nombre": "+MasLabel"
      }' 
```

#### Utilizando POSTMAN 🚀

Aplica las siguientes configuraciones a POSTMAN:

| Método: | POST |
| :----- | :--- |
| URL: | http://k8s.nuup.ninja/api/disqueras |
| Body: | Raw (JSON) |
| Data: | `{"nombre": "+MasLabel"}` |

#### Resultado

El resultado deberá lucir como el siguiente:

```json
[
    {
        "id": "6549743bb3f7665881ee0d2b",
        "nombre": "+MasLabel"
    }
]
```

</details>

#### Lista de métodos HTTP implementados.

| Método | Acción      | Ruta | Parámetros vía JSON | Respuestas |
| :----- | :---------- | :--- | :--------- | :--------- |
| `POST` | Crea una Disquera | `/disqueras` | `nombre` | `201 [CREATED]` - Se agregó correctamente. |
| `GET` | Obtiene el listado completo de Disqueras | `/disqueras` | N/A | `200 [OK]` - Se ha completado la acción correctamente. |
| `GET` | Obtiene la disquera con el `id` especificado | `/disqueras/{id}` | N/A | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe una Disquera con el ID proporcionado. |
| `PUT` | Actualiza el `nombre` de la Disquera con el `id` especificado en el Path | `/disqueras/{id}` | `nombre` | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe una Disquera con el ID proporcionado. |
| `DELETE` | Elimina la disquera con el `id` especificado | `/disqueras/{id}` | N/A | `204 [NO CONTENT]` - Se ha completado la acción correctamente (No valida la existencia). |

# Recursos API para ARTISTA 🎤

<details>
<summary>💡 Estructura del dominio ARTISTA</summary>

<p></p>

| CAMPO | TIPO |
| :---- | :--- |
| id | String |
| nombre | String |

</details>

<details>
<summary>💡 Así se envían los datos en formato JSON (solo si el método HTTP lo requiere).</summary>

<p></p>

Si es un solo dato:

```json
{
  "nombre": "VALOR"
}
```

Si son varios datos:

```json
[
  {
    "nombre": "VALOR_1"
  },
  {
    "nombre": "VALOR_2"
  },
  {
    "nombre": "VALOR_3"
  },
]
```

</details>

<details>
<summary>💡 Así puedes probar la funcionalidad de los endpoints.</summary>

<p></p>
Para este ejemplo se empleará el método POST.

#### Con el comando CURL ⌨️

```bash
curl -X 'POST' \
  'http://localhost:8083/api/artistas' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
       "nombre": "Green Day"
      }' 
```

#### Utilizando POSTMAN 🚀

| Método: | POST |
| :----- | :--- |
| URL: | http://k8s.nuup.ninja/api/artistas |
| Body: | Raw (JSON) |
| Data: | `{"nombre": "Green Day"}` |

#### Resultado

El resultado deberá lucir como el siguiente:

```json
[
    {
        "id": "6549743bb3f7665881ee0d2b",
        "nombre": "Green Day"
    }
]
```

</details>

#### Lista de métodos HTTP implementados.

| Método | Acción      | Ruta | Parámetros vía JSON | Respuestas |
| :----- | :---------- | :--- | :--------- | :--------- |
| `POST` | Crea un Artista | `/artistas` | `nombre` | `201 [CREATED]` - Se agregó correctamente. |
| `GET` | Obtiene el listado completo de Artistas | `/artistas` | N/A | `200 [OK]` - Se ha completado la acción correctamente. |
| `GET` | Obtiene al Artista con el `id` especificado | `/artistas/{id}` | N/A | `200 [OK]` - Se ha completado la acción correctamente.<br><br>`404 [NOT FOUND]` - No existe un Artista con el ID proporcionado. |
| `PUT` | Actualiza el `nombre` del Artista con el `id` especificado en el Path | `/artistas/{id}` | `nombre` | `200 [OK]` - Se ha completado la acción correctamente .<br><br>`404 [NOT FOUND]` - No existe un Artista con el ID proporcionado. |
| `DELETE` | Elimina al Artista con el `id` especificado | `/artistas/{id}` | N/A | `204 [NO CONTENT]` - Se ha completado la acción correctamente (No valida la existencia). |

<hr/>

## Información de Contacto
- **Autor:** UNAM - Josué Israel Hernández Balcón
- **Sitio web:** [UNAM](https://www.unam.mx/)
- **Correo electrónico:** [israel.hernandez@unam.mx](mailto:israel.hernandez@unam.mx)


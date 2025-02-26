# Proyecto: Pruebas Unitarias con Mocks en Java

## Descripción
Este proyecto implementa un servicio que realiza una solicitud HTTP a una API externa para obtener información de usuarios y utiliza pruebas unitarias con Mockito para simular diferentes respuestas de la API.

## Tecnologías Utilizadas
- Java 17
- Gradle 8.1.1
- Spring Web
- JUnit 5
- Mockito

## Instalación y Ejecución

### 1. Clonar el repositorio
```sh
 git clone https://github.com/ricardoj12-sh/unitTest_mocks_stubs.git
 cd proyecto_5
```

### 2. Construir el proyecto
```sh
gradle clean build
```

### 3. Ejecutar el servicio
```sh
java -jar app/build/libs/app.jar
```

### 4. Ejecutar las pruebas
```sh
gradle test
```

## Explicación de Mocks y Pruebas

El proyecto incluye pruebas unitarias en `UserServiceTest.java`, donde:
- Se utiliza **Mockito** para simular `RestTemplate` y evitar llamadas reales a la API externa.
- Se prueban dos casos:
  - **Caso de éxito (HTTP 200):** Se simula la respuesta de la API con un usuario válido.
  - **Caso de error (HTTP 404):** Se simula la respuesta de la API con un usuario no encontrado.

## Estructura del Proyecto
```
proyecto_5/
│── app/
│   ├── src/main/java/com/example/mocking/models/User.java
│   ├── src/main/java/com/example/mocking/service/UserService.java
│   ├── src/test/java/com/example/mocking/service/UserServiceTest.java
│   └── build.gradle
│── README.md
```

## Notas
- El servicio utiliza `RestTemplate.exchange()` en lugar de `getForObject()` para manejar mejor las respuestas HTTP.
- Se recomienda verificar que Java 17 esté instalado antes de compilar.

## Autor
- Desarrollado por [Tu Nombre]


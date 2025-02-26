package com.example.mocking.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.mocking.models.User;

/**
 * Servicio que realiza solicitudes HTTP a una API externa para obtener información de usuarios.
 * Utiliza RestTemplate para hacer peticiones GET y manejar respuestas HTTP.
 */
public class UserService {
    private final RestTemplate restTemplate;

    /**
     * Constructor por defecto que inicializa un nuevo RestTemplate.
     */
    public UserService() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Constructor para inyectar un RestTemplate (útil para pruebas unitarias con mocks).
     * @param restTemplate Objeto RestTemplate inyectado.
     */
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Realiza una solicitud HTTP GET para obtener los datos de un usuario desde la API externa.
     * @param userId ID del usuario a buscar.
     * @return Objeto User si se encuentra, o null si no existe.
     */
    public User getUserById(int userId) {
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, null, User.class);
        return response.getBody();
    }

    /**
     * Método main para probar la funcionalidad de UserService.
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = userService.getUserById(1);

        if (user != null) {
            System.out.println("Usuario obtenido: " + user.getName() + " - " + user.getEmail());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }
}


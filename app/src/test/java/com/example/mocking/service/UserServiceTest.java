package com.example.mocking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.mocking.models.User;

/**
 * Pruebas unitarias para UserService utilizando Mockito.
 * Se simula el comportamiento de RestTemplate para evitar llamadas reales a la API externa.
 */
public class UserServiceTest {
    private RestTemplate restTemplate;
    private UserService userService;

    /**
     * Configuración inicial antes de cada prueba.
     * Se crea un mock de RestTemplate y se inyecta en UserService.
     */
    @BeforeEach
    void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        userService = new UserService(restTemplate);
    }

    /**
     * Prueba un caso exitoso donde la API externa devuelve un usuario válido.
     * Se verifica que los datos retornados coincidan con los esperados.
     */
    @Test
    void testGetUserById_Success() {
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("John Doe");
        mockUser.setEmail("john@example.com");

        ResponseEntity<User> responseEntity = new ResponseEntity<>(mockUser, HttpStatus.OK);
        when(restTemplate.exchange(eq("https://jsonplaceholder.typicode.com/users/1"), 
            eq(HttpMethod.GET), any(), eq(User.class)))
            .thenReturn(responseEntity);

        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john@example.com", result.getEmail());
    }

    /**
     * Prueba un caso donde el usuario no es encontrado (HTTP 404).
     * Se verifica que el método devuelve null.
     */
    @Test
    void testGetUserById_NotFound() {
        ResponseEntity<User> responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        when(restTemplate.exchange(eq("https://jsonplaceholder.typicode.com/users/2"), 
            eq(HttpMethod.GET), any(), eq(User.class)))
            .thenReturn(responseEntity);

        User result = userService.getUserById(2);

        assertNull(result);
    }
}

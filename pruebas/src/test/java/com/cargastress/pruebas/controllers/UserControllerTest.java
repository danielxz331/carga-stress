package com.cargastress.pruebas.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testListUsers() throws Exception {
        List<Map<String, Object>> users = objectMapper.readValue(
                new ClassPathResource("users.json").getInputStream(),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        mockMvc.perform(get("/api/list-users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(users.get(0).get("id")))
                .andExpect(jsonPath("$[0].name").value(users.get(0).get("name")))
                .andExpect(jsonPath("$[0].email").value(users.get(0).get("email")))
                .andExpect(jsonPath("$[0].age").value(users.get(0).get("age")))
                .andExpect(jsonPath("$[0].address").value(users.get(0).get("address")))
                .andExpect(jsonPath("$[0].phone").value(users.get(0).get("phone")));
    }

    @Test
    public void testUsersToXlsx() throws Exception {
        mockMvc.perform(get("/api/usersToXlsx"))
                .andExpect(status().isOk())
                .andExpect(content().string("Archivo guardado en: usuarios.xlsx"));

        // Verificar que el archivo XLSX fue creado correctamente
        File file = new File("usuarios.xlsx");
        assertThat(file).exists();
    }

    @Test
    public void testAddUser() throws Exception {
        // Crear un JSON para el nuevo usuario
        String newUserJson = "{\"id\": 300, \"name\": \"New User\", \"email\": \"newuser@example.com\", \"age\": 25, \"address\": \"New Street 1\", \"phone\": \"+1-555-5555\"}";

        mockMvc.perform(post("/api/addUser")
                        .contentType("application/json")
                        .content(newUserJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Usuario añadido correctamente."));
    }
}

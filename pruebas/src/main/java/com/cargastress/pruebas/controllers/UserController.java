package com.cargastress.pruebas.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import java.nio.file.Paths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final ObjectMapper objectMapper;

    public UserController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<Map<String, Object>>> listUsers() {
        try {
            List<Map<String, Object>> users = readUsersFromFile();
            return ResponseEntity.ok(users);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/usersToXlsx")
    public ResponseEntity<String> usersToXlsx() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("users.json");
            List<Map<String, Object>> users = mapper.readValue(resource.getInputStream(), new TypeReference<>() {});

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Usuarios");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Age");
            headerRow.createCell(4).setCellValue("Address");
            headerRow.createCell(5).setCellValue("Phone");

            int rowNum = 1;
            for (Map<String, Object> user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(getStringValue(user, "id"));
                row.createCell(1).setCellValue(getStringValue(user, "name"));
                row.createCell(2).setCellValue(getStringValue(user, "email"));
                row.createCell(3).setCellValue(getStringValue(user, "age"));
                row.createCell(4).setCellValue(getStringValue(user, "address"));
                row.createCell(5).setCellValue(getStringValue(user, "phone"));
            }

            String filePath = "usuarios.xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
                workbook.write(fileOut);
            }
            workbook.close();

            return ResponseEntity.ok("Archivo guardado en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace(); // Agrega un registro para la excepción
            return ResponseEntity.status(500).body("Error al crear el archivo XLSX: " + e.getMessage());
        }
    }

    private String getStringValue(Map<String, Object> user, String key) {
        Object value = user.get(key);
        return value != null ? value.toString() : "";
    }

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody Map<String, Object> newUser) {
        try {
            List<Map<String, Object>> users = readUsersFromFile();
            users.add(newUser);
            writeUsersToFile(users);
            logger.info("Usuario añadido correctamente.");
            return ResponseEntity.ok(Map.of("message", "Usuario añadido correctamente."));
        } catch (IOException e) {
            logger.error("Error al añadir el usuario: " + e.getMessage());
            return ResponseEntity.status(500).body(Map.of("error", "Error al añadir el usuario: " + e.getMessage()));
        }
    }

    private List<Map<String, Object>> readUsersFromFile() throws IOException {
        String path = Paths.get("src/main/resources/users.json").toAbsolutePath().toString();
        File file = new File(path);
        return objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});
    }

    private void writeUsersToFile(List<Map<String, Object>> users) throws IOException {
        String path = Paths.get("src/main/resources/users.json").toAbsolutePath().toString();
        objectMapper.writeValue(new File(path), users);
    }
}

package com.cargastress.pruebas.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/list-users")
    public ResponseEntity<List<Map<String, Object>>> listUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("users.json");
            List<Map<String, Object>> users = mapper.readValue(resource.getInputStream(), new TypeReference<>() {});
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
                row.createCell(0).setCellValue(user.get("id").toString());
                row.createCell(1).setCellValue(user.get("name").toString());
                row.createCell(2).setCellValue(user.get("email").toString());
                row.createCell(3).setCellValue(user.get("age").toString());
                row.createCell(4).setCellValue(user.get("address").toString());
                row.createCell(5).setCellValue(user.get("phone").toString());
            }

            String filePath = "usuarios.xlsx";
            FileOutputStream fileOut = new FileOutputStream(new File(filePath));
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            return ResponseEntity.ok("Archivo guardado en: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error al crear el archivo XLSX: " + e.getMessage());
        }
    }
}

package com.demo.integration;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

@QuarkusTest
@Tag("integration")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRestResourceTestIT {

    @Test
    @DisplayName("Test create product")
    @Order(1)
    public void testCreateProduct() {
        JsonObject productJson = Json.createObjectBuilder()
                .add("name", "Apple")
                .add("price", new BigDecimal("100.00"))
                .add("price", new BigDecimal("100.00"))
                .build();
        given().contentType(MediaType.APPLICATION_JSON)
                .body(productJson.toString())
                .when()
                .post("/product/create")
                .then()
                .statusCode(201);

    }

    @Test
    @DisplayName("Test get prodcut by id")
    @Order(2)
    public void testGetProductById() {
        // TODO: Fix test
        given().when()
                .get("/product/get/1")
                .then()
                .body("name", hasItem("Apple"))
                .body("price", hasItem(19.90))
                .body("quantity", hasItem(100))
                .statusCode(200);

    }
}

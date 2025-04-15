package com.demo.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class HelloRestResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when()
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello"));
    }

    @Test
    public void testGreetingEndpoint() {
        String name = "Test";
        given().pathParam("name", name)
                .when()
                .get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello " + name));
    }
}

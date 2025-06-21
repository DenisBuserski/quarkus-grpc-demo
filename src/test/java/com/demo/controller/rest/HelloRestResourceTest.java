package com.demo.controller.rest;

import com.demo.service.HelloRestService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(HelloRestResource.class)
public class HelloRestResourceTest {

    @TestHTTPResource
    URL url;

    @InjectMock
    HelloRestService helloRestService;

    @Test
    @Order(1)
    public void testHelloEndpoint() {
        when(helloRestService.hello()).thenReturn("Hello");

        given().when()
                .get(url)
                .then()
                .statusCode(200)
                .body(is("Hello"));

        verify(helloRestService, times(1)).hello();
    }

    @Test
    @Order(2)
    @TestSecurity(user = "testUser", roles = {"jwt-user"})
    public void testGreetingEndpoint() {
        String name = "Test";
        when(helloRestService.greeting(name)).thenReturn("Hello " + name);

        given().pathParam("name", name)
                .when()
                .get(url + "/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello " + name));

        verify(helloRestService).greeting(name);
    }
}

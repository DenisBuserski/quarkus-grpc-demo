package com.demo.controller.rest;

import com.demo.service.HelloRestService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

// @QuarkusTest
public class HelloRestResourceTest {

    @TestHTTPEndpoint(HelloRestResource.class)
    @TestHTTPResource
    URL url;

    @InjectMock
    HelloRestService helloRestService;

    @Test
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

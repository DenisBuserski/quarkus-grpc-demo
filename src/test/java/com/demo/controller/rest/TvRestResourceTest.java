package com.demo.controller.rest;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

@QuarkusTest
@QuarkusTestResource(WiremockTvProxy.class)
public class TvRestResourceTest {

    @Test
    public void testGetTvSeries() {
        given().when()
                .param("title", "Lord")
                .get("/api/tv/get")
                .then()
                .body("id", hasItem(21029))
                .body("name", hasItem("Lord Tramp"))
                .body("url", hasItem("https://www.tvmaze.com/shows/21029/lord-tramp"))
                .statusCode(200);
    }

    @Test
    public void testGetTvSeriesWithWiremock() {
        given().when()
                .param("title", "denis")
                .get("/api/tv/get")
                .then()
                .body("id", hasItem(1))
                .body("name", hasItem("Lord Denis"))
                .body("url", hasItem("https://www.tvmaze.com/shows/1/denis"))
                .statusCode(200);
    }
}

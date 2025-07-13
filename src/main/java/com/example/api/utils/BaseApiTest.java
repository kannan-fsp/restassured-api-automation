package com.example.api.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class BaseApiTest {

    /**
     * Make a simple GET request to a given URL.
     */
    public Response sendGetRequest(String url) {
        return RestAssured
                .given()
                .when()
                .get(url);
    }

    /**
     * Make a POST request with JSON body to a given URL.
     */
    public Response sendPostRequest(String url, String jsonBody) {
        return RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                .when()
                    .post(url);
    }
    
    public Response sendPutRequest(String url, String jsonBody) {
        return io.restassured.RestAssured
                .given()
                    .contentType(io.restassured.http.ContentType.JSON)
                    .body(jsonBody)
                .when()
                    .put(url);
    }
    
    public String readJsonFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Later you can add:
    // - DELETE methods
    // - Common request specifications (e.g., base URI, headers, auth)
}

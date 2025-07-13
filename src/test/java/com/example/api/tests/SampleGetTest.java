package com.example.api.tests;

import com.example.api.utils.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleGetTest extends BaseApiTest {

    @Test
    public void testGetRequest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        Response response = sendGetRequest(url);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:\n" + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("userId"));
    }
}

package com.example.api.tests;

import com.example.api.utils.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SamplePutTest extends BaseApiTest {

    @Test
    public void testPutRequest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        String updatedBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"Updated Title from Automation\",\n" +
                "  \"body\": \"Updated body content\",\n" +
                "  \"userId\": \"1\"\n" +
                "}";

        Response response = sendPutRequest(url, updatedBody);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:\n" + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("Updated Title from Automation"));
    }
}

package com.example.api.tests;

import com.aventstack.extentreports.*;
import com.example.api.utils.BaseApiTest;
import com.example.api.utils.ExtentManager;
import io.restassured.response.Response;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

public class SamplePostTest extends BaseApiTest {
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

//    @DataProvider(name = "postData")
//    public Object[][] providePostData() {
//        return new Object[][] {
//            {"Title A", "Body content A", "1"},
//            {"Title B", "Body content B", "2"},
//            {"Title C", "Body content C", "3"}
//        };
//    }

    @Test
    public void testPostRequestFromFile() throws IOException {
    	test = extent.createTest("POST API Test - " );
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Get absolute path to the resource file
        String jsonPath = "src/test/resources/data/post-body.json";

        // Read JSON body as String
        String requestBody = readJsonFromFile(jsonPath);

        Response response = sendPostRequest(url, requestBody);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:\n" + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.getBody().asString().contains("Title from JSON file"));
    }

}

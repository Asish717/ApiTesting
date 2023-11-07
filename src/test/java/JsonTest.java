package com.selenium;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonTest {
    @Test
    public void getPost(){
        Response res=given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/posts");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("get post");
    }
    @Test
    public void getComment(){
        Response res=given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/comments");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("get comment");
    }
    @Test
    public void getProfile(){
        Response res=given()
                .header("accept","application/json")
                .when()
                .get("http://localhost:3000/profile");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("get profile");
    }
    @Test
    public void postApi() {
        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"title\": \"json server\",\n" +
                        "    \"author\": \"dash\"\n" +
                        "  }")
                .when()
                .post("http://localhost:3000/posts");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(), 201);
        System.out.println("posted api");
    }
    @Test(priority = 0)
    public void postComment() {
        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("    {\n" +
                        "        \"id\": 4,\n" +
                        "        \"body\": \"dash\",\n" +
                        "        \"postId\": 7777\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/comments");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(), 201);
        System.out.println("posted comment");
    }
    @Test
    public void postProfile() {
        Response res = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name2\": \"kumar\"\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(), 201);
        System.out.println("posted profile");
    }
    @Test(priority = 1)
    public void deletePost(){
        Response res=given()
                .header("accept","application/json")
                .pathParam("id","1")
                .when()
                .delete("http://localhost:3000/posts/{id}");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("user deleted");
    }
}

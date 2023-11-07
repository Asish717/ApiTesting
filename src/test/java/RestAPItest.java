import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAPItest {
    @Test(priority = 0)
    public void createUser(){
        Response res=given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 7777,\n" +
                        "  \"username\": \"asish\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"sbsb\",\n" +
                        "  \"password\": \"dash\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        res.prettyPrint();
        String msg=res.path("message");
        System.out.println(msg);
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("user created");
    }
    @Test
    public void userLoginQuery(){
        Response res=given()
                .header("accept","application/json")
                .queryParam("username","asish")
                .queryParam("password","asish")
                .when()
                .get("https://petstore.swagger.io/v2/user/login");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("user login query method");
    }
    @Test
    public void userLoginPath(){
        Response res=given()
                .header("accept","application/json")
                .pathParam("name","asish")
                .pathParam("pass","asish")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username={name}&password={pass}");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("user login path method");
    }
    @Test
    public void image(){
        File file=new File("C:\\Users\\hp\\Downloads\\download.jfif");
        Response res=given()
                .header("accept","application/json")
                .header("Content-Type","multipart/form-data")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/7777/uploadImage");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("image uploaded");
    }
    @Test
    public void placeOrder(){
        Response res=given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 777,\n" +
                        "  \"petId\": 7777,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2023-10-21T06:22:56.434Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("place order");
    }
    @Test
    public void findOrder(){
        Response res=given()
                .header("accept","application/json")
                .pathParam("orderId","7")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("find order");
    }
    @Test
    public void updateUser(){
        Response res=given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .pathParam("username","dash")
                .body("{\n" +
                        "  \"id\": 77,\n" +
                        "  \"username\": \"kumar\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/{username}");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("update user");
    }
    @Test(priority = 1)
    public void deleteUser(){
        Response res=given()
                .header("accept","application/json")
                .pathParam("username","asish")
                .when()
                .delete("https://petstore.swagger.io/v2/user/{username}");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("user deleted");
    }
    @Test(priority = 2)
    public void addPet(){
        Response res=given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 777,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 77,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 7,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("pet added");
    }
    @Test
    public void petReturnStatus(){
        Response res=given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        res.prettyPrint();
        Assert.assertEquals(res.statusCode(),200);
        System.out.println("Pet status updated");
    }
}
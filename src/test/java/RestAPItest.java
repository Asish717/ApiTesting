import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAPItest {
    @Test
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
        Assert.assertEquals(res.statusCode(),201);
    }

}

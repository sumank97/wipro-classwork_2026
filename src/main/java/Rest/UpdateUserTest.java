package Rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UpdateUserTest
{
    @Test
    public void updateUser()
    {
        String body =
        "{ \"firstName\":\"Kumar\" }";

        given()

        .header("Content-Type","application/json")

        .body(body)

        .when()

        .put("https://dummyjson.com/users/1")

        .then()

        .statusCode(200)

        .log().all();
    }
}
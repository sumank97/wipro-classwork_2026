package Rest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteUserTest
{
    @Test
    public void deleteUser()
    {
        given()

        .when()

        .delete("https://dummyjson.com/users/1")

        .then()

        .statusCode(200)

        .log().all();
    }
}
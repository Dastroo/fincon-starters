package eu.fincon.starterapp.controller;

import eu.fincon.starterapp.base.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static eu.fincon.starterapp.base.Fixtures.MULTIPLY_REQUEST;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathControllerTest extends BaseTest {

    @Test
    public void double_12_returns_200() {
        given()
                .when()
                .get("/math/double/12")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("24"));
    }

    @Test
    public void double_13_returns_200() {
        Integer result = given()
                .when()
                .get("/math/double/13")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .as(Integer.class);

        assertEquals(26, result);
    }

    @Test
    public void multiply_returns_200() {
        given()
                .body(MULTIPLY_REQUEST)
                .contentType(ContentType.JSON)
                .when()
                .post("/math/multiply")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "a", is(6),
                        "b", is(9),
                        "result", is(54)
                );
    }
}
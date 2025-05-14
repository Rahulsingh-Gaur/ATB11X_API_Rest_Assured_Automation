package ex_04_RA_HTTP_method;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

public class Lab_005_Create_POST_method{

    RequestSpecification rs;
    Response  r;
    ValidatableResponse vr;

    @Test public void test_Create_booking(){
        String payload ="{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Singh\",\n" +
                "    \"totalprice\" : 11700,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast eggs\"\n" +
                "}";

        // Pre condition Given()
        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking");
        rs.contentType("application/json");
        rs.body(payload).log().all();

        // Selecting the method
        r= rs.when().log().all().post();

        //Verficaiton part

        vr= r.then().log().all();
        vr.statusCode(200);




    }

}

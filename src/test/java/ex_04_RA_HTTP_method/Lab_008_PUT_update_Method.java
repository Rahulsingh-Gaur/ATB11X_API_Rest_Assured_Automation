package ex_04_RA_HTTP_method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab_008_PUT_update_Method {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test public void test_PUT_update (){

        String Booking_ID="783";
        String Token ="51ce7e27913fa26";
        String payload ="{\n" +
                "    \"firstname\" : \"Hajari\",\n" +
                "    \"lastname\" : \"Gaur\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking/" + Booking_ID);
        rs.cookie("token" ,Token);
        rs.body(payload);
        rs.contentType(ContentType.JSON);

        r=rs.when().log().all().put();

        vr=r.then().log().all();
        vr.statusCode(200);


    }
}

package ex_04_RA_HTTP_method;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Lab_006_Get_Single_Booking {

    private static final Logger log = LoggerFactory.getLogger(Lab_006_Get_Single_Booking.class);
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;
    @Test public void test_Get_single_booking(){

        String Booking_ID ="4901";


        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + Booking_ID);

        r=rs.when().log().all().get();

        vr=r.then().log().all();
        vr.statusCode(200);


    }
}

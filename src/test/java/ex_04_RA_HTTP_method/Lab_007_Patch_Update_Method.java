package ex_04_RA_HTTP_method;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab_007_Patch_Update_Method {

    RequestSpecification  rs;
    Response r;
    ValidatableResponse vr;

    @Test public void test_Partial_Update_patch(){


        String Token="80cf289c18aebb8";
        String Booking_ID="4901";
        String payload = "{\n" +
                "    \"firstname\" : \"Ram\",\n" +
                "    \"lastname\" : \"Hanuman\"\n" +
                "}";


        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + Booking_ID);
        rs.body(payload).log().all();
        rs.cookie("token", Token);

        //https://chat.deepseek.com/a/chat/s/a3b1637d-0b1e-4968-8f77-dba354b1d1b8

        //The Content-Type header tells the server how to interpret the data you’re sending in
        // the request body. If it’s missing or incorrect, the server may:
        //   Ignore your data (resulting in no updates).
        //    Fail to parse the payload (leading to errors like 400 Bad Request).
        //    Treat the data as plain text instead of JSON.
        rs.contentType(ContentType.JSON);


        r=rs.when().patch();

        vr=r.then().log().all() ;
        vr.statusCode(200);


}
    }

package ex_06_RA_Payload_managment.HASH_Payload;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Create_Booking_Post_Hash_payload {
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;


    @Test(invocationCount = 1)
    public void test_Create_booking(){
//        String payload ="{\n" +
//                "    \"firstname\" : \"Rahul\",\n" +
//                "    \"lastname\" : \"Singh\",\n" +
//                "    \"totalprice\" : 11700,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast eggs\"\n" +
//                "}";
        //hashmap
        Map<String,Object> jsonbody =new LinkedHashMap<>();
        jsonbody.put("firstname","Rahul");
        jsonbody.put("lastname","Singh");
        jsonbody.put("totalprice","11700");
        jsonbody.put("depositpaid",true);

        Map<String ,Object> JosnDatebooking=new LinkedHashMap<>();
        JosnDatebooking.put("checkin","2018-01-01");
        JosnDatebooking.put("checkout","2019-01-01");

        jsonbody.put("bookingdates",JosnDatebooking);
        jsonbody.put("additionalneeds","Breakfast");


        // Pre condition Given()
        rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking");
        rs.contentType("application/json");
        rs.body(jsonbody).log().all();

        // Selecting the method
        r= rs.when().log().all().post();

        //Verficaiton part

        vr= r.then().log().all();
        vr.statusCode(200);





    }

}

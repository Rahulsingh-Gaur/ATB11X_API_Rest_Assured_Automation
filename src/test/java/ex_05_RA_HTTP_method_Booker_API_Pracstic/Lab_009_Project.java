package ex_05_RA_HTTP_method_Booker_API_Pracstic;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab_009_Project {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;
    String Token_new;
    String Booking_ID;

    @Description("TC 1 : Check the Token Generation and Storing the token value ")
    @Test(priority = 1)
    public void test_Create_token() {

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("auth");
        rs.contentType("application/json");
        rs.body(payload);

        r = rs.when().log().all().post();

        vr = r.then().log().all();
        vr.statusCode(200);

        //asseration
        vr.body("token", Matchers.notNullValue());
        // Store the Token
        Token_new = r.jsonPath().getString("token");
        System.out.println("The new token is :" + Token_new);

    }

    @Description("TC 2 : Valdiate the Booking Creating and Check the Post api Response and Status code")
    @Owner("Rahulsingh")
    @Test(priority = 2)
    public void test_Post_Createbooking() {

        String Token = Token_new;
        String payload = "{\n" +
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
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking");
        rs.contentType("application/json");
        rs.body(payload).log().all();

        // Selecting the method
        r = rs.when().log().all().post();

        //Verficaiton part

        vr = r.then().log().all();
        vr.statusCode(200);

        //Asseartion
        vr.body("booking.firstname", Matchers.equalTo("Rahul"));
        vr.body("booking.lastname", Matchers.equalTo("Singh"));
        //vr.body("booking.depositpaid", Matchers.equalTo("true"));
        vr.body("bookingid", Matchers.notNullValue());

        //Get booking id
        Booking_ID = r.jsonPath().getString("bookingid");
        System.out.println("Booking id is " + Booking_ID);
    }

    @Description("TC 3: Check the Single Get Req. to validate the Created booking")
    @Test(priority = 3)
    public void test_Get_Single_booking() {

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + Booking_ID);
        r = rs.when().log().all().get();

        vr = r.then().log().all();
        vr.statusCode(200);
    }

    @Description("TC 4: Update First and last name using patch Rreq.")
    @Test(priority = 4)
    public void test_Patch_Req() {

        String payload = "{\n" +
                "    \"firstname\" : \"Ram\",\n" +
                "    \"lastname\" : \"Hanuman\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + Booking_ID);
        rs.body(payload).log().all();
        rs.cookie("token", Token_new);
        rs.contentType(ContentType.JSON);

        r=rs.when().patch();

        vr=r.then().log().all() ;
        vr.statusCode(200);

    }

    @Description("TC 5 : Check Delete API")
    @Test (priority = 5)
    public void test_Delete_Booking(){

        rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("booking/" +Booking_ID);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",Token_new);

        r=rs.when().delete();

        vr=r.then().log().all();
        vr.statusCode(201);

    }
}

package ex_01_RA_Pincode;

import io.restassured.RestAssured;

public class Lab_001_Pincode_basic {


public static void main(String[] args) {

// pin code =https://api.postalpincode.in/pincode/110001
// "https://api.zippopotam.us/IN/110002"
    RestAssured
            .given()
                  .baseUri("https://api.postalpincode.in/")
                  .basePath("/pincode/110001")
            .when()
                  .get()
            .then()
                  .log().all().statusCode(200);



}





    }


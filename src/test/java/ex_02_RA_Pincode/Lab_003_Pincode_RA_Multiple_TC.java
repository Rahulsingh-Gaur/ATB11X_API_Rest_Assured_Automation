package ex_02_RA_Pincode;

import io.restassured.RestAssured;

public class Lab_003_Pincode_RA_Multiple_TC {
    public static void main(String[] args) {
        String pincode="421503";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("/pincode/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);

       pincode="00000";
        RestAssured
                .given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("/pincode/"+pincode)
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}

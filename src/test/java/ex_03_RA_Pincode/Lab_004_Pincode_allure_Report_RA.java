package ex_03_RA_Pincode;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab_004_Pincode_allure_Report_RA {
    @Test
        public void test_Pincode_postive_case(){
            String pincode ="421503";
            RestAssured.given()
                    .baseUri("https://api.postalpincode.in/")
                    .basePath("/pincode/"+pincode)
                    .when().get()
                    .then().log().all().statusCode(200);


    }
    @Test
    public void test_pincode_negative_case(){
        String pincode ="000000";
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("/pincode/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_pincode_negative_case1(){
        String pincode ="Rahul";
        RestAssured.given()
                .baseUri("https://api.postalpincode.in/")
                .basePath("/pincode/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }

}



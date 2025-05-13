package ex_01_RA_Pincode;

import io.restassured.RestAssured;

import java.util.Scanner;

public class Lab_002_Pincode_Test_Scanner {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enther the pincode");
        String pincode= sc.next();

        RestAssured
                .given().baseUri("https://api.postalpincode.in/")
                .basePath("/pincode/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);


    }
}

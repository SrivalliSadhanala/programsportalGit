package org.epam.programsportal.tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProgramsPortalAPI {

    public static String ENDPOINT_GET_SPEAKER = "http://epinhydw0087:9090/programs/speaker";
    public static String Base_URI = "http://epinhydw0087:9090/programs/";
    public String id = "32";

    RequestSpecification httpRequest = given();

    @Test
    public void testgetByCollege() {

        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.get("colleges/999");
        System.out.println(response.getStatusLine()+"-----------------"+response.getStatusCode());
        System.out.println(response.asString());
    }

    @Test
    public void testByCollegeId() {

        Response response = httpRequest.request(Method.GET,Base_URI+"colleges/name/jntuk");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }

//    @Test
//    public void testByCollegeIdHashMap() {
//
//        HashMap speaker =  httpRequest.get(ENDPOINT_GET_SPEAKER+id).as(HashMap.class);
//        System.out.println(speaker.values());
//    }


    @Test
    public void testPostCollege(){       //adding_a_college
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-type","application/json");
        JSONObject body = new JSONObject();
        body.put("city","BVRM");
        body.put("collegeId","999");
        body.put("collegeName","SrivalliCollege");
        body.put("group","CSE");
        body.put("ptoEmail","satya@abc.com");
        body.put("ptoMobile","442342342");
        body.put("ptoName","Srivalli");
        body.put("status","Active");
        requestSpecification.body(body.toString());
        Response response = requestSpecification.request(Method.POST,"colleges");
        //testByCollegeId();
        System.out.println(response.asString());
    }

    @Test
    public void testPutCollege() {      //editing_a_college
        RestAssured.baseURI = "http://epinhydw0087:9090/programs/";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-type","application/json");
        JSONObject body = new JSONObject();
        body.put("city","TPG");
        //body.put("collegeId","999");
        body.put("collegeName","JNTUK");
        body.put("group","CSE");
        body.put("ptoEmail","satya@abc.com");
        body.put("ptoMobile","442342342");
        body.put("ptoName","Srivalli");
        body.put("status","Active");
        requestSpecification.body(body.toString());
        Response response = requestSpecification.request(Method.PUT,"colleges/999");
        //testByCollegeId();
        System.out.println(response.asString());
    }

    @Test
    public void deleteCollegeById() {

        Response response = httpRequest.request(Method.DELETE,Base_URI+"colleges/195");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

    }


}

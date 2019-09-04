package Post_Request;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Registration_Api_Test {

	
	
	
	@Test
	 void Registration() {
		
	//DEFINE URL
	RestAssured.baseURI="https://reqres.in/api";
	
	//REQUEST OBJECT
	RequestSpecification httprequest=RestAssured.given();
	
	JSONObject requestparam=new JSONObject();
	requestparam.put("FirstName", "sulman");
	requestparam.put("Lastname", "Islam");
	
	httprequest.header("Contecnt-Type","application/jason");
	httprequest.body(requestparam.toJSONString());
	
	
	//REQUEST OBJECT
	Response response=httprequest.request(Method.POST,"/register");
	
	//Getting the Response Body
   String responsebody= response.getBody().asString();
	System.out.println("This is the Response Body"+responsebody);
	
	
	//Getting the Status Code
	int statuscode=response.getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, 200);
	
	//Getting the Status Line
    String statusline=response.getStatusLine();
	System.out.println("StatusLine is===>>"+statusline);
	
	
	
	
	}
}

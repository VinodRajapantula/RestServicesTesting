package myTests;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONException;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import org.json.JSONException;


public class RestTests {



	//@Test
	public void getUser() throws JSONException {
		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.get("https://test.epm-inob.projects.epam.com/epmob/user")
		.then()
		.body("email", equalTo("admin@admin.com"));		
	}

	//@Test
	public void createUser() throws JSONException {
		CreateUser user = new CreateUser();
		user.setContentApprover("false");
		user.setEmail("Autotest27@eepa.com");
		user.setFirstName("Autotest27");
		user.setUserType("TA");

		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.body(user)		
		.post("https://test.epm-inob.projects.epam.com/epmob/user/internal")
		.then()
		.contentType("")		
		.statusCode(200);
	}

	//@Test
	public void updateUser() throws JSONException {
		CreateUser user = new CreateUser();
		user.setContentApprover("false");
		user.setEmail("Autotest22@eepa.com");
		user.setFirstName("Autotestaaa");
		user.setUserType("TA");
		user.setLastName("AutotestastNameaaa");	
		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.body(user)		
		.put("https://test.epm-inob.projects.epam.com/epmob/user/internal")
		.then()		
		.contentType("")	
		.statusCode(200);
	}

	//@Test
	public void deletedUser() throws JSONException {
		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.delete("https://test.epm-inob.projects.epam.com/epmob/user/internal?email=Autotest25@eepa.com")
		.then()
		.statusCode(200);
	}

	//@Test
	public void isUserDeleted() throws JSONException {
		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.get("https://test.epm-inob.projects.epam.com/epmob/user/internal?pageNumber=1&pageSize=1&searchByFirstName=Autotest25")
		.then()
		.body("metaDataDTO.totalElements", equalTo(0));
	}

	@Test
	public void isUserDeletedStatus() throws JSONException {
		given()
		.relaxedHTTPSValidation("TLS")
		.auth().basic("admin@admin.com", "Epam123$")
		.contentType("application/json")
		.get("https://test.epm-inob.projects.epam.com/epmob/user/internal?pageNumber=1&pageSize=1&searchByFirstName=AutoTest25")
		.then()
		.statusCode(200);
	}

}

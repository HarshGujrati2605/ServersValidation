package testlib.servervalidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import CoreLib.Excelutil.ExcelDataSupplier;
import CoreLib.ListnerUtil.ITestListners;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(ITestListners.class)
public class ServerResponsesValidation {
	
	@Test(testName = "Server Validation", dataProviderClass = ExcelDataSupplier.class, dataProvider = "readDataFromExcel")
	public void validateServer(String instanceurl) throws Exception {			
	 String body = "{\r\n"
	 		+ " \"clientId\": \"aim-read-write-client\",\r\n"
	 		+ " \"username\": \"BuzzUATApiUser\",\r\n"
	 		+ " \"password\": \"BuzzUAT@202\"\r\n"
	 		+ "}";
	 System.out.println(instanceurl);
	 RestAssured.baseURI = instanceurl;
	 RestAssured.basePath = "/oauth/token";
		RestAssured.useRelaxedHTTPSValidation();
		Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(body).when().post().then()
				.extract().response();

         if(response.getStatusCode()>=500) {
        	 System.out.println("response code for the "+instanceurl+"  is "+response.getStatusCode()+"");
        	 throw new Exception("Server is down for "+instanceurl+"");
         }
         
         else if(response.getStatusCode()>=200 | response.getStatusCode()<500) {
        	 
        	 System.out.println("response code for the "+instanceurl+"  is "+response.getStatusCode()+" and it is running fine");
        	 
         }

	}

}

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getMethodTests {

    @Test
    void getTest(){

        // specify Base URI
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        // Request object
        RequestSpecification httprequest = RestAssured.given();

        // Response Object
        Response responce = httprequest.request(Method.GET,"/employees");

        // print responce in console
        String responseBody = responce.getBody().asString();
        System.out.println("Response Body Is : " + responseBody);

        // Validation of status code
        int statusCode = responce.getStatusCode();
        Assert.assertEquals(statusCode,429);

        // status lone verfication
        String statusLine = responce.getStatusLine();
        System.out.println("Status Line is : " + statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 429 Too Many Requests");

    }
}

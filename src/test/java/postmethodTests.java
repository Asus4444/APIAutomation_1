import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class postmethodTests {

    @Test
    void postTest(){

        // specify Base URI
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        // Request object
        RequestSpecification httprequest = RestAssured.given();

        // Request object
        // Body payload allong withpost request
        JSONObject requestPara = new JSONObject();
        requestPara.put("name","Akshay");
        requestPara.put("salary","123");
        requestPara.put("age","25");
        requestPara.put("id","25");

        httprequest.header("Content-Type","application/Json");
        httprequest.body(requestPara.toJSONString());

        // Response Object
        Response responce = httprequest.request(Method.POST,"/create");

        String responseBody = responce.getBody().asString();
        System.out.println("Response Body Is : " + responseBody);

        // Validation of status code
        int statusCode = responce.getStatusCode();
        Assert.assertEquals(statusCode,406);







    }
}

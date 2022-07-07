import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APITests {
    @Test
    void test1(){

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/todos/");
        System.out.println("Status Code : "  + response.getStatusCode());
        System.out.println("Status line is : " + response.getStatusLine());
        System.out.println(" Response : " + response.asString());
        System.out.println("Body : " + response.getBody().asString());
        System.out.println("Time taken: " + response.getTime());

        //Status Code Validation
        int statusCode= response.getStatusCode();
        System.out.println("Status code is : " + statusCode);
                Assert.assertEquals(statusCode,200);
        //Status line Validation
              String Statusline= response.getStatusLine();
        System.out.println("Status line is : " + Statusline);
        Assert.assertEquals(Statusline,"HTTP/1.1 200 OK");

        //Verify that the field completed is false for id: 2
       String key ="userID";
        System.out.println(response.jsonPath().getList(key).get(1));

    }
}

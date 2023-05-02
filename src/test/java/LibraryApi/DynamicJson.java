package LibraryApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {

    @Test(dataProvider = "BooksData")

    public void addBook(String isbn,String aisle){
        RequestSpecification req =  new RequestSpecBuilder().setBaseUri("http://216.10.245.166").setContentType(ContentType.JSON).build();
        ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();


        String response = given().spec(req)
                .body(files.Payload.addBook(aisle,isbn))
        .when().log().all()
                .post("/Library/Addbook.php")
        .then().spec(resp).log().all()

        .extract()
                .response()
                .asString();
        JsonPath js = new JsonPath(response);
        String id = js.getString("ID");
        System.out.println(id);


        }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"test1", "123dsd"}, {"test2", "1234asdad"}, {"test3", "12345gfasdf"}};

}}

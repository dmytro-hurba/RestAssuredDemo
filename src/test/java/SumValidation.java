import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
            public  void sumValidation(){
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        int actualPurchaseAmount=0;
        for (int i=0;i<count;i++){
        actualPurchaseAmount += js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies");


    }Assert.assertEquals(actualPurchaseAmount,js.getInt("dashboard.purchaseAmount"));

    }}

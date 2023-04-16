import files.Payload;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.lang.reflect.Array;

import static org.hamcrest.Matchers.equalTo;


public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println(firstCourseTitle);
        for (int i = 0; i < count;i++){
            System.out.println(js.getString("courses["+i+"].title"));
            System.out.println(js.getInt("courses["+i+"].price"));
            }


        for (int i = 0;i<count;i++){
            String courseTitle = js.getString("courses["+i+"].title");
            if(courseTitle.equalsIgnoreCase("RPA")){
                System.out.println(js.getString("courses["+i+"].copies"));
                break;


                }}









            }
        }




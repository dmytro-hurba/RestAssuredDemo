package Pojo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class PojoClass {
    private String stageName;
    private String categoryCode;
    private String eventStartTime;

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    @BeforeTest
    public void setup() {
        // Code to be executed before any test methods within the class
    }

    @DataProvider(name = "eventDataForSubscription")
    public Object[][] dataPreparation() {
        return new Object[][]{};
    }
}

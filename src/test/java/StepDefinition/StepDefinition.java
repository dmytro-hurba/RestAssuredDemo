package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("^user in on  NetBanking landing page$")
    public void user_in_on_netbanking_landing_page() throws Throwable {
        System.out.println("navigated to login URL");
    }

    @When("^user  login to application with username and password$")
    public void user_login_to_application_with_username_and_password() throws Throwable {
        System.out.println("Logged in success");
    }

    @Then("^homepage is populated$")
    public void homepage_is_populated() throws Throwable {
        System.out.println("validated homepage");
    }

    @And("^cards is displayed$")
    public void cards_is_displayed() throws Throwable {
    }

    }






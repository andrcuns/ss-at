package lv.ss.at.cukes.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Allure;

@ScenarioScoped
public class BlankStepDefs {

    @Given("I run the first step")
    public void step_one() {}

    @When("I run second step with argument {string}")
    public void step_two(String someArg) {}

    @When("I run step with data table")
    public void step_two_table(DataTable table) {}

    @Then("step should pass")
    public void step_pass() {}

    @Then("step should fail with attachment")
    public void step_fail() throws Exception {
        String attachmentTxt = "I am some attachment text";
        Allure.getLifecycle().addAttachment("Attach", "text/plain", "txt", attachmentTxt.getBytes());
        throw new Exception("Some random failure");
    }
}

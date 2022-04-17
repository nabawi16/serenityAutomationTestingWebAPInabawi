package orange_hrm.stepdefinitions;


import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import orange_hrm.pageobjects.HRMPIMPageObjects;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;
import tasks.VerifyDisplayed;

public class PIMStepDefinitions {
    // Add Employee --Begin
    @When("{actor} add new employee with required field only")
    public void iAddNewEmployeeWithRequiredFieldOnly(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("Add"),
                InputText.onField("firstName", "Ferawati"),
                InputText.onField("lastName", "Pratiwi"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see my Personal Details")
    public void iCanSeeMyPersonalDetails(Actor actor) throws Exception{
        actor.attemptsTo(VerifyDisplayed.element("Personal Details"));
    }
    // Add Employee --End

    // Update Employee --Begin
    @When("{actor} update new employee's middle name")
    public void iUpdateNewEmployeeSMiddleName(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.employeeList(),
                ClickOn.button("Edit"),
                InputText.onField("editMiddleName", "Bawi"),
                ClickOn.button("Save")
        );
    }

    @Then("{actor} can see the Personal Details has changed")
    public void iCanSeeThePersonalDetailsHasChanged(Actor actor) throws Exception{
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObjects.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("Bawi")
        );
    }
    // Update Employee --End

    // Delete Employee --Begin
    @And("{actor} delete new employee")
    public void iDeleteNewEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("Delete"),
                ClickOn.button("Ok")
        );
    }

    @And("{actor} can't see delete employee on list")
    public void iCanTSeeDeleteEmployeeOnList(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }
    // Delete Employee --End

    // Read Employee --Begin
    @And("{actor} access employee list")
    public void iAccessEmployeeList(Actor actor) throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("HRM Employee List"));
    }

    @And("{actor} can see new employee list result")
    public void iCanSeeNewEmployeeListResult(Actor actor) throws Exception{
        actor.attemptsTo(VerifyDisplayed.element("Employee List"));
    }
    // Read Employee --Begin

    // Search Employee --Begin
    @And("{actor} search for new employee")
    public void iSearchForNewEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                InputText.onField("employeeName", "Ferawati"),
                ClickOn.button("Search")
        );
    }
    // Search Employee --End
}

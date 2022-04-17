package tasks;

import fb.pageobjects.LoginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import orange_hrm.pageobjects.HRMLoginPageObjects;
import orange_hrm.pageobjects.HRMPIMPageObjects;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOn {
    public static Performable employeeList(){
        return Task.where("{0} click first employee",
                Click.on(HRMPIMPageObjects.FIRST_EMPLOYEE_LIST)
        );
    }

    public static Performable checkbox(){
        return Task.where("{0} click checkbox on first employee",
                Click.on(HRMPIMPageObjects.FIRST_EMPLOYEE_CHECKBOX)
        );
    }
    public static Performable button(String buttonType) throws Exception{
        Target button;

        switch (buttonType){
            case "FB  Log In":
                button = LoginPageObjects.LOGIN_BUTTON;
                break;
            case "HRM Login":
                button = HRMLoginPageObjects.LOGIN_BUTTON;
                break;
            case "Add":
                button = HRMPIMPageObjects.ADD_BUTTON;
                break;
            case "Save":
                button = HRMPIMPageObjects.SAVE_BUTTON;
                break;
            case "Edit":
                button = HRMPIMPageObjects.EDIT_BUTTON;
                break;
            case "Delete":
                button = HRMPIMPageObjects.DELETE_BUTTON;
                break;
            case "Ok":
                button = HRMPIMPageObjects.OK_BUTTON;
                break;
            case "Search":
                button = HRMPIMPageObjects.SEARCH_BUTTON;
                break;
            default:
                throw new Exception("There is no button type: " + buttonType);
        }

        WaitUntil.the(button, isVisible()).forNoMoreThan(25).seconds();

        return Task.where("{0} click " + buttonType + " button",
                Click.on(button)
        );
    }
}

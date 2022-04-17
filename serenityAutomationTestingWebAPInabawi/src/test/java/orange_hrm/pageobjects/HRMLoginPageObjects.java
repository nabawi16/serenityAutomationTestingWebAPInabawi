package orange_hrm.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/")
public class HRMLoginPageObjects extends PageObject {
    public static Target USERNAME_FIELD = Target.the("username field")
            .locatedBy("#txtUsername");
    public static Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#txtPassword");
    public static Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("#btnLogin");
}

package fb.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.facebook.com/login")
public class LoginPageObjects extends PageObject {
    public static Target EMAIL_FIELD = Target.the("email field")
            .locatedBy("#email");
    public static Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#pass");
    public static Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("#loginbutton");
}

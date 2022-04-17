package orange_hrm.stepdefinitions;

import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.Actor;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;

public class LoginStepDefinitons {
    @Given("{actor} open Orange HRM login page")
    public void iOpenOrangeHRMLoginPage(Actor actor) throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("HRM Login"));
    }

    @When("{actor} input username and password")
    public void iInputUsernameAndPassword(Actor actor) throws Exception{
        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("USERNAME_HRM");
        String password = dotenv.get("PASSWORD_HRM");

        actor.attemptsTo(
                InputText.onField("HRM username", username),
                InputText.onField("HRM password", password)
        );
    }

    @And("{actor} click login button")
    public void iClickLoginButton(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("HRM Log In")
        );
    }

    @Then("{actor} can login successfully")
    public void iCanLoginSuccessfully(Actor actor) throws Exception{
        actor.attemptsTo(Ensure.thatTheCurrentPage().currentUrl().contains("/index.php/dashboard"));
    }
}

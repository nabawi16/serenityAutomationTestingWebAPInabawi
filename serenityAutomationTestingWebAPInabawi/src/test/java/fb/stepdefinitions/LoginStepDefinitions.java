package fb.stepdefinitions;


import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import tasks.ClickOn;
import tasks.InputText;
import tasks.NavigateTo;

public class LoginStepDefinitions {
    @Given("{actor} open facebook login page")
    public void iOpenFacebookLoginPage(Actor actor) throws Exception{
        actor.wasAbleTo(NavigateTo.theURL("FB Login"));
    }

    @When("{actor} input email and password")
    public void iInputEmailAndPassword(Actor actor) throws Exception{
        Dotenv dotenv = Dotenv.load();

        String email = dotenv.get("EMAIL_FB");
        String password = dotenv.get("PASSWORD_FB");

        actor.attemptsTo(
                InputText.onField("FB email", email),
                InputText.onField("FB password", password)
        );
    }

    @And("{actor} click button login")
    public void iClickButtonLogin(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("FB Log In")
        );
    }
}

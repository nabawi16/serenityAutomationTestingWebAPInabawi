package fb.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.codehaus.groovy.tools.shell.util.Logger.io;

public class ParameterStepDefinitions {
    @ParameterType(".*")
    public Actor actor(String actorName){
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
}

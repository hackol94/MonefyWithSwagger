package com.training.api.stepdefinitions;

import com.training.api.actors.NavigateTo;
import io.cucumber.java8.En;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class SearchInGoogleStepDefinition implements En {


    public SearchInGoogleStepDefinition(){
        Given("que {word} usa el navegador para realizar una busqueda en google",(String actor) -> {
            System.out.println(actor);
            OnStage.theActor(actor);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    NavigateTo.theGoogleHomePage()
            );
        });
        When("solicite información a google sobre pinguinos",() -> {

        });
        Then("google le debera mostrar paginas relacionadas con pinguinos",() -> {

        });
    }
}

package com.training.api.stepdefinitions;

import constans.Constant;
import io.cucumber.java8.En;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CommonStep implements En {

    public CommonStep(){
        Given("{word} needs to manage his pet inventory", (String actor) ->{
            OnStage.theActor(actor).whoCan(CallAnApi.at(OnStage.theActorInTheSpotlight().recall(Constant.BASE_URL)));
        });
    }

}

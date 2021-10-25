package com.training.api.stepdefinitions;

import com.training.api.actors.ApiCast;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook implements En {
    EnvironmentVariables environmentVariables;

    @Before(order = 0)
    public void settingEnvironment(){
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();
        OnStage.setTheStage(new ApiCast(environmentVariables));
    }

}

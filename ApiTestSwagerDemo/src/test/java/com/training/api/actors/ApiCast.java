package com.training.api.actors;


import com.training.api.TestEnvironments;
import constans.Constant;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.thucydides.core.util.EnvironmentVariables;

public class ApiCast extends Cast {

    TestEnvironments testEnvironments;

    public ApiCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {

        Actor newActor = super.actorNamed(actorName, abilities).describedAs( "Aplicación que realiza peticiones al sistema representada por un actor" );
        newActor.remember(Constant.BASE_URL, testEnvironments.getUrlBase());
        newActor.remember(Constant.PATH_INVENTORY, testEnvironments.getPathInventory());
        newActor.remember(Constant.PATH_ORDER, testEnvironments.getPathOrder());
        return newActor;

    }
}

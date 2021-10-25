package com.training.api.actors;


import com.training.api.TestEnvironments;
import constans.Constant;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

public class ApiCast extends Cast {

    TestEnvironments testEnvironments;

    public ApiCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {

        Actor newActor = super.actorNamed(actorName, abilities).describedAs( "Aplicación que realiza peticiones al sistema representada por un actor" );
        if (newActor.abilityTo(BrowseTheWeb.class) == null) {
            newActor.can(BrowseTheWeb.with(theDefaulteBrowserFor(actorName)));
            System.out.println("BrowserOK");
        }
        System.out.println("CONTExto : ------ " + testEnvironments.getContext());
        newActor.remember(Constant.BASE_URL, testEnvironments.getUrlBase());
        newActor.remember(Constant.PATH_INVENTORY, testEnvironments.getPathInventory());
        newActor.remember(Constant.PATH_ORDER, testEnvironments.getPathOrder());
        System.out.println("APÏCASTT");
        return newActor;

    }

    private WebDriver theDefaulteBrowserFor(String actorName) {
        return ThucydidesWebDriverSupport.getWebdriverManager().getWebdriverByName(actorName);
    }
}

package com.training.api.actors;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theGoogleHomePage() {
        return Task.where("{0} opens the Google home page",
                Open.browserOn().the(GooglePage.class));
    }
}

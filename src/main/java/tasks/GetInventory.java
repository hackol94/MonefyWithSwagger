package tasks;

import constans.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetInventory implements Task {

    public GetInventory(){}

    public static GetInventory pets(){
        return instrumented(GetInventory.class);
    }

       @Override
    public <T extends Actor> void performAs(T actor) {
           actor.attemptsTo(
                   Get.resource(
                           actor.recall(Constant.PATH_INVENTORY)
                           )
                           .with(
                                   request ->
                                           request
                                                   .contentType(ContentType.JSON)
                           ));
    }
}

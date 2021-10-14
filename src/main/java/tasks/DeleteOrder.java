package tasks;

import constans.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteOrder implements Task {

    public String order;

    public DeleteOrder(String order){this.order = order;}

    public static DeleteOrder inTheStore(String order){
        return instrumented(DeleteOrder.class, order);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(actor.recall(Constant.PATH_ORDER)+"/"+order).with(
                        request -> request
                                .contentType(ContentType.JSON)
                )
        );
    }
}
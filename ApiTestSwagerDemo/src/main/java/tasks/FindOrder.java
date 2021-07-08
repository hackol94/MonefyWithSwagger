package tasks;

import constans.Constant;
import io.restassured.http.ContentType;
import model.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FindOrder implements Task {

    public String order;

    public FindOrder(String order){this.order = order;}

    public static FindOrder inTheStore(String order){
        return instrumented(FindOrder.class, order);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(actor.recall(Constant.ID_NEW_ORDER) != null){
            order = actor.recall(Constant.ID_NEW_ORDER);
        }
        actor.attemptsTo(
                Get.resource(actor.recall(Constant.PATH_ORDER)+"/"+order).with(
                        request -> request
                                .contentType(ContentType.JSON)
                )
        );
    }
}
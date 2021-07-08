package tasks;

import Util.DateIso8601;
import constans.Constant;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import model.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateOrder implements Task {

    List<Map<String, String>> table;

    public CreateOrder(List<Map<String, String>> table){
        this.table = table;
    }

    public static CreateOrder inTheStore(List<Map<String, String>> table){
        return instrumented(CreateOrder.class, table);
    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(Constant.ID_NEW_ORDER, new Random().nextInt((150 - 1) + 1) + 1);
        actor.attemptsTo(
                Post.to(actor.recall(Constant.PATH_ORDER)).with(
                        request -> request
                        .contentType(ContentType.JSON)
                        .body(
                                Order.builder()
                                        .id(actor.recall(Constant.ID_NEW_ORDER))
                                        .petId(Integer.parseInt(table.get(0).get("petId")))
                                        .complete(Boolean.getBoolean(table.get(0).get("complete")))
                                        .quantity(Integer.parseInt(table.get(0).get("quantity")))
                                        .shipDate(DateIso8601.now())
                                        .status(table.get(0).get("status"))
                                        .build()
                        )
                )
        );
    }
}

package com.training.api.stepdefinitions;

import Util.getObjectModel;
import constans.Constant;
import fact.NewOrder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import model.Inventory;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import questions.InventoryApproval;
import questions.InventoryModificated;
import tasks.CreateOrder;
import tasks.DeleteOrder;
import tasks.FindOrder;
import tasks.GetInventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class StoreStepDefinition implements En {

public StoreStepDefinition(){

    When("requests to get his inventory", () ->{
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetInventory.pets()
        );
        OnStage.theActorInTheSpotlight().remember("oldApproved",
                ((Inventory)getObjectModel.modelInventory(Inventory.class)).getApproved()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        InventoryApproval.existApprovedOrders(), equalTo("true")
                )
        );
    });
    Then("you will be informed of the current status of orders recived", () ->{
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The process was successful", response -> response.statusCode(200))
        );
    });

    Then("the number of approved must be greater than those who were initially consulted", () ->{
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetInventory.pets()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The process was successful", response -> response.statusCode(200)),
                seeThat(InventoryModificated.existApprovedOrders((int)
                        OnStage.theActorInTheSpotlight().recall(Constant.ID_OLD_ORDER),
                        ((Inventory)getObjectModel.modelInventory(Inventory.class)).getApproved()

                ), equalTo("true"))
        );
    });


    When("request to create a an order", (DataTable table) ->{
        OnStage.theActorInTheSpotlight().has(NewOrder.inTheStore(table.asMaps(String.class, String.class)));
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateOrder.inTheStore(table.asMaps(String.class, String.class))
        );
    });

    Then("the order is created correctly", () ->{
        SchemaLoader
                .load(new JSONObject(
                                new BufferedReader(
                                        new FileReader("./src/test/resources/schemas/find.json"))
                                        .lines().collect(Collectors.joining())))
               .validate(
                       new JSONObject(
                               (OnStage.theActorInTheSpotlight().asksFor(LastResponse.received())).asString()
                       )
               );
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The creation process was successful", response -> response.statusCode(200))
        );
    });

    When("request to find the order {word}", (String order) ->{
        OnStage.theActorInTheSpotlight().attemptsTo(
                FindOrder.inTheStore(order)
        );
    });

    Then("the system get to order", () ->{
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The process was successful", response -> response.statusCode(200))
        );
    });

    When("request to delete the order {word}", (String order) ->{
        OnStage.theActorInTheSpotlight().attemptsTo(
                DeleteOrder.inTheStore(order)
        );
    });

    Then("the system delete to order", () ->{
        OnStage.theActorInTheSpotlight().should(
                seeThatResponse("The process was successful", response -> response.statusCode(200))
        );

    });

}

}
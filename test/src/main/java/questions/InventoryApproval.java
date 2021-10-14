package questions;

import Util.getObjectModel;
import model.Inventory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InventoryApproval implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String mayor = "false";
        if(((Inventory) getObjectModel.modelInventory(Inventory.class)).getApproved()>0){
            mayor="true";
        }
        return mayor;
    }

    public static Question<String> existApprovedOrders() { return new InventoryApproval(); }

}

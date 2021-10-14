package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InventoryModificated implements Question<String> {

    private int old, now;
    public InventoryModificated(int old, int now){
        this.now = now;
        this.old = old;
    }
    @Override
    public String answeredBy(Actor actor) {
        String mayor = "false";
        if(now>old){
            mayor="true";
        }
        return mayor;
    }

    public static Question<String> existApprovedOrders(int old, int now) { return new InventoryModificated(old,now); }

}

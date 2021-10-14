package fact;

import com.google.gson.Gson;
import model.Order;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;

import java.util.List;
import java.util.Map;

public class NewOrder implements Fact {
    private String order;

    public NewOrder(List<Map<String, String>> order){
        this.order= new Gson().toJson(order);
    }

    public static NewOrder inTheStore(List<Map<String, String>> order){
        return new NewOrder(order);
    }

    @Override
    public void setup(Actor actor) {

    }

    public String toString(){
        return "The new order for store --> " + order;
    }
}

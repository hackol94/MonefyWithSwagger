package Util;

import com.google.gson.Gson;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class getObjectModel {

    public static Object modelInventory(Object obj){
       return new Gson().fromJson(new JSONObject(
                (OnStage.theActorInTheSpotlight().asksFor(LastResponse.received())).asString()
        ).toString(), (Type) obj);
    }

}

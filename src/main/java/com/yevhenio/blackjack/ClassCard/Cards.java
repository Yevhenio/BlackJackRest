package com.yevhenio.blackjack.ClassCard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by eugene on 05.10.15.
 */
@Path("/card")
public class Cards {
    public static int counter;
    public static ArrayList<Card> arr = new ArrayList();
    static CardService cs = new CardService();


    @GET
    @Path("/push")
    public Response pushCard() {
        String out = String.valueOf(counter);
        return Response.status(200).entity(out).build();
    }

    @GET
    @Path("/rand")
    @Produces("text/plain")
    public static String randCard() {
        Random r = new Random();
        Card first = (Card) cs.getCards().get(r.nextInt(52));
        Card second = (Card) cs.getCards().get(r.nextInt(52));
        arr.add(first);
        arr.add(second);
        String out = "";
        counter += first.getValue() + second.getValue();
        if (counter > 21) {
            for (int i = 0; i < arr.size(); i++) {
                out += "\n"+arr.get(i).toString() +"\n";
            }
            out +="\n" + " You got: " + counter + "\n" + " You loose!";
            counter = 0;
            arr.clear();
        } else if (counter == 21) {
            for (int i = 0; i < arr.size(); i++) {
                out += "\n"+arr.get(i).toString() +"\n";
            }
            out += "\n" + " You got: " + counter + "\n" + " BLACK JACK!";
            counter=0;
            arr.clear();
        } else {

            out = first.toString() + "\n" + second.toString() +
                    "\n" + " You got: " + counter + "\n";
        }
        return out;
    }
}


package com.yevhenio.blackjack.ClassCard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Random;

/**
 * Created by eugene on 05.10.15.
 */
@Path("/card")
public class Cards {
    public static int counter;

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
        String out;
        counter += first.getValue() + second.getValue();
        if (counter >= 21) {
            out = first.toString()  + "\n" + second.toString()+
                     "\n" + " You got: " + counter +"\n"+ " You loose!";
            counter = 0;
        } else {


            out = first.toString()  + "\n" + second.toString()+
                    "\n" + " You got: " + counter +"\n";
        }
        return out;
    }
}


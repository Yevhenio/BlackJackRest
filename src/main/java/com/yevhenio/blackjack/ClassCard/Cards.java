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
    public static int counterD;
    public static ArrayList<Card> arrD = new ArrayList();
    static CardService cs = new CardService();
    static Random r = new Random();
    static String out = "";
    static String outD = "";

    @GET
    @Path("/get")
    public static void getOne() {
        Card card = (Card) cs.getCards().get(r.nextInt(52));
        arr.add(card);
    }

    @GET
    @Path("/start")
    public static void start() {
        counter = 0;
        counterD = 0;
        arr.clear();
        arrD.clear();
        Card first = (Card) cs.getCards().get(r.nextInt(52));
        Card second = (Card) cs.getCards().get(r.nextInt(52));
        Card firstD = (Card) cs.getCards().get(r.nextInt(52));
        Card secondD = (Card) cs.getCards().get(r.nextInt(52));
        arr.add(first);
        arr.add(second);
        arrD.add(firstD);
        arrD.add(secondD);
    }

    @GET
    @Path("/rand")
    @Produces("text/plain")
    public static String randCard() {

        counter = 0;

        for (int i = 0; i < arr.size(); i++) {
            counter += arr.get(i).getValue();
        }
        if (counter > 21) {
            for (int i = 0; i < arr.size(); i++) {
                out += "\n" + arr.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + counter + "\n" ;
            counter = 0;
            counterD = 0;
            arr.clear();
            arrD.clear();
        } else if (counter == 21) {
            for (int i = 0; i < arr.size(); i++) {
                out += "\n" + arr.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + counter + "\n";
            counter = 0;
            counterD = 0;
            arr.clear();
            arrD.clear();
        } else {
            for (int i = 0; i < arr.size(); i++) {
                out += "\n" + arr.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + counter + "\n";
        }
        return out;
    }
    @GET
    @Path("/randD")
    @Produces("text/plain")
    public static String randD() {


        counterD = 0;
        for (int i = 0; i < arrD.size(); i++) {
            counterD += arrD.get(i).getValue();
        }
        if (counterD > 21) {
            for (int i = 0; i < arrD.size(); i++) {
                outD += "\n" + arrD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + counterD + "\n" ;
            counter = 0;
            counterD = 0;
            arr.clear();
            arrD.clear();
        } else if (counterD == 21) {
            for (int i = 0; i < arrD.size(); i++) {
                outD += "\n" + arrD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + counterD + "\n" ;
            counter = 0;
            counterD = 0;
            arr.clear();
            arrD.clear();
        } else {
            for (int i = 0; i < arrD.size(); i++) {
                outD += "\n" + arrD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + counterD + "\n";
        }
        return outD;
    }
    @GET
    @Path("/res")
    public void getResult(){
        if (counter > counterD){
            out +=" You win";
            outD +=" You loose";
        }else if ( counter == counterD){
            out +=" Draw";
            outD +=" Draw";
        }
    }

}


package com.yevhenio.blackjack.ClassCard;

import com.yevhenio.blackjack.ClassUser.TransLog;
import com.yevhenio.blackjack.ClassUser.User;
import com.yevhenio.blackjack.servicePack.UserDAO;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by eugene on 05.10.15.
 */
@Path("/card")
public class CardsRestService {
    //marked with "D" used to develop dealer`s functions
    public static int total;
    public static ArrayList<Card> hand = new ArrayList();
    public static int totalD;
    public static ArrayList<Card> handD = new ArrayList();
    static CardService cs = new CardService();
    static Random r = new Random();
    static String result = "";
    static String resultD = "";
    public int bet;

    //adding one more card to player`s hand
    @GET
    @Path("/get")
    public static void getOne() {
        Card card = (Card) cs.getCards().get(r.nextInt(52));
        hand.add(card);
    }

    //adding one card to dealer`s hand
    @GET
    @Path("/getD")
    public static void getOneDealer() {
        Card card = (Card) cs.getCards().get(r.nextInt(52));
        handD.add(card);
    }

    //starts the game, adding 2 cards for both of players
    @GET
    @Path("/start")
    public static void start() {
        total = 0;
        totalD = 0;
        hand.clear();
        handD.clear();
        result = "";
        resultD = "";
        Card first = (Card) cs.getCards().get(r.nextInt(52));
        Card second = (Card) cs.getCards().get(r.nextInt(52));
        if (first.equals(second)) {
            first = (Card) cs.getCards().get(r.nextInt(52));
            second = (Card) cs.getCards().get(r.nextInt(52));
        }
        Card firstD = (Card) cs.getCards().get(r.nextInt(52));
        Card secondD = (Card) cs.getCards().get(r.nextInt(52));
        if (firstD.equals(secondD)) {
            firstD = (Card) cs.getCards().get(r.nextInt(52));
            secondD = (Card) cs.getCards().get(r.nextInt(52));
        }
        hand.add(first);
        hand.add(second);
        handD.add(firstD);
        handD.add(secondD);
    }

    //shows the player`s cards
    @GET
    @Path("/show")
    @Produces("text/plain")
    public static String show() {
        String out = "";

        total = 0;

        for (int i = 0; i < hand.size(); i++) {
            total += hand.get(i).getValueAsInt();
        }
        if (total > 21) {
            for (int i = 0; i < hand.size(); i++) {
                out += "\n" + hand.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + total + "\n" + " You loose";
            total = 0;
            //totalD = 0;
            hand.clear();
            //handD.clear();
            result = "";
        } else if (total == 21) {
            for (int i = 0; i < hand.size(); i++) {
                out += "\n" + hand.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + total + "\n";
            total = 0;
            totalD = 0;
            hand.clear();
            handD.clear();
        } else {
            for (int i = 0; i < hand.size(); i++) {
                out += "\n" + hand.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + total + "\n" + result;
        }
        return out;
    }

    //shows the dealer`s cards
    @GET
    @Path("/showD")
    @Produces("text/plain")
    public static String showDealer() {

        String outD = "";
        totalD = 0;
        for (int i = 0; i < handD.size(); i++) {
            totalD += handD.get(i).getValueAsInt();
        }
        if (totalD > 21) {
            for (int i = 0; i < handD.size(); i++) {
                outD += "\n" + handD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + totalD + "\n" + " You loose";
            total = 0;
            totalD = 0;
            hand.clear();
            handD.clear();
            resultD = "";
        } else if (totalD == 21) {
            for (int i = 0; i < handD.size(); i++) {
                outD += "\n" + handD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + totalD + "\n";
            total = 0;
            totalD = 0;
            hand.clear();
            handD.clear();
        } else {
            for (int i = 0; i < handD.size(); i++) {
                outD += "\n" + handD.get(i).toString() + "\n";
            }
            outD += "\n" + " You got: " + totalD + "\n" + resultD;
        }
        return outD;
    }

    //adding result to "show" after "stand"
    @GET
    @Path("/stand")
    public void getResult() {
        if (total > totalD) {
            result += " You won";
            resultD += " You loose";
        } else if (total == totalD) {
            result += " Draw";
            resultD += " Draw";
        }

    }


}


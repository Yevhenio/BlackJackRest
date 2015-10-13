package com.yevhenio.blackjack.rest;

import com.yevhenio.blackjack.entity.Card;
import com.yevhenio.blackjack.services.CardService;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by eugene on 05.10.15.
 */
@Path("/game")
public class CardsRestService {
    //marked with "D" used to develop dealer`s functions
    static UserRestService us = new UserRestService();
    public static int total;
    public static ArrayList<Card> hand = new ArrayList();
    public static int totalD;
    public static ArrayList<Card> handD = new ArrayList();
    static CardService cs = new CardService();
    static Random r = new Random();
    static String result = "";
    static String resultD = "";


    @POST
    @Path("/login/{id}")
    public void login(@PathParam("id") int id) {
        us.getUser(id);
    }

    //adding one more card to player`s hand
    @POST
    @Path("/hit")
    public static void getOne() {
        Card card = (Card) cs.getCards().get(r.nextInt(52));
        hand.add(card);
    }

    //adding one card to dealer`s hand
    //for future using
    @GET
    @Path("/hitD")
    public static void getOneDealer() {
        Card card = (Card) cs.getCards().get(r.nextInt(52));
        handD.add(card);
    }

    //starts the game, adding 2 cards for both of players
    @POST
    @Path("/start/{value}")
    public static void start(@PathParam("value") int value) {
        us.setBet(value);
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
            hand.clear();
            showDealer();
            result = "";
        } else if (total == 21) {
            for (int i = 0; i < hand.size(); i++) {
                out += "\n" + hand.get(i).toString() + "\n";
            }
            out += "\n" + " You got: " + total + "\n" + "Black Jack";
            us.blackJack();
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
            outD += "\n" + " Dealer got: " + totalD + "\n" + " Dealer loose";
            total = 0;
            totalD = 0;
            hand.clear();
            handD.clear();
            resultD = "";
        } else if (totalD == 21) {
            for (int i = 0; i < handD.size(); i++) {
                outD += "\n" + handD.get(i).toString() + "\n";
            }
            outD += "\n" + " Dealer got: " + totalD + "\n";
            total = 0;
            totalD = 0;
            hand.clear();
            handD.clear();
        } else if (totalD < 17) {
            getOneDealer();
        } else {
            for (int i = 0; i < handD.size(); i++) {
                outD += "\n" + handD.get(i).toString() + "\n";
            }
            outD += "\n" + " Dealer got: " + totalD + "\n" + resultD;
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
            us.winTheBet();
        } else if (total == totalD) {
            result += " Push";
            resultD += " Push";
            us.pushTheBet();
        }

    }


}


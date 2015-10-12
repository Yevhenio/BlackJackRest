package com.yevhenio.blackjack.services;

import com.yevhenio.blackjack.entity.Card;

import java.util.ArrayList;

/**
 * Created by eugene on 08.10.15.
 */
//Service class for initializing the card deck
public class CardService {
    static ArrayList<Card> cards = new ArrayList<Card>();
    static {

        cards.add(new Card("2", 0));
        cards.add(new Card("2", 1));
        cards.add(new Card("2", 2));
        cards.add(new Card("2", 3));

        cards.add(new Card("3", 0));
        cards.add(new Card("3", 1));
        cards.add(new Card("3", 2));
        cards.add(new Card("3", 3));

        cards.add(new Card("4", 0));
        cards.add(new Card("4", 1));
        cards.add(new Card("4", 2));
        cards.add(new Card("4", 3));

        cards.add(new Card("5", 0));
        cards.add(new Card("5", 1));
        cards.add(new Card("5", 2));
        cards.add(new Card("5", 3));

        cards.add(new Card("6", 0));
        cards.add(new Card("6", 1));
        cards.add(new Card("6", 2));
        cards.add(new Card("6", 3));

        cards.add(new Card("7", 0));
        cards.add(new Card("7", 1));
        cards.add(new Card("7", 2));
        cards.add(new Card("7", 3));

        cards.add(new Card("8", 0));
        cards.add(new Card("8", 1));
        cards.add(new Card("8", 2));
        cards.add(new Card("8", 3));

        cards.add(new Card("9", 0));
        cards.add(new Card("9", 1));
        cards.add(new Card("9", 2));
        cards.add(new Card("9", 3));

        cards.add(new Card("10", 0));
        cards.add(new Card("10", 1));
        cards.add(new Card("10", 2));
        cards.add(new Card("10", 3));

        cards.add(new Card("Jack", 0));
        cards.add(new Card("Jack", 1));
        cards.add(new Card("Jack", 2));
        cards.add(new Card("Jack", 3));


        cards.add(new Card("Queen", 0));
        cards.add(new Card("Queen", 1));
        cards.add(new Card("Queen", 2));
        cards.add(new Card("Queen", 3));

        cards.add(new Card("King", 0));
        cards.add(new Card("King", 1));
        cards.add(new Card("King", 2));
        cards.add(new Card("King", 3));

        cards.add(new Card("Ace", 0));
        cards.add(new Card("Ace", 1));
        cards.add(new Card("Ace", 2));
        cards.add(new Card("Ace", 3));

    }
public ArrayList getCards(){


    return cards;
}

}

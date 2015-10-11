package com.yevhenio.blackjack.ClassCard;

/**
 * Created by eugene on 08.10.15.
 */
public class Card {
    public final static int SPADES = 0,       // Codes for the 4 suits.
            HEARTS = 1,
            DIAMONDS = 2,
            CLUBS = 3;

    private final int suit;   // The suit of this card, one of the constants
    //    SPADES, HEARTS, DIAMONDS, CLUBS.

    private final String value;  // The value of this card, from 1 to 11.

    public Card(String theValue, int theSuit) {
        // Construct a card with the specified value and suit.
        // Value must be between 1 and 13.  Suit must be between
        // 0 and 3.  If the parameters are outside these ranges,
        // the constructed card object will be invalid.
        value = theValue;
        suit = theSuit;
    }

    public int getSuit() {
        // Return the int that codes for this card's suit.
        return suit;
    }

    public String getValue() {
        // Return the int that codes for this card's value.
        return value;
    }

    public String getSuitAsString() {
        // Return a String representing the card's suit.
        // (If the card's suit is invalid, "??" is returned.)
        switch (suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "??";
        }
    }

    public int getValueAsInt() {
        // Return a String representing the card's value.
        // If the card's value is invalid, "??" is returned.
        switch (value) {
            case "Ace":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "Jack":
                return 10;
            case "Queen":
                return 10;
            case "King":
                return 10;
            default:
                return 0;
        }
    }

    public String toString() {

        //Returning a representation of card
        return getValue() + " of " + getSuitAsString();
    }


}


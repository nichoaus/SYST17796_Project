/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author CYBER140
 */
public class Card {
    private Suit suit;
    private int value;
    private String rank;

    public Card(Suit suit, int value, String rank) {
        this.suit = suit;
        this.value = value;
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit.getName();
    }
}
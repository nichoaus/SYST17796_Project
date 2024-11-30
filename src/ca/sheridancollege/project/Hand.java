/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author CYBER140
 */

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    public boolean isBust() {
        return getScore() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getScore() == 21;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

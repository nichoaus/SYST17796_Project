/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author CYBER140
 */

public class Game {
    private Deck deck;
    private Player player;
    private Dealer dealer;

    public Game() {
        deck = new Deck();
        deck.shuffle();
        dealer = new Dealer();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);

        System.out.println("Welcome to Blackjack, " + player.getName() + "!");
        initialDeal();

        while (true) {
            System.out.println("Your hand: " + player.getHand());
            System.out.println("Your score: " + player.getHand().getScore());
            if (player.getHand().isBust()) {
                System.out.println("You busted! Dealer wins.");
                break;
            }
            if (player.getHand().isBlackjack()) {
                System.out.println("Blackjack! You win!");
                break;
            }

            System.out.println("1. Hit");
            System.out.println("2. Stand");
            int choice = scanner.nextInt();
            if (choice == 1) {
                player.getHand().addCard(deck.drawCard());
            } else if (choice == 2) {
                playDealerTurn();
                determineWinner();
                break;
            }
        }
        scanner.close();
    }

    private void initialDeal() {
        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());

        System.out.println("Dealer's face-up card: " + dealer.getHand().toString().split(",")[0]);
    }

    private void playDealerTurn() {
        System.out.println("Dealer's hand: " + dealer.getHand());
        while (dealer.getHand().getScore() < 17) {
            dealer.getHand().addCard(deck.drawCard());
            System.out.println("Dealer hits. Dealer's hand: " + dealer.getHand());
        }
        if (dealer.getHand().isBust()) {
            System.out.println("Dealer busted! You win!");
        }
    }

    private void determineWinner() {
        int playerScore = player.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();

        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
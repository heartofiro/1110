package comp1110.ass2;

import java.sql.SQLOutput;

public class Player {
    // Store the player's current turn state (or if they're waiting for their turn)
    public enum State {
        ROTATION, MOVEMENT, PLACEMENT, IDLE
    }

    // The colour of the player
    public Colour playerColour;

    // The state of the player
    private State playerState;

    // How much money the player currently has
    public int playerMoney;

    // How many rugs the player has left to place
    public int rugsLeft;

    // Check if the player is out or not
    public boolean inGame;

    /*
     * Constructor for the Player class. Breaks down the playerString and
     * assigns values.
     */
    public Player(String playerString)

    // Obtain the player's colour
    {
        if (playerString.length() != 7) {
            System.out.println("Invalid playerString! playerString must be 7 characters. ");// ensure the playerString
                                                                                            // is valid with correct
                                                                                            // length and first
                                                                                            // character.
        } else if (playerString.charAt(0) != 'P') {
            System.out.println("Invalid playerString! playerString must start with 'P'.");
        } else {
            char colorChar = playerString.charAt(1); // Get the second char of PlayerString
            switch (colorChar) {
                case 'c':
                    this.playerColour = Colour.CYAN; // If char is "c" , color of player is cyan.
                    break;
                case 'y':
                    this.playerColour = Colour.YELLOW; // If char is "y" , color of player is yellow.
                    break;
                case 'r':
                    this.playerColour = Colour.RED; // If char is "r" , color of player is red.
                    break;
                case 'p':
                    this.playerColour = Colour.PURPLE;// If char is "p" , color of player is purple.
                    break;
                default:
                    System.out.println("Invalid player color!"); // If char does not match any color then output
                                                                 // Invalid.
                    break;
            }

            // Obtain the player's money
            String moneyString = playerString.substring(2, 5);// Get string containing 3rd to 5th char which
                                                              // representing number of play's money
            this.playerMoney = Integer.parseInt(moneyString); // Transfer moneyString to int

            // Obtain the player's rugs left
            String rugsString = playerString.substring(5, 7); // Get string containing 6th to 7th char which
                                                              // representing number of play's rug
            this.rugsLeft = Integer.parseInt(rugsString); // Transfer rugsString to int

            // Obtain whether the player is in or out
            char statusChar = playerString.charAt(7); // Get 7th char in playerString
            if (statusChar == 'i') { // If satusChar is 'i', representing player is in game
                this.inGame = true;
            } else if (statusChar == 'o') { // If satusChar is 'i', representing player is out
                this.inGame = false;
            } else { // If satusChar is not 'i' or 'o', representing player's status is not clear
                System.out.println("Player's status is not sure!");
            }
        }
    }

    /*
     * Given a receiver and an amount, deduct money from the current player
     * and transfer it to the receiver.
     */
    public void transferMoney(Player receiver, int amount) // If player'money more than they need to pay the receiver,
                                                           // the amount of money would transfer to receiver.
    {
        if (this.playerMoney >= amount) {
            this.playerMoney -= amount;
            receiver.playerMoney += amount;
        } else { // If a player don't have enough money to pay, he or she will out and pay as
                 // much as he or she can to the receiver.
            receiver.playerMoney += this.playerMoney;
            this.playerMoney = 0;
            this.inGame = false;
        }
    }
}

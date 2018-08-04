/**
 * The Monty Hall problem proof
 * by Simon Fox
 */
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Boolean> doors = new ArrayList<Boolean>();
        doors.add(true); // It's a CAR
        doors.add(false); // It's a goat
        doors.add(false); // And it's a goat too :)

        // We use arrayList instead of array because we can shuffle arrayList easily :)
        // ArrayList:                       [true, false, false]
        // Element's index (door's number):   0      1      2

        Random random = new Random();
        Scanner userInput = new Scanner(System.in);
        int userRepeats = 0;
        int swap = 1;
        double wins = 0;
        double lose = 0;
        int userChoice = 0;
        int newUserChoice = 0;
        int openedDoor = 0;
        System.out.print("How much repeats would you like to do? ");
        userRepeats = userInput.nextInt();
        System.out.println("Do you want (1)Switch or (2)Stick: ");
        swap = userInput.nextInt();
        for (int i = 0; i < userRepeats; i++) {
            Collections.shuffle(doors);
            System.out.println(doors);
            userChoice = random.nextInt(3);
            System.out.println("User choice is: "+userChoice);
            if ((userChoice != 0)&& !doors.get(0)) {
                openedDoor = 0;
                System.out.println("Opened door is: "+openedDoor);
                switch (swap) {
                    case 1:
                    if (userChoice == 1) {
                        newUserChoice = 2;
                        System.out.println("New user choice is: " + newUserChoice);

                    } else if (userChoice == 2) {
                        newUserChoice = 1;
                        System.out.println("New user choice is: " + newUserChoice);
                    }
                    break;
                    case 2:
                        newUserChoice = userChoice;
                    break;

                } //end of switch
            } //end of if
            else if ((userChoice != 1)&& !doors.get(1)) {
                openedDoor = 1;
                System.out.println("Opened door is: "+openedDoor);
                switch (swap) {
                    case 1:
                    if (userChoice == 0) {
                        newUserChoice = 2;
                        System.out.println("New user choice is: " + newUserChoice);
                    } else if (userChoice == 2) {
                        newUserChoice = 0;
                        System.out.println("New user choice is: " + newUserChoice);
                    }
                    break;
                    case 2:
                        newUserChoice = userChoice;
                    break;

                }  // end of switch
            } // end of if
            else if ((userChoice != 2)&& !doors.get(2)) {
                openedDoor = 2;
                System.out.println("Opened door is: "+openedDoor);
                switch (swap) {
                    case 1:
                    if (userChoice == 1) {
                        newUserChoice = 0;
                        System.out.println("New user choice is: " + newUserChoice);
                    } else if (userChoice == 0) {
                        newUserChoice = 1;
                        System.out.println("New user choice is: " + newUserChoice);
                    }
                    break;
                    case 2:
                        newUserChoice = userChoice;
                    break;

                }   //end of switch
            } //end of if
            if (doors.get(newUserChoice)) {
                wins = wins + 1;
            }
            else {
                lose = lose + 1;
            }
            System.out.println("----------------------");
        }
        System.out.println("");
        System.out.println("Wins: "+Math.round(wins/userRepeats*100)+"%");
        System.out.println("Loses: "+Math.round(lose/userRepeats*100)+"%");


    }
}

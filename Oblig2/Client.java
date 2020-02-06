package Oblig2;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Matilde Volle Fiborg
 * @version 1.0
 *
 * The client program for an application 
 */

public class Client {
    MemberArchive MA = new MemberArchive();

    // Constants representing the different menu choices
    private final int NEW_MEMBER = 1;
    private final int FIND_POINTS = 2;
    private final int REGISTER_POINTS = 3;
    private final int CHECK_MEMBERS = 4;
    private final int EXIT = 5;

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     *                 If 0 is returned, the user has entered a wrong value
     */
    private int showMenu() {
        int menuChoice = 0;

        System.out.println("\n***** Members Archive *****\n");
        System.out.println("1. New Member");
        System.out.println("2. Find Points");
        System.out.println("3. Register Points");
        System.out.println("4. Check Member");
        System.out.println("5. Quit");
        System.out.println("\nPlease select from the menu.\n");
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            menuChoice = sc.nextInt();
            if (menuChoice > 6 || menuChoice < 1) {
                menuChoice = 0;
            }
        }
        else {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public void start() {
        boolean finished = false;
        Scanner in = new Scanner(System.in);

        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case NEW_MEMBER:
                    System.out.println("Firstname:");
                    String firstnameNew = in.next() + in.nextLine();
                    System.out.println("Surename:");
                    String surenameNew = in.next() + in.nextLine();
                    System.out.println("ePost:");
                    String ePostNew = in.next() + in.nextLine();
                    System.out.println("Password:");
                    String passwordNew = in.next() + in.nextLine();
                    System.out.println("Day Month Year:");
                    int dayNew = in.nextInt();
                    int monthNew = in.nextInt();
                    int yearNew = in.nextInt();
                    System.out.println("Your member number is " + MA.newMember(new Personals(firstnameNew, surenameNew, ePostNew, passwordNew),
                            LocalDate.of(yearNew, monthNew, dayNew)));
                    break;

                case FIND_POINTS:
                    System.out.println("Member number:");
                    int mnrFP = in.nextInt();
                    System.out.println("Password:");
                    String passwordFP = in.next() + in.nextLine();
                    System.out.println("You have " + MA.findPoints(mnrFP, passwordFP) + " points");
                    break;

                case REGISTER_POINTS:
                    System.out.println("Member number:");
                    int mnrR = in.nextInt();
                    System.out.println("Points:");
                    int pointsR = in.nextInt();
                    if (MA.registerPoints(mnrR, pointsR)) {
                        System.out.println("Points registered");
                    }
                    else {
                        System.out.println("");
                    }
                    break;

                case CHECK_MEMBERS:
                    System.out.println("Day Month Year:");
                    int dayNow = in.nextInt();
                    int monthNow = in.nextInt();
                    int yearNow = in.nextInt();
                    MA.checkMembers(LocalDate.of(yearNow, monthNow, dayNow));
                    break;

                case EXIT:
                    System.out.println("Thank you for using this app!\n");
                    finished = true;
                    break;

                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Client C = new Client();
        C.start();
    }
}

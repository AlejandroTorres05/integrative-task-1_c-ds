package ui;

import model.Controller;
import model.EspecialCuality;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    //Colors System
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLUE = "\u001B[34m";

    public static Scanner sc = new Scanner(System.in);

    public static Controller controller = new Controller();

    public static void main(String[] args) throws IOException {
        int option = 0;
        System.out.println(BOLD + BLUE + "WELCOME TO THE AIRPORT SYSTEM");
        while (option != 6) {
            System.out.println(BOLD + UNDERLINE + "PLEASE SELECT AN OPTION:" + RESET +
                    BOLD + BLUE + "\n[1]" + RESET + " Add a common passenger" +
                    BOLD + BLUE + "\n[2]" + RESET + " Add a premium passenger" +
                    BOLD + BLUE + "\n[3]" + RESET + " Record boarding" +
                    BOLD + BLUE + "\n[4]" + RESET + " See boarding order" +
                    BOLD + BLUE + "\n[5]" + RESET + " See order of departure" +
                    BOLD + BLUE + "\n[6]" + RESET + " Exit");

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    addPremiumPassenger();
                    break;
                case 3:
                    registerPassenger();
                    break;
                case 4:
                    viewQueue();
                    break;
            }
        }
    }


    private static void addPassenger() throws IOException {
        System.out.println("Please enter the data");
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("last name");
        String lastName = sc.nextLine();
        System.out.println("Id");
        String id = sc.nextLine();
        System.out.println("arrivalTime");
        int arrivalTime = sc.nextInt();
        sc.nextLine();
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime;
        controller.addPassenger(input);
    }

    private static void addPremiumPassenger() throws IOException {
        System.out.println("Please enter the data");
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("last name");
        String lastName = sc.nextLine();
        System.out.println("Id");
        String id = sc.nextLine();
        System.out.println("arrivalTime");
        int arrivalTime = sc.nextInt();
        sc.nextLine();
        System.out.println("acumMiles");
        int acumMiles = sc.nextInt();
        System.out.println("cuality");
        int cualOp = sc.nextInt();
        EspecialCuality cuality = null;
        switch (cualOp) {
            case 1:
                cuality = EspecialCuality.THIRDAGE;
                break;
            case 2:
                cuality = EspecialCuality.PREGNANT;
                break;
            case 3:
                cuality = EspecialCuality.CHILD;
                break;
            case 4:
                cuality = EspecialCuality.SICK;
                break;
        }
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime + "++" + acumMiles;
        controller.addPremiumPassenger(input, cuality);
    }

    public static void registerPassenger() throws IOException {
        System.out.println("Please input passenger id");
        String key = sc.nextLine();
        System.out.println(controller.searchInHash(key));
    }

    public static void viewQueue() {
        System.out.println(controller.viewPriorityQueue());
    }
}
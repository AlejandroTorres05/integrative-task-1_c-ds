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
    public static int atTheQueue = 0;

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
                    atTheQueue++;
                    break;
                case 2:
                    addPremiumPassenger();
                    atTheQueue++;
                    break;
                case 3:
                    registerPassenger();
                    break;
                case 4:
                    if(atTheQueue < 36){
                        System.out.println("There are not enough passengers yet");
                    }else{
                        boardingOrder();
                    }
                    break;
                case 5:
                    if(atTheQueue < 36){
                        System.out.println("There are not enough passengers yet");
                    }else{
                        getOutOrder();
                    }
                    break;
            }
        }
    }


    private static void addPassenger() throws IOException {
        System.out.println(BOLD + UNDERLINE + BLUE + "COMMON PASSENGER" + RESET);
        System.out.println("Please enter the passenger's name");
        String name = sc.nextLine();
        System.out.println("please enter the passenger's last name");
        String lastName = sc.nextLine();
        System.out.println("please enter the passenger's ID");
        String id = sc.nextLine();
        System.out.println("Please enter the passenger's arrival time in minutes.");
        int arrivalTime = sc.nextInt();
        sc.nextLine();
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime;
        controller.addPassenger(input);
    }

    private static void addPremiumPassenger() throws IOException {
        System.out.println(BOLD + UNDERLINE + BLUE + "PREMIUM PASSENGER" + RESET);
        System.out.println("Please enter the passenger's name");
        String name = sc.nextLine();
        System.out.println("please enter the passenger's last name");
        String lastName = sc.nextLine();
        System.out.println("please enter the passenger's ID");
        String id = sc.nextLine();
        System.out.println("Please enter the passenger's arrival time in minutes.");
        int arrivalTime = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter the passenger's mileage accruals");
        int acumMiles = sc.nextInt();
        System.out.println("Please enter any special quality");
        System.out.println("\n[1]" + " Third Age" +
                "\n[2]" + " Pregnant" +
                "\n[3]" + " Child" +
                "\n[4]" + " Sick" +
                "\n[5]" + " None");
        int cualOp = sc.nextInt();
        EspecialCuality cuality;
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
            case 5:
                cuality = EspecialCuality.NONE;
                break;
            default:
                System.out.println("None is selected by default");
                cuality = EspecialCuality.NONE;
                break;
        }
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime + "++" + acumMiles;
        controller.addPremiumPassenger(input, cuality);
    }

    public static void registerPassenger() throws IOException {
        System.out.println("Please enter the passenger's id");
        String key = sc.nextLine();
        System.out.println(controller.searchInHash(key));
    }


    public static void boardingOrder(){
        System.out.println(controller.getOnOrder());
    }

    public static void getOutOrder(){
        System.out.println(controller.getOutOrder());
    }
}
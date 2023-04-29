package ui;

import model.Controller;
import model.EspecialCuality;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Controller controller = new Controller();

    public static void main(String[] args) throws IOException {
        int option = 0;
        while (option != 4) {
            System.out.println("Please select an option");
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
        System.out.println("ticket");
        String ticket = sc.nextLine();
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime + "++" + ticket;
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
        System.out.println("ticket");
        String ticket = sc.nextLine();
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
        String input = name + "++" + lastName + "++" + id + "++" + arrivalTime + "++" + ticket + "++" + acumMiles;
        controller.addPremiumPassenger(input, cuality);
    }

    public static void registerPassenger() throws IOException {
        System.out.println("Please input passenger id");
        String key = sc.nextLine();
        System.out.println(controller.searchInHash(key));
    }

    public static void viewQueue(){
        System.out.println(controller.viewPriorityQueue());
    }
}
package model;

import dataStructures.Stack;

import java.io.IOException;
import java.util.Arrays;


public class Controller {

    public static PassengerList passengerList = new PassengerList();

    public static Stack stack = new Stack();


    public void addPassenger(String input) throws IOException {
        try {
            passengerList.load();
        } catch (NullPointerException ex) {

        }
        String[] data = input.split("\\+\\+");
        System.out.println(Arrays.toString(data));
        passengerList.getPassengers().add(
                new Passenger(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4])
        );
        passengerList.save();
    }

    public void addPremiumPassenger(String input, EspecialCuality cuality) throws IOException {
        try {
            passengerList.load();
        } catch (NullPointerException ex) {

        }
        String[] data = input.split("\\+\\+");
        System.out.println(Arrays.toString(data));
        int lvlPriority = priorityCal(cuality);
        passengerList.getPassengers().add(
                new PremiumPassenger(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), lvlPriority, cuality)
        );
        passengerList.save();
    }

    public int priorityCal(EspecialCuality cuality) {
        int priority = 0;
        if (cuality == EspecialCuality.THIRDAGE) {
            priority = 40;
        } else if (cuality == EspecialCuality.SICK) {
            priority = 20;
        } else if (cuality == EspecialCuality.PREGNANT) {
            priority = 30;
        } else if (cuality == EspecialCuality.CHILD) {
            priority = 10;
        } else {
            priority = 0;
        }
        return priority;
    }
}
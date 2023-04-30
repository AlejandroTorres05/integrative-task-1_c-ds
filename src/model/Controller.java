package model;

import dataStructures.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Controller {

    public static PassengerList passengerList = new PassengerList();

    public static Stack stack = new Stack();

    public static HashTable hashTable = passengerList.getHashtable();

    public static PriorityQueue priorityQueue = new PriorityQueue<>(36);

    /**
     * This method adds a common passenger to database txt, with all
     * passenger's attributes. Receive a String with all characteristics
     * and divide this attributes in an array for create the passenger object
     *
     * @param input
     * @Pre: The input info is complete
     * @Post: The passenger was created and added to txt
     */
    public void addPassenger(String input) throws IOException {
        try {
            passengerList.load();
        } catch (NullPointerException ex) {

        }
        String[] data = input.split("\\+\\+");
        System.out.println(Arrays.toString(data));
        passengerList.getPassengers().add(
                new Passenger(data[0], data[1], data[2], Integer.parseInt(data[3]))
        );
        passengerList.save();
    }

    /**
     * This method adds a premium passenger to database txt, with all
     * passenger's attributes. Receive a String with all characteristics
     * and divide this attributes in an array for create the passenger object
     *
     * @param input
     * @param cuality
     * @Pre: The input info is complete
     * @Post: The premium passenger was created and added to txt
     */
    public void addPremiumPassenger(String input, EspecialCuality cuality) throws IOException {
        try {
            passengerList.load();
        } catch (NullPointerException ex) {

        }
        String[] data = input.split("\\+\\+");
        System.out.println(Arrays.toString(data));
        passengerList.getPassengers().add(
                new PremiumPassenger(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), cuality)
        );
        passengerList.save();
    }

    /**
     * This method searches a passenger using his ID how an
     * input parameter, first load the information from txt to HashTable
     * after search the passenger and return his key
     *
     * @param key
     * @Pre: The key is in the database
     * @Post: the passenger was found and his key was returned to him
     */
    public String searchInHash(String key) throws IOException {
        String msg = "The passenger is not registered";
        passengerList.load();
        Passenger passenger = (Passenger) hashTable.chainedHashSearch(key).getValue();
        if (passenger.getId().equals(key)) {
            priorityQueue.insert(new Pair(passenger.getPriority(), passenger));
            msg = "Passenger successfully registered";
            Pair[] arr = priorityQueue.getArray();
            System.out.println(arr[0].getKey());
            return msg;
        }
        return msg;
    }


    /**
     * this method shows the order of entry to the airplane
     *
     * @Pre: That someone's entry has been registered
     * @Post: Show the order of entry
     */
    public String viewPriorityQueue() {
        String msg = "ORDEN DE INGRESO: " + "\n";
        Pair[] arr = priorityQueue.getArray();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] != null) {
                Passenger passenger = (Passenger) arr[i].getValue();
                msg += passenger.getName() + " " + passenger.getLastName() + " " + passenger.getId() + "\n";
            }
        }
        return msg;
    }
}
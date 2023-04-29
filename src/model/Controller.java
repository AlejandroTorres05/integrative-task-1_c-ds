package model;

import dataStructures.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Controller {

    public static PassengerList passengerList = new PassengerList();

    public static Stack stack = new Stack();

    public static HashTable hashTable = passengerList.getHashtable();

    public static PriorityQueue priorityQueue = new PriorityQueue<>(32);


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

    public void addPremiumPassenger(String input, EspecialCuality cuality) throws IOException {
        try {
            passengerList.load();
        } catch (NullPointerException ex) {

        }
        String[] data = input.split("\\+\\+");
        System.out.println(Arrays.toString(data));
        passengerList.getPassengers().add(
                new PremiumPassenger(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), cuality )
        );
        passengerList.save();
    }
    public String searchInHash(String key) throws IOException {
        String msg = "The passenger is not registered";
        passengerList.load();
        if (hashTable.chainedHashSearch(key) == true) {
            priorityQueue.insert(new Pair(key, hashTable.getValue(key)));
            msg = "Passenger successfully registered";
            Pair[] arr = priorityQueue.getArray();
            System.out.println(arr[0].getKey());
            return msg;
        }
        return msg;
    }

    public String viewPriorityQueue(){
        String msg = "";
        Pair[] arr = priorityQueue.getArray();
        for (int i = 0; i <= arr.length-1; i ++){
            if (arr[i] != null){
                msg += arr[i].getKey();
            }
        }
        return msg;
    }
}
package model;

import dataStructures.Stack;

import java.util.EmptyStackException;
/**
 * This class will simulate the plane
 * to the system be able to get
 * the get out order of the fly
 * */
public class Plane {

    private Stack<Passenger> group1;
    private Stack<Passenger> group2;
    private int status;

    public Plane() {
        this.group1 = new Stack<>();
        this.group2 = new Stack<>();
        this.status = 0;
    }

    /**
     * This method can add a passenger
     * to the plane. For that, this method
     * uses the status attribute that indicates
     * the Stack thad the new passenger must be
     * added
     * @param passenger a Passenger is the new
     *                  passenger to be added to
     *                  the plane
     * @Pre there must be a plane instanced
     * @Post the new passenger will be
     *                  added to the plane
     * */
    public void addPassenger (Passenger passenger){
        switch (this.status){
            case 0:
                group1.push(passenger);
                this.status = 1;
                break;
            case 1:
                group2.push(passenger);
                this.status = 0;
                break;
        }
    }

    /**
     * This method pop all
     * passengers to the Stacks in the
     * order that the passengers must
     * be popped
     * @Pre there must be passengers in the
     * plane
     * @Post the plane will be empty at the end
     * */
    public String exitPassengers (){
        String message = "";

        while (!this.group1.isEmpty() || !this.group2.isEmpty()){
            message += takeOutPassenger();
        }
        return message;
    }

    /**
     * This method takes out
     * two passengers by a call. One of the first
     * group and one of the second group
     * */
    private String takeOutPassenger (){
        String message = "";
        try {
            message += this.group1.pop().getName() + "\n";

        } catch (EmptyStackException ex){

        }
        try {
            message += this.group2.pop().getName() + "\n";
        }catch (EmptyStackException ex){

        }
        return message;
    }

    public boolean isEmpty (){
        if (this.group1.isEmpty() && this.group2.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}

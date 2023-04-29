package model;

public class Passenger {
    private String name;
    private String lastName;
    private String id;
    private int arrivalTime;
    private int priority;

    public Passenger(String name, String lastName, String id, int arrivalTime) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.priority = calculatePriority(arrivalTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int calculatePriority(int arrivalTime){
        return arrivalTime*2;
    }
}

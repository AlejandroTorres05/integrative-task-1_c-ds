package model;

public class PremiumPassenger extends Passenger {
    private int lvlPriority;

    private int acumMiles;

    private EspecialCuality cuality;

    public PremiumPassenger(String name, String lastName, String id, int arrivalTime, String tikeckNum, int lvlPriority, int acumMiles, EspecialCuality cuality) {
        super(name, lastName, id, arrivalTime, tikeckNum);
        this.lvlPriority = lvlPriority;
        this.acumMiles = acumMiles;
        this.cuality = cuality;
    }

    public int getLvlPriority() {
        return lvlPriority;
    }

    public void setLvlPriority(int lvlPriority) {
        this.lvlPriority = lvlPriority;
    }

    public int getAcumMiles() {
        return acumMiles;
    }

    public void setAcumMiles(int acumMiles) {
        this.acumMiles = acumMiles;
    }

    public EspecialCuality getCuality() {
        return cuality;
    }

    public void setCuality(EspecialCuality cuality) {
        this.cuality = cuality;
    }
}

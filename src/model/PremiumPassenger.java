package model;

public class PremiumPassenger extends Passenger {
    private int acumMiles;

    private EspecialCuality cuality;

    private int pPriority;

    public PremiumPassenger(String name, String lastName, String id, int arrivalTime, int acumMiles, EspecialCuality cuality) {
        super(name, lastName, id, arrivalTime);
        this.acumMiles = acumMiles;
        this.cuality = cuality;
        this.pPriority = 200 + calculatePriority(cuality);
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

    /**
     * This method calculates the priority of premium passenger
     * based in his cuality and his miles, adding quality priority to mileage accruals
     * @param cuality
     * @Pre: The cuality is correct
     * @Post: return the priority
     * */
    public int calculatePriority(EspecialCuality cuality) {
        int cualityPriority = cualityPriority(cuality);
        return cualityPriority + acumMiles;
    }

    /**
     * This method calculates the priority of premium passenger
     * based in his cuality.
     * @param cuality
     * @Pre: The cuality is correct
     * @Post: return the cuality priority
     * */
    public int cualityPriority(EspecialCuality cuality) {
        if (cuality == EspecialCuality.THIRDAGE) {
            return 40;
        } else if (cuality == EspecialCuality.SICK) {
            return 20;
        } else if (cuality == EspecialCuality.PREGNANT) {
            return 30;
        } else if (cuality == EspecialCuality.CHILD) {
            return 10;
        } else {
            return 0;
        }
    }
}

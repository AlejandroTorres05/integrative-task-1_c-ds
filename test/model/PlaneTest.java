package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PlaneTest {

    private static Plane plane;

    /**
     * This stage instances a Plane
     * and add to it fifteen passenger
     * */
    public void setupStage1(){
        plane = new Plane();
        plane.addPassenger(new Passenger("alejandro", "torres", "111",1));
        plane.addPassenger(new Passenger("alex", "castillo", "222",2));
        plane.addPassenger(new Passenger("kevin", "flores", "333",3));
        plane.addPassenger(new Passenger("daniel", "suarez", "444",4));
        plane.addPassenger(new Passenger("daniela", "acosta", "555",5));
        plane.addPassenger(new Passenger("ashli", "perez", "661",6));
        plane.addPassenger(new Passenger("daniela", "montes", "777",7));
        plane.addPassenger(new Passenger("lucia", "petro", "888",8));
        plane.addPassenger(new Passenger("isabela", "arias", "999",9));
        plane.addPassenger(new Passenger("sebastian", "soto", "119",10));
        plane.addPassenger(new Passenger("laura", "villa", "229",11));
        plane.addPassenger(new Passenger("juan", "ruiz", "339",12));
        plane.addPassenger(new Passenger("david", "aguilar", "449",13));
        plane.addPassenger(new Passenger("pablo", "lopez", "559",14));
        plane.addPassenger(new Passenger("mariana", "daniels", "669",15));
    }

    @Test
    public void addPassengerMethodAddThePassengersCorrectlyTest(){
        setupStage1();
        String[] order = {"mariana", "pablo", "david", "juan", "laura", "sebastian", "isabela", "lucia", "daniela", "ashli", "daniela", "daniel", "kevin", "alex", "alejandro"};
        int index = 0;
        while (!plane.isEmpty()){
            assertEquals(order[index], );
        }
    }
}

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

    /**
     * This class just needs a test to
     * check all of its functionalities
     * because all of its methods are
     * very related between themselves. In
     * addition to that, is important to
     * highlight that to check some method
     * we must use the rest of them
     * */
    @Test
    public void planeClassFoundTest(){
        setupStage1();
        String output = "mariana daniels 669" + "\n"
                    + "pablo lopez 559" + "\n"
                    + "david aguilar 449" + "\n"
                    + "juan ruiz 339" + "\n"
                    + "laura villa 229" + "\n"
                    + "sebastian soto 119" + "\n"
                    + "isabela arias 999" + "\n"
                    + "lucia petro 888" + "\n"
                    + "daniela montes 777" + "\n"
                    + "ashli perez 661" + "\n"
                    + "daniela acosta 555" + "\n"
                    + "daniel suarez 444" + "\n"
                    + "kevin flores 333" + "\n"
                    + "alex castillo 222" + "\n"
                    + "alejandro torres 111" + "\n";

        String result = plane.exitPassengers();

        assertEquals(output, result);
    }
}

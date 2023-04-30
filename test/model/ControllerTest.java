package model;
import dataStructures.HashNode;
import dataStructures.HashTable;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    Controller controller;

    private HashTable<Integer, String> hashTable;

    public void setUp1() {
        controller = new Controller();
    }
    @Test
    public void addPassengerAndSearchInHashTest() throws IOException {
        // Arrange
        setUp1();

        // Act
        String input = "alejandro" + "++" + "amu" + "++" + "1109661527" + "++" + 10 + "++" + 5;
        controller.addPassenger(input);
        // Assert
        assertEquals("Passenger successfully registered", controller.searchInHash("1109661527"));
    }

    @Test
    public void searchInHashTest() throws IOException {
        // Arrange
        setUp1();
        // Act
        String msg = controller.searchInHash("1189");
        // Assert
        assertEquals("Passenger successfully registered", msg);
    }

    @Test
    public void searchInHashTest2() throws IOException {
        // Arrange
        setUp1();
        // Act
        String msg = controller.searchInHash("000");
        // Assert
        assertEquals("The passenger is not registered", msg);
    }
}

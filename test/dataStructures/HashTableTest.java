package dataStructures;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HashTableTest {
    private HashTable<Integer, String> hashTable;

    public void setUp1() {
        hashTable = new HashTable<>();
    }
    @Test
    public void getValueTest() {
        // Arrange
        setUp1();

        // Act
        hashTable.chainedHashInsert(1234567, "Alejandro Amu");

        // Assert
        String name = hashTable.getValue(1234567);
        assertEquals("Alejandro Amu", name);
    }

    @Test
    public void chainedHashInsertTest() {
        // Arrange
        setUp1();

        // Act
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Assert
        String name = hashTable.getValue(9851425);
        assertEquals("Jose Jose", name);
    }

    @Test
    public void getSizeTest() {
        // Arrange
        setUp1();

        // Act
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Assert
        int size = hashTable.getSize();
        assertEquals(3, size);
    }

    @Test
    public void chainedHashDeleteTest1() {
        // Arrange
        setUp1();
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");
        hashTable.chainedHashInsert(4812563, "Josep Taylor");

        // Act
        hashTable.chainedHashDelete(6325415);

        // Assert
        String name = hashTable.getValue(6325415);
        assertNull(name);
    }

    @Test
    public void chainedHashDeleteTest2() {
        // Arrange
        setUp1();
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Act
        hashTable.chainedHashDelete(9851425);

        // Assert
        String name = hashTable.getValue(9851425);
        assertNull(name);
    }

    @Test
    public void chainedHashDeleteTest3() {
        // Arrange
        setUp1();
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Act
        hashTable.chainedHashDelete(4526814);

        // Assert
        String name = hashTable.getValue(4526814);
        assertNull(name);
    }

    @Test
    public void chainedHashSearchTest1() {
        // Arrange
        setUp1();
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Act
        HashNode data = hashTable.chainedHashSearch(4526814);

        // Assert
        assertEquals(4526814, data.getKey());
    }

    @Test
    public void chainedHashSearchTest2() {
        // Arrange
        setUp1();
        hashTable.chainedHashInsert(6325415, "Michael Jackson");
        hashTable.chainedHashInsert(9851425, "Jose Jose");
        hashTable.chainedHashInsert(4526814, "Britney Spears");

        // Act
        HashNode data = hashTable.chainedHashSearch(111111);

        // Assert
        assertNull(data);
    }
}

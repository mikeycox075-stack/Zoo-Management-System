
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AnimalTest {

    @Test
    void testIsValid_withValidAnimal() {
        //testing with valid animal data
        Animal animal = new Animal("Simon", 4, "Yellow", 145.1);
        //checking with is valid method from animal
        boolean result = animal.isValid();
        assertTrue(result);
    }//end of test method

    @Test
    void testIsValid_withInvalidAnimal() {
        // Arrange
        Animal animal = new Animal(" ", 0, " ", 0);
        //checking with is valid method from animal
        boolean result = animal.isValid();
        assertFalse(result);
    }//end of test method
}//end of test method.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZooAddAnimalTest {
    private Zoo zoo;
    private Animal animal;

    @BeforeEach
    public void setUp() {
        zoo = new Zoo();
        animal = new Tiger("Susan", 13, "Red", 13.0, 12);
    }//setting up the values.

    @Test
    public void testingAddingAnimals() {
        zoo.addAnimal(animal);
        assertTrue(zoo.animals.contains(animal));
    }//end of testing animal
}//end of zoo test
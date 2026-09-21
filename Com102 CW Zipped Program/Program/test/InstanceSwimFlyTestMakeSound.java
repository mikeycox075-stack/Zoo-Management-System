import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InstanceSwimFlyTestMakeSound {
        private Zoo zoo;
        private Animal animal;
    //calling the zoo class with zoo
    //calling the Animal class with animal
        @BeforeEach
        public void setUp() {
            zoo = new Zoo();
            //creating a new instance of the zoo class.
            //Creating three types of animals
            zoo.addAnimal(new Tiger("Tony", 13, "White", 140, 19 ));
            zoo.addAnimal(new Tiger("Tina", 16, "Orange", 200, 28 ));
            zoo.addAnimal(new Shark("Sammy", 58, "White", 90, 19 ));
            zoo.addAnimal(new Shark("Sammy", 28, "Grey", 60, 20 ));
            zoo.addAnimal(new Parrot("Polly", 27, "Pink", 12, "Good"));
            zoo.addAnimal(new Parrot("Gandelf", 28, "Grey", 8, "Perfect"));
            //add three animals
        }//end of setting up all the animals
        @Test
        public void checkInstanceOfAnimalsMakeSound() {
            zoo.AnimalMovement();
            //loading the test for animal movement, this wil, test to see if the values are instances
            //of the correct animal type
            //checking the instances of the animals

            //testing tiger
            Animal Tiger1 = zoo.animals.get(0);
            assertFalse(Tiger1 instanceof Swimmable);
            //checking if tiger is swim
            Animal Tiger2 = zoo.animals.get(1);
            assertFalse(Tiger2 instanceof Flyable);

            Animal Shark1 = zoo.animals.get(2);
            assertTrue(Shark1 instanceof Swimmable);
            //checking is Shark is swim
            Animal Shark2 = zoo.animals.get(3);
            assertFalse(Shark2 instanceof Flyable);
            //checking is Shark is fly

            Animal Parrot1 = zoo.animals.get(4);
            assertTrue(Parrot1 instanceof Flyable);
            //checking if Parrot is fly
            Animal Parrot2 = zoo.animals.get(5);
            assertFalse(Parrot2 instanceof Swimmable);
            //checking to see if the make sound matches the needed sounds.
            String Tiger1sound = Tiger1.makeSound();
            String Tiger2sound = Tiger2.makeSound();
            String Shark1sound = Shark1.makeSound();
            String Shark2sound = Shark2.makeSound();
            String Parrot1sound = Parrot1.makeSound();
            String Parrot2sound = Parrot2.makeSound();
            // Checking if the make sound string exists correctly
            //and matches original make sound is overwritten.
            assertTrue(Parrot1sound.contains("Squawk!"));
            assertFalse(Parrot2sound.contains("Squawk1"));
            assertTrue(Tiger1sound.contains("Grrrr"));
            assertFalse(Tiger2sound.contains("Grrrr1"));
            assertTrue(Shark1sound.contains("blop"));
            assertFalse(Shark2sound.contains("blop1"));
            //checks if parrot is swim
        }//end of testing for instances of swim and flyable.
}//end of test

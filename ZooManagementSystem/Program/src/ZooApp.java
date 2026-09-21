import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZooApp {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        //creating my zoo object
        //loading my zoo function
        //creating my scanner
        Scanner sc = new Scanner(System.in);
        //creating a blank variable choice
        int choice;
        //creating a d while loop to ensure that the code runs correctly
        try {
            do {
                zoo.loadZooDetails();
                System.out.println("""
                        +===== ULSTER ZOO MENU =====+
                        1.| Add Animal
                        2 | Remove Animal
                        3 | Modify Animal
                        4 | Search Animal
                        5 | View all animals
                        6 | Daily care
                        7 | Zoo Report
                        8 | Movement
                        9 | Print Zoo Details
                        10| Update Zoo Details
                        0 | Exit
                        """);

                choice = sc.nextInt();
                System.out.println("");//creating new line for input.
                //getting choice
                //taking the choice.

                if (choice == 1) {
                    zoo.loadAnimals();
                    addAnimalMenu(zoo, sc);
                    zoo.saveAnimals();
                } //end of if add animal

                else if (choice == 2) {
                    zoo.loadAnimals();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    zoo.removeAnimal(name);
                    zoo.saveAnimals();
                } //end of else if remove animal

                else if (choice == 3) {
                    sc.nextLine();
                    zoo.loadAnimals();
                    modifyAnimal(zoo, sc);
                    zoo.saveAnimals();
                } //end of else if modify animal

                else if (choice == 4) {
                    zoo.loadAnimals();
                    System.out.println("""
                            Search with:
                             1. Name
                             2. Colour
                            """);
                    int searchChoice = sc.nextInt();
                    sc.nextLine();
                    if (searchChoice == 1) {
                        System.out.print("Enter name: ");
                        //asking the user to enter a name
                        String name = sc.nextLine();
                        //getting the name
                        Animal found = zoo.searchByName(name);
                        //searching by name with the function.

                        if (found != null) {
                            System.out.println(found.makeSound());
                        }//end of if
                    }//end of choice 1 if

                    else if (searchChoice == 2) {

                        System.out.print("Enter colour: ");
                        String colour = sc.nextLine();

                        ArrayList<Animal> results = zoo.searchByColor(colour);

                        if (results.isEmpty()) {
                            System.out.println("No animals found with colour: " + colour);
                        }//end of first if
                        else {
                            System.out.println(results.size() + " animal(s) found:");
                            for (Animal a : results) {
                                System.out.println(a.getName() + " (" + a.getClass().getSimpleName() + ")");
                                System.out.println(a.makeSound()); //calling the make sound
                                System.out.println();

                                //get the user to type a color, call search method in zoo,
                                //loops through animal list, made sure to ignore the case,
                                //appends any matching animal colour to results
                                //returns the matches.

                                //get name, calls the get animal name, get class, get simple name = shark, tiger
                                // or parrot
                            }//end of for
                        }//end of else
                    }//end  else if of  choice 2

                    else {
                        System.out.println("Invalid search option.");
                    }
                }//end of else if search animal 4

                else if (choice == 5) {
                    zoo.loadAnimals();
                    zoo.listAnimals();
                } //end of else if view all animals

                else if (choice == 6) {
                    zoo.loadAnimals();
                    zoo.dailyCare();
                    System.out.println("If animal does not have specific care need, carry out\n" +
                            " default caregiver needs, replace water, check bedding, clean\n" +
                            " enclosure check health of animal and give medication if needed.\n" +
                            " Contact head of medicated animal control if unsure.");
                } //end of else if Daily care

                else if (choice == 7) {
                    zoo.loadAnimals();
                    zoo.report();
                } //end of else if Zoo report

                else if (choice == 8) {
                    zoo.loadAnimals();
                    zoo.AnimalMovement();
                } //end of if add animal

                else if (choice == 9){
                    zoo.printZooDetails();
                }
                else if (choice == 10){
                    zoo.loadZooDetails();
                    zoo.getNewZooDetails();
                    zoo.saveZooDetails();
                }

                else if (choice == 0) {
                    zoo.saveZooDetails();
                    System.out.println("Exiting...");

                } //end of else if exit
                else {
                    System.out.println("Invalid option. Please try again.");
                } //end of else

            } while (choice != 0); //continue if user does not wish to exit
            zoo.saveAnimals();
            //calling zoo animals to repeats the program
            System.out.println("Saved. Goodbye.");
            //printing goodbye
        }
        catch (InputMismatchException e){
            System.out.println("Please Enter a valid Character");
        }
        catch(Exception e) {
            System.out.println("Please Enter a valid Number");
        }
    }// end of function



    private static void addAnimalMenu(Zoo zoo, Scanner sc) {

        System.out.println("1. Tiger  2. Parrot  3. Shark");
        int animalType = sc.nextInt();
        sc.nextLine();  //gets the input.

        System.out.print("Name: ");
        String addName = sc.nextLine();
        //gets the name

        System.out.print("Age: ");
        int addAge = sc.nextInt();
        sc.nextLine();
        //gets the age

        System.out.print("Color: ");
        String addColor = sc.nextLine();
        //gets the color

        System.out.print("Weight: ");
        double addWeight = sc.nextDouble();
        sc.nextLine();
        //gets the weight

        if (animalType == 1) {//checks if user input matches animal
            System.out.print("ClawLength: ");
            int addClawLength = sc.nextInt();
            sc.nextLine();
            zoo.addAnimal(new Tiger(addName, addAge, addColor, addWeight, addClawLength));
        }//end of if, Tiger
        else if (animalType == 2) {//checks if user input matches animal
            System.out.print("featherCondition: ");
            String featherCondition = sc.nextLine();
            zoo.addAnimal(new Parrot(addName, addAge, addColor, addWeight, featherCondition));
        }//end of else if, parrot
        else if (animalType == 3) {//checks if user input matches animal
            System.out.print("teethHealth (Rate 1-20): ");
            int teethHealth = sc.nextInt();
            sc.nextLine();
            zoo.addAnimal(new Shark(addName, addAge, addColor, addWeight, teethHealth));
        }//end of else if, Shark
        else {
            System.out.println("The animal you have entered can not be found...");
        }//end of else, prints if no animal is found.
    }//end of function.



    private static void modifyAnimal(Zoo zoo, Scanner sc) {
        zoo.loadAnimals();

        System.out.print("Enter name: ");

        String name = sc.nextLine().trim();

        Animal a = zoo.searchByName(name);

        if( a == null){
            System.out.println("Animals can not be found");
            return;
        }//end of if
        //getting the name of the animal and allowing me to edit the values

        System.out.println("""
            What would you like to modify?
            1. Age
            2. Weight
            3. Colour
            4. Name
            5. Special Characteristic
            0. Exit
            """);

        int choice = sc.nextInt();
        sc.nextLine(); //getting the input form the user to see what they want to edit.


        if (choice == 1) {
            System.out.print("New age: ");
            int newAge = sc.nextInt();
            sc.nextLine();
            if (newAge > -1 ){
                a.setAge(newAge);
                System.out.println("Age updated.");
            }//end of check for zero
            else{
                System.out.print("Can not accept anything below 0 as an age.");
                return;
            }//end of else
        }//end of if age

        else if (choice == 2) {
            System.out.print("New weight: ");
            double newWeight = sc.nextDouble();
            sc.nextLine();
            if (newWeight > 0) {
                a.setWeight(newWeight);
                System.out.println("Weight updated.");
            }//end of if
            else {
                System.out.println("Weight must be greater than zero");
                return;
            }//end of else if weight check for 0
        }// end of else if weight

        else if (choice == 3) {
            System.out.print("New colour: ");
            String newColour = sc.nextLine();
            if (!newColour.isEmpty()) {
                a.setColor(newColour);
                System.out.println("Colour updated.");
            }//end of if for checking for nulls
            else if (newColour.isEmpty()){
                System.out.println(" Can not accept empty values ");
                return;
            }//end of else if for null
        }//end of else if colour

        else if (choice == 4) {
            System.out.print("New name: ");
            String newName = sc.nextLine(); //had to add this to stop
            //glitch with test, it was because it was not registering
            if( !newName.isEmpty()){
                a.setName(newName);
                System.out.println("Name updated.");
            }//end of if for check null
            else if (newName.isEmpty()){
                System.out.println("Can not accept empty values.");
                return;
            }//end of else if
        }//end of else if name

        else if (choice == 5) {
            //claw
            if (a instanceof Tiger) {
                Tiger t = (Tiger) a;
                System.out.print("New claw length: ");
                int newClaws = sc.nextInt();
                sc.nextLine();
                if (newClaws > 0) {
                    t.setClawLength(newClaws);
                    System.out.println("Claw length updated.");
                }//end of check for zero claw length
                else{
                    System.out.println("Claw Length mst be greater than zero.");
                    return;
                }
            }//end of if claw
            //feather
            else if (a instanceof Parrot) {
                Parrot p = (Parrot) a;
                System.out.print("New feather condition: ");
                String newFeathers = sc.nextLine();
                if (!newFeathers.isEmpty()) {
                    p.setFeatherCondition(newFeathers);
                    System.out.println("Feather condition updated.");
                }//end of check for not blank
                else if (newFeathers.isEmpty()){
                    System.out.println("Can not accept null values");
                    return;
                }//end of checking for blank
            }//end of if feather

            // Shark ⇒ teeth health
            else if (a instanceof Shark) {
                Shark s = (Shark) a;
                System.out.print("New teeth health: ");
                int newTeeth = sc.nextInt();
                sc.nextLine();
                if (newTeeth > 0  && newTeeth <= 20) {
                    s.setTeethHealth(newTeeth);
                    System.out.println("Teeth health updated.");
                }//end of check for zero.
                else if(newTeeth > 20){
                    System.out.println("The teeth health must be between 1-20");
                    return;
                }//end of check for above 15
                else {
                    System.out.println("Teeth health can not be less than zero");
                    return;
                }//end of teeth health
            }//end of if teeth

            else {
                System.out.println("You have selected an invalid animal");
            }//end of else
        }//end of else if extra attribute

        else if (choice == 0) {
            System.out.println("Exiting...");
        }//end of exit

        else {
            System.out.println("The animal you have selected does not exist");
        }//end of check if invalid
    }//end of modify animal

}//end of class

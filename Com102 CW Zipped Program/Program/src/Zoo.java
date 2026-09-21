//importing needed libs
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//creating my class
public class Zoo {
    Scanner sc = new Scanner(System.in);
    //creating scanner object
    //creating class variables...
    public ArrayList<Animal> animals = new ArrayList<>(); //creating my array list

    private String address = "Unknown";
    private String telephone = "Unknown";
    private String zooName = "Ulster Zoo";  // default
    private String postcode = "Unknown";

    //loading animals from a file
    public void loadAnimals() {
        animals.clear();
        try {
            File file = new File("AnimalDetails.txt");
            if (!file.exists()) {
                System.out.println("AnimalDetails.txt not found.");
                return;
            }//end of if
            Scanner reader = new Scanner(file);
            //reading the file
            int lineNumber = 0;
            while (reader.hasNextLine()) {
                //creating a thing to hold the string line to sort through
                String line = reader.nextLine();
                lineNumber++;
                if (line == null || line.strip().isEmpty()) continue;
                String[] p = line.split(",");
                //splitting the string line  into words to sort through
                for(int i = 0; i < p.length;i++){
                    p[i] = p[i].trim();
                }//end of for

                String name = p[0]; //the name of the animal is at location 0
                int age = Integer.parseInt(p[1]); //same for age
                String color = p[2]; //same for color
                double weight = Double.parseDouble(p[3]); //same for weight
                String type = p[4]; //same for type

                //applying special vars to the locations
                if (type.equalsIgnoreCase("Tiger")) {
                    int clawLength = Integer.parseInt(p[5]); //location 5,special var
                    animals.add(new Tiger(name, age, color, weight, clawLength));
                }//end of if
                else if (type.equalsIgnoreCase("Parrot")) {
                    String featherCondition = p[5];//same thing
                    animals.add(new Parrot(name, age, color, weight, featherCondition));
                }//end of else if
                else if (type.equalsIgnoreCase("Shark")) {
                    int teethHealth = Integer.parseInt(p[5]); //same again
                    animals.add(new Shark(name, age, color, weight, teethHealth));
                }//end of final else if
            }//end of while
            //closing the file reader.
            reader.close();

            //catching the exceptions
        }//end of try
        catch (Exception e) {
            System.out.println("No previous animal file found.");
            //catching the exception if animal is not found.
        }//end of catch
    }//end of load animals


    //saving the animals to the file
    public void saveAnimals() {

        if (animals == null || animals.isEmpty()) {
            System.out.println("No animals to save. File not overwritten.");
            return;
        }//end of checking for nulls or empty

        try (PrintWriter pw = new PrintWriter("AnimalDetails.txt")) {
            for (Animal a : animals) {
                if (a.isValid()){
                    pw.println(a);
                }
                //I am allowing users to add numbers to animal names in case of the event that
                //animals have the same name, such as Jack1, Jack2
                else{
                    System.out.println("The animal can not have null values " +
                            "or the value can not equal 0.");
                }
            }//end of for
        } //end of try
        catch (Exception e) {
            System.out.println("Error saving animals.");
        }//end of catch
    }//end of saveAnimals


    public void addAnimal(Animal a) {
        if ( a == null){
            System.out.print("Can not save animals, as it contains null values.");
        }//end of check for nulls
        else if ( !a.isValid()){
            System.out.println("Animal contains invalid values.");
            return;
        }//end of check for valid.
        else if ( a.isValid()){
            System.out.println("Animal values correct, animal saved successfully.");
            animals.add(a);
        }//end of check for valid
        else{
            System.out.print("An error has occurred");
            //Don't think this would ever run, added just in case 
        }//end of final check
        //adding the animal
    }//end of add animals


    public void removeAnimal(String name) {
        boolean found1 = false;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equalsIgnoreCase(name)) {
                //adding ignore case to stop error...
                animals.remove(i);
                found1 = true;
                break;
            }//end of if
        }//end of for
        if (found1 == false){
            System.out.println("Animal can not be found.");
        }//end of if
        else if (found1 == true){
            System.out.println("Animal has been removed");
        }// end of else if
    }//end of remove animals


    public Animal searchByName(String name) {
        for (int i = 0; i < animals.size(); i++) { //sorting by length of arraylist
            Animal a = animals.get(i);
            //attaching animal to a variable
            if (a.getName().equalsIgnoreCase(name)) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Animal not found or null values inputted.");
        return null;
        //if not found
    }//end of search by name


    public void dailyCare() {
        for (Animal a : animals) {
            System.out.println("General care for " + a.getName());
            if (a instanceof Flyable f) f.checkWings();
            if (a instanceof Swimmable s) s.checkFins();
        }//end of for
    }//end of daily care


    public void report() {
        //print the hardcoded zoo name
        System.out.println("Zoo Report for " + zooName);

        //creating a lst for the counts and types
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        //sorting through animals to find the animal name
        for (int i = 0; i < animals.size(); i++) {
            String type = animals.get(i).getClass().getSimpleName();

            //creating an index as it should show no animal being found

            int index = -1;

            //looks for the animal in the list
            for (int j = 0; j < types.size(); j++) {
                if (types.get(j).equals(type)) {
                    index = j;
                    break;
                }//end of if
            }//end of for

            if (index == -1) {
                //if the animal is not found in the index, it adds it.
                types.add(type);
                counts.add(1);
            }//end if statement
            else {
                //if the animal already exists, it increases the count
                counts.set(index, counts.get(index) + 1);
            }//end of else
        }//end of for

        //prints the count for each type of animal.
        for (int i = 0; i < types.size(); i++) {
            System.out.println(types.get(i) + " the count is " + counts.get(i));
        }//end of for

        //find the dominating color
        //setting the string to none, in case of two equal amounts ect
        String dominantColor = "None";
        //setting the dominant count
        int dominantCount = 0;
        //sorting through animals to et each color for the length of animals
        for (int i = 0; i < animals.size(); i++) {
            String color = animals.get(i).getColor();
            int colorCount = 0;
            //incrementing the colors for each count of animal.
            for (int j = 0; j < animals.size(); j++) {
                if (animals.get(j).getColor().equalsIgnoreCase(color)) {
                    colorCount++;
                }//end of if
            }//end of for

            if (colorCount > dominantCount) {
                dominantCount = colorCount;
                dominantColor = color;
                //setting the dominant color and count so it can be printed
            }//end of if
        }//end of for

        System.out.println("Dominant color: " + dominantColor);
        //printing the dominant color...
    }//end of report

    public void listAnimals() {
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            System.out.println(a.makeSound());
        }//end of for
    }//end of list animals

    public void loadZooDetails(){
        try (Scanner reader = new Scanner(new File("ZooDetails.txt"))){
            while (reader.hasNextLine()){
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    this.address   = parts[0].trim();
                    this.telephone = parts[1].trim();
                    this.zooName   = parts[2].trim();
                    this.postcode  = parts[3].trim();
                }//end of if
                }//end of while,
            }//end of try
        catch (Exception e){
            System.out.println("ZooDetails.txt can not be found");
        }
    }//end of function


    public ArrayList<Animal> searchByColor(String color) {
        ArrayList<Animal> results = new ArrayList<Animal>();
        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            if (a.getColor().equalsIgnoreCase(color)) {
                results.add(a);
            }//end of if
        }//end of for
        if (results.isEmpty()){
            System.out.println("Animal colour not found or null values inputted.");
        }
        return results;
    }//searching by color by checking if animal color is matching
    //qual to the color selected


    public void saveZooDetails() {
        try(PrintWriter pw = new PrintWriter("ZooDetails.txt")) {
            pw.println(address + "," + telephone + "," + zooName + "," + postcode);
        } catch (Exception e) {
            System.out.println("Unable to save ZooDetails.txt");
        }//end of exception
    }// end of function

    public void AnimalMovement(){
        for (Animal a : animals) {
            if (a instanceof Swimmable s) s.swim();
            else if  (a instanceof Flyable f) f.fly();
            else{
                System.out.println(a.getName() + " gallops gracefully.");
            }//end of else

        }//end of for
    }//end of animal movement

    public void printZooDetails() {
        try {
            File file = new File("ZooDetails.txt");
            if (!file.exists()) {
                System.out.println("ZooDetails.txt not found.");
                return;
            }//end of if
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] str = line.split(",");
                    String address = str[0];
                    System.out.println("Address: " + address);

                    String phone = str[1];
                    System.out.println("Phone: " + phone);

                    String name = str[2];
                    System.out.println("Name of Zoo: " + name);

                    String postCode = str[3];
                    System.out.println("Postcode: " + postCode);
            }//end of while
        }//end of try
        catch (FileNotFoundException e){
            System.out.println("The file can not be found");

        }//end of catch

    }//end of print zoo details

        public void getNewZooDetails(){
            System.out.println("""
            What would you like to modify?
            1. Address
            2. Telephone
            3. Zoo Name
            4. Postcode
            0. Exit
            """);

            int choicei = sc.nextInt();     //getting choice
            if (choicei == 0){
                System.out.println("Stopping the Update of Zoo details");
                return;
            }//end of if
            if (choicei == 1) {
                sc.nextLine();
                System.out.println("Please Input the new Address: ");
                String newAddress = sc.nextLine().trim();
                if (!newAddress.isEmpty()) {
                    this.address = newAddress;
                    System.out.println("Address Updates");
                } //end of check for null
                else {
                    System.out.println("The Zoo Details will not be updated as " +
                            "either null values, empty values " +
                            "or incorrect values have been inputted.");
                }//end of else
            }//end of if 1
            if (choicei == 2) {
                sc.nextLine();
                System.out.println("New Telephone: ");
                String newTelephone = sc.nextLine().trim();
                if (!newTelephone.isEmpty()) {
                    this.telephone = newTelephone;
                    System.out.println("Telephone Updated");
                } //end of check for null
                else {
                    System.out.println("The Zoo Details will not be updated as " +
                            "either null values, empty values " +
                            "or incorrect values have been inputted.");
                }//end of else
            } //end of if 2
            if (choicei == 3) {
                sc.nextLine();
                System.out.println("Please Input the new Zoo Name: ");
                String newZooName = sc.nextLine();
                if (!newZooName.isEmpty()){
                    this.zooName = newZooName;
                    System.out.println("Zoos name Updated");
                } //end of check for null
                else {
                    System.out.println("The Zoo Details will not be updated as " +
                            "either null values, empty values " +
                            "or incorrect values have been inputted.");
                }//end of else
            } //end of if 3
            if (choicei == 4) {
                sc.nextLine();
                System.out.println("Please Input the new Postcode: ");
                String newPostcode = sc.nextLine();
                if (!newPostcode.isEmpty()) {
                    this.postcode = newPostcode;
                    System.out.println("Postcode Updated");

                } //end of check for null
                else {
                    System.out.println("The Zoo Details will not be updated as " +
                            "either null values, empty values " +
                            "or incorrect values have been inputted.");
                }//end of else
            } //end of if 4
        }//end of get new zoo details
    //setting functions for testing zoo details
         public String getZooName (){
            return zooName;
            //using this to test to see if zoo name is null during testing
        }//end of returning zooName
        public String getAddress () {
            return address;
            //using this to test to see if zoo address is null during testing
        }//emd of get address
        public String getTelephone () {
            return telephone;
            //attaching telephone to the get Telephone so it can be tested for null values in testing
        }//end of get telephone
        public String getPostcode () {
            return postcode;
            //attaching get post code to the variable getPostcode so it can be tested for nulls
            //in testing
        }//end of getPostcode testing method
    //creating setts for get zoo details for testing purposes.
    public void setZooName(String zooName) {
        this.zooName = zooName;
    }//setting the zoos name
    public void setAddress(String address) {
        this.address = address;
    }//setting the zoos address
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }//setting the zoos telephone
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }//setting the zoos postcode
}//end of class

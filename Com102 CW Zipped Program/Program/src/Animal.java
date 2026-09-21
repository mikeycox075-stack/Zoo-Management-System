import org.junit.jupiter.api.Test;
public class Animal {
    //creating objects in class
    private String name;
    private int age;
    private String color;
    private double weight;
    //setting

    public Animal(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }//creating my objects

//checking validation
    public boolean isValid() {
        return name != null && !name.isBlank()
                && color != null && !color.isBlank()
                && age > 0.1 && weight > 0.1;
    }//end of is valid
//setting name to getName
    // Getters and setters

    //creating getters
    public String getName() {
        return name;
    }//end of name
    //setting Name to getName
    public int getAge() {
        return age;
    }//end of age
    //setting age to get age.
    public String getColor() {
        return color;
    }//end of color
    //same thing
    public double getWeight() {
        return weight;
    }//end of weight
    //same thing here setting weight to getWeight
//attaching class variable to object
    //creating setters

    public void setName(String name) {
        this.name = name;
    }//end of name
    //same
    public void setAge(int age) {
        this.age = age;
    }//end of age
    //same
    public void setColor(String color) {
        this.color = color;
    }//end of color
    //same
    public void setWeight(double weight) {
        this.weight = weight;
    }//end of weight

    //creating basic to string to be overridden for specific animals.
    @Override
    public String toString() {
        return name + "," + age + "," + color + "," + weight + "," + getClass().getSimpleName();
    }//end of to string
    public String makeSound(){
        return "I am a " + name + " and I make the sound ";
    }
}//end of make sound

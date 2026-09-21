public class Parrot extends Animal implements Flyable {
    private String featherCondition;

    public Parrot(String name, int age, String color, double weight, String featherCondition){
        super(name, age, color, weight);
        this.featherCondition = featherCondition;
    }//creating a new value in the subclass

    @Override
    public String makeSound() {
        return "Squawk! I am " + getName() + ", a " + getAge() + " year old parrot."
            +" Whos colour is " + getColor() + "." + " My weight is " + getWeight()
                + " and my feather Condition is " + featherCondition + ".";
}//overriding the makesound() for parrot

    //overriding fly for movement and others
    @Override
    public void fly() {
        System.out.println( getName() + " is flapping around their enclosure.");
    }//end of fly
    //override daily care
    @Override
    public void checkWings() {
        System.out.println("Wing health check completed for " + getName());
    }//end of check wings

    @Override
    public String toString() {
        return super.toString() + "," + featherCondition;
        //adding feather condition,
    }//end of toString

    public void setFeatherCondition(String featherCondition){
        this.featherCondition = featherCondition;
    }//end of setFeather Condition
//Setters are added to change later on.
}//end of class


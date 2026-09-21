public class Shark extends Animal implements Swimmable {
    private int teethHealth;
    //creating variable teeth health

    public Shark(String name, int age, String color, double weight, int teethHealth) {
        super(name, age, color, weight);
        this.teethHealth = teethHealth;
    }//adding teeth health to the subclass

    @Override
    public String makeSound() {
        return "blop, blop! I am " + getName() + ", a " + getAge() + " year old shark."
                +" Whos colour is " + getColor() + "." + " My weight is " + getWeight()
                + " and my teeth health is " + teethHealth + ".";
    }//overriding make sound with teeth health

    @Override
    public void swim() {
        System.out.println(getName() + " swims gracefully.");
    }//overriding swim

    @Override
    public void checkFins() {
        System.out.println("Fin health check completed for " + getName());
    }//overriding daily care need

    @Override
    public String toString() {
        return super.toString() + "," + teethHealth;
    }//adding teeth health to the to String

    public void setTeethHealth(int teethHealth) {
        this.teethHealth = teethHealth;
    }//creating the setter for teeth health.
//setting the setters so it can be edited later.
}//end of class

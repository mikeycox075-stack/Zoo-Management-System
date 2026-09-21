public class Tiger extends Animal {
    private int clawLength;
    //creating claw length variable

    //creating the subclass
    public Tiger(String name, int age, String color, double weight, int clawLength) {
        super(name, age, color, weight);
        this.clawLength = clawLength;
    }//which adds claw length to the animal object

    //overriding the to string and make sound.
    @Override
    public String makeSound() {
        //adding details to make sound for convenience
        return "Grrrr I am a " + getName() + ", a " + getAge() + " year old Tiger."
                + " Whos colour is " + getColor() +"."
                + " My weight is "+ getWeight() + " and my clawlength is " + clawLength + ".";
    }//end of make sound
    //overriding make sound to include claw length as well

    @Override
    public String toString() {
        return super.toString() + "," + clawLength;
    }//overriding to string to add claw length

    public void setClawLength(int clawLength) {
        this.clawLength = clawLength;
    }//end of set Claw Length
//adding setters so it can be edited later
}//end of class


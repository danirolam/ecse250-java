package animals.mammals;

import humans.Person;

public class Dog extends Animal{
    private int energy;
    private static int numberOfDogs;

    public Dog(String name, String breed, Person person, int energy){
        super(name, breed, person.getName());
        this.energy = energy;
        numberOfDogs++;
    }

    public int getEnergy(){
        return this.energy;
    }
    public static int getNumberOfDogs(){
        return numberOfDogs;
    }

    @Override
    public String getSound(){
        if (this.energy > 5){
            return "WOOF WOOF!";
        }
        else{
            return "woof woof";
        }
    }

}

package animals.mammals;

import humans.Person;

public class Cat extends Animal{
    private boolean mood;
    private static int numberOfCats;

    public Cat(String name, String breed, Person person, boolean mood) {
        super(name, breed, person.getName());
        this.mood = mood;
        numberOfCats++;
    }

    public boolean getMood(){
        return this.mood;
    }
    public static int getNumberOfCats(){
        return numberOfCats;
    }

    @Override
    public String getSound(){
        if (this.mood){
            return "meow~";
        }
        else{
            return "MEOW!";
        }
    }
}

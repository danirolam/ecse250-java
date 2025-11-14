package animals.mammals;

public abstract class Animal {
    private String name;
    private String breed;
    private String owner;
    private static int numberOfAnimals;

    public Animal(String name, String breed, String owner){
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        numberOfAnimals++;
    }

    public String getName() {
        return this.name;
    }
    public String getBreed(){
        return this.breed;
    }
    public String getOwnerName(){
        return this.owner;
    }
    public static int getNumberOfAnimals(){
        return numberOfAnimals;
    }
    public abstract String getSound();
}

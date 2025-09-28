//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import animals.mammals.*;
import humans.Person;
public class Main {
    public static void main(String[] args) {

        Person Toma = new Person("Toma");
        Cat Myn = new Cat("Myn", "hairless", Toma, true);

        System.out.println("Person name: " + Toma.getName());
        System.out.println("Cat sound: " + Myn.getSound());
        System.out.println("Cat name: " + Myn.getName());

        Person charlie = new Person ("Charlie Brown") ;
        System.out.println(charlie.getName()) ;
        Dog snoopy = new Dog ("Snoopy", "Beagle", charlie, 1) ;
        System.out.println(snoopy.getName());
        System.out.println(snoopy.getBreed());
        System.out.println(snoopy.getOwnerName());
        System.out.println(snoopy.getEnergy());

        Person roger = new Person ("Roger Radcliffe") ;
        Person jon = new Person("Jon Arbuckle" ) ;
        Dog pongo = new Dog ("Pongo", "Dalmatians", roger, 15) ;
        Cat garfield = new Cat( "Garfield", "Orange", jon, true) ;
        System.out.println("# Dogs: " + Dog.getNumberOfDogs());
        System.out.println("# Cats: " + Cat.getNumberOfCats());
        System.out.println("# Animals: " + Animal.getNumberOfAnimals());

    }
}
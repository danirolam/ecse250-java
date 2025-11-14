import animals.mammals.*;
import zoo.Zoo;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Zoo animal_list = new Zoo();
        // put this in a try catch block
        animal_list.add(new Bear("Buddy")) ;
        int numRabbits1 = animal_list.getNumberOfRabbits();
        animal_list.add(new Rabbit("Simon")) ;
        // what do you expect to see in animal_list
        System.out.println(animal_list);
        System.out.println(animal_list.size());
;
        animal_list.add(new Rabbit("Rufus")) ;
        System.out.println(animal_list.get(1).getName());
        System.out.println(animal_list.get(0).getName());

        int numRabbits2 = animal_list.getNumberOfRabbits();
        System.out.println("# rabbits1: " + numRabbits1);
        System.out.println("# rabbits2: " + numRabbits2);

        Animal a = animal_list.remove(1) ;
        System.out.println("Remove: " + a) ;
        int numRabbits3 = animal_list.getNumberOfRabbits();
        System.out.println("# rabbits3: " + numRabbits3);
        System.out.println("Size: "+ animal_list.size());
    }

}
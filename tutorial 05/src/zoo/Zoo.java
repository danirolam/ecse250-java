package zoo;

import animals.mammals.*;

import java.util.Arrays;

public class Zoo {
    private Animal[] animals;
    private int size;
    int numberOfRabbits = 0;



    public Zoo() {
        animals = new Animal[3];
        size = 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.size; i++) {
            s = s + this.animals[i].toString() + "\n";
        }
        return s;
    }

    public void add(Animal animal) {
        int current_length = animals.length;
        if (current_length == size) {
            resize();
        }
        animals[size] = animal;
        size++;
    }

    private void resize() {
        int new_size = animals.length * 2;
        Animal[] animals_bigger = new Animal[new_size];
        for (int i = 0; i < size; i++) {
            animals_bigger[i] = this.animals[i];
        }
        this.animals = animals_bigger;

    }

    public Animal remove(int index_to_remove) {
        if (index_to_remove < 0 || index_to_remove > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Animal animal_to_remove = animals[index_to_remove];

        // Shift
        for (int i = index_to_remove; i < size - 1; i++) {
            animals[i] = animals[i + 1];
        }
        size--;
        return animal_to_remove;
    }

    public int getNumberOfRabbits() {
        numberOfRabbits = 0;

        for (int i = 0; i < size; i++) {
            if (animals[i] instanceof Rabbit) {
                numberOfRabbits++;
            }
        }
        return numberOfRabbits;
    }

    public Animal get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return animals[index];
    }
}

package animals.mammals;

public abstract class Animal {

    private String name ;

    public Animal (String name) {
        this.name = name ;
    }

    public String getName() { return this.name ; }

    public abstract String getSound() ;

    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getName() + " says " + this.getSound() ;
    }
}
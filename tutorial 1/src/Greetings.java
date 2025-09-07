public class Greetings {
    public static String greet(String name) {
        return "Hello there, " + name + "!";
    } 


    public static void main(String[] args) {
        String userName = args[0];
        System.out.println(Greetings.greet(userName));
    }

}
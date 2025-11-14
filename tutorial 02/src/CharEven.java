public class CharEven {
    public static void main(String[] args) {

        int test_number = 21;
        char input_char = 'a';

        System.out.println("Input number " + test_number + " output: " + isEven(test_number));
        System.out.println("Input letter " + input_char + " its ascii value: " + (int) input_char +  " output " + isEven(input_char));
    }

    public static boolean isEven(int input_num){
        if (input_num % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isEven(char input_char){
        if (input_char % 2 == 0 && (input_char >= 65 && input_char <= 90 || input_char >= 97 && input_char <= 122)){
            return true;
        }
        else {
            return false;
        }
    }
}

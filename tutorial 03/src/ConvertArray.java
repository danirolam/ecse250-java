public class ConvertArray {

    public static int[] stringToInt(String [] stringArray){

        int [] newArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            try {
                newArray[i] = Integer.parseInt(stringArray[i].trim());
                if (newArray[i]<0){
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }

        }


        return newArray;
    }

    public static int[] tryConvert(String [] stringArray){
        int [] newArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            try {

                newArray[i] = Integer.parseInt(stringArray[i].trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + " Error, new array will be -100");
                for (int j = 0; j < stringArray.length; j++){
                    newArray[j] = -100;
                }
                return newArray;
            }
        }
        return newArray;

    }
}

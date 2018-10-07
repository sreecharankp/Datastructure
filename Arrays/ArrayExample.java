package Array;

public class ArrayExample {

    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 11;
        intArray[1] = -22;
        intArray[2] = 13;
        intArray[3] = 5;
        intArray[4] = 8;

        for(int i=0;i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
    }
}

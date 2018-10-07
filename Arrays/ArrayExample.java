package Array;

public class ArrayExample {

    //To retrive element in array x+i*y
    //x -> starting address
    //i -> index of an array
    //y -> size (ex: if its an array of int -> size is 4)
    //Address of 3rd element if starting address is 12
    // 12 + 3 * 4 -> 24 starting address of 3rd element i,e 5
    /*
    Number of elements:       Steps to retrive
    1                           3
    10                          3
    100                         3
    1000                        3
    So number of elements is equal to N number of steps
    its constant time complexity
    so time complexity of retriving data from array -> O(1) => if we know starting address of an array --> this is the best case
    For searching an element in an array
    worst case if element is at the end of an array -> have to iterate 'n' number of times, So its linear
    worst case --> O(n)
    */
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

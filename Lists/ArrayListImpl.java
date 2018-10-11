import java.util.Arrays;

public class ArrayListImpl {

    public Object[] myArray;
    public int actSize = 0;

    public ArrayListImpl() {
        myArray = new Object[10];
    }

    public void add(Object object) {
        if (myArray.length - actSize <= 5) {
            increaseSizeOfArray();
        }
        myArray[actSize++] = object;
    }

    private void increaseSizeOfArray() {
        myArray = Arrays.copyOf(myArray, myArray.length * 2);
        System.out.println("New length: " + myArray.length);
    }

    public Object get(int index) {
        if (index < actSize) {
            return myArray[index];
        } else {
            return new ArrayIndexOutOfBoundsException();
        }
    }

    public int size() {
        return actSize;
    }

    public Object remove(int index) {
        if (index < actSize) {
            Object obj = myArray[index];
            myArray[index] = null;
            int temp = index;
            while (temp < actSize) {
                myArray[temp] = myArray[temp + 1];
                myArray[temp + 1] = null;
                temp++;
            }
            actSize--;
            return obj;
        } else {
            return new ArrayIndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        ArrayListImpl mal = new ArrayListImpl();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
        System.out.println();
        mal.add(new Integer(29));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
        System.out.println();
        System.out.println("Element at Index 5:" + mal.get(5));
        System.out.println("List size: " + mal.size());
        System.out.println("Removing element at index 2: " + mal.remove(2));
        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }

    }
}

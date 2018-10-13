public class MyDecimalToBinary {

    public static void main(String a[]) {
        System.out.println("Binary value of 2 is: " + convertDecialToBinary(2));
        System.out.println("Binary value of 15 is: " + convertDecialToBinary(15));
        System.out.println("Binary value of 23 is: " + convertDecialToBinary(23));
    }

    private static String convertDecialToBinary(int num) {
        StringBuilder binary = new StringBuilder();
        MyStackImpl stack = new MyStackImpl(10);

        if (num == 0) {
            binary.append(0);
        } else {
            while (num != 0) {
                try {
                    stack.push(num % 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                num = num / 2;
            }
        }

        while (!stack.isStackEmpty()) {
            try {
                binary.append(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return binary.toString();
    }
}

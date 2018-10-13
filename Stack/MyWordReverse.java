public class MyWordReverse {

    public static void main(String a[]) {
        MyWordReverse mwr = new MyWordReverse();
        System.out.println("Java2Novice == " + mwr.reverseWord("Java2Novice"));
        System.out.println("Java == " + mwr.reverseWord("Java"));
        System.out.println("program == " + mwr.reverseWord("program"));
    }

    private String reverseWord(String str) {

        MyStackImpl stack = new MyStackImpl(str.length());
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            try {
                stack.push(str.charAt(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (!stack.isStackEmpty()) {
            try {
                 br.append(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return br.toString();

    }
}

public class MyDelimiterMatching {

    public static void main(String a[]) {

        try {
            MyDelimiterMatching mdm = new MyDelimiterMatching();
            String expression = "{(a+b)*(c+d)}";
            boolean result = false;

            result = mdm.isDelimiterMatching(expression);
            System.out.println(expression + " == " + result);

            expression = "{(a+b)+[x*(c+d)]}";
            result = mdm.isDelimiterMatching(expression);
            System.out.println(expression + " == " + result);

            expression = "{(a+b)+[x*(c+d)}}";
            result = mdm.isDelimiterMatching(expression);
            System.out.println(expression + " == " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isDelimiterMatching(String expression) throws Exception {

        MyStackImpl stack = new MyStackImpl(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (!stack.isStackEmpty()) {
                        char temp = (char) stack.pop();
                        if ((ch == '}' && temp != '{') ||
                                (ch == ']' && temp != '[') ||
                                (ch == ')' && temp != '(')) {
                            System.out.println("Mismatch found: " + ch + " at " + i);
                            return false;
                        }
                    } else {
                        System.out.println("Mismatch found: " + ch + " at " + i);
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isStackEmpty()) {
            System.out.println("Error: missing right delimiter");
            return false;
        }
        return true;
    }
}

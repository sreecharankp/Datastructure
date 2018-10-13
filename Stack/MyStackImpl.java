public class MyStackImpl<T> {

    private int stackSize;
    private T[] stackArray;
    private int top;

    public MyStackImpl(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = (T[]) new Object[stackSize];
        this.top = -1;
    }

    public void push(T element) throws Exception {
        if (this.isStackFull()) {
            throw new Exception("Stack is already full. Can not add element.");
        }
        System.out.println("Adding: " + element);
        this.stackArray[++top] = element;
    }

    public T pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T element = this.stackArray[top--];
        System.out.println("Removed entry: " + element);
        return element;
    }

    private boolean isStackEmpty() {
        return (top == -1);
    }

    private boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public T peek() {
        return stackArray[top];
    }

    public static void main(String[] args) {
        MyStackImpl stack = new MyStackImpl(5);
        try {
            stack.push(4);
            stack.push(8);
            stack.push(3);
            stack.push(89);
            stack.pop();
            stack.push(34);
            stack.push(45);
            stack.push(78);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class MyDynamicStack<T> {
    private int stackSize;
    private T[] stackArray;
    private int top;

    public MyDynamicStack(int stackSize) {
        this.stackSize = stackSize;
        this.stackArray = (T[]) new Object[stackSize];
        this.top = -1;
    }

    public void push(T element) {
        if (this.isStackFull()) {
            System.out.println("Stack is already full. Inscreasing Stack size.");
            increaseStackSize();
        }
        System.out.println("Adding: " + element);
        this.stackArray[++top] = element;
    }

    private void increaseStackSize() {
        T[] temp = (T[]) new Object[stackSize * 2];
        for (int i = 0; i < stackSize; i++) {
            temp[i] = this.stackArray[i];
        }
        this.stackArray = temp;
        this.stackSize = this.stackSize * 2;
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
        MyDynamicStack stack = new MyDynamicStack(2);
        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 1; i < 4; i++) {
            try {
                stack.pop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

import java.util.NoSuchElementException;

public class CircularQueueImpl<T> {

    private int front = 0;
    private int back = 0;
    private T[] queue;

    public CircularQueueImpl(int size) {
        this.queue = (T[]) new Object[size];
    }

    public void add(T element) {

        if (getSize() == queue.length - 1) {
            T[] newArray = (T[]) new Object[queue.length * 2];
            int numItems = getSize();

            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = element;
        if (back <= queue.length) {
            back++;
        } else {
            back = 0;
        }
    }

    public T remove() {
        if (getSize() == 0) {
            throw new NoSuchElementException();
        }

        T element = queue[front];
        front++;
        if (getSize() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }
        return element;
    }

    public int getSize() {
        if (front <= back) {
            return (back - front);
        } else {
            return (back - front + queue.length);
        }
    }

    public void display() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String a[]) {
        CircularQueueImpl queue = new CircularQueueImpl(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.display();
        System.out.println("Remove: "+queue.remove());
        System.out.println("Remove: "+queue.remove());
        System.out.println("Remove: "+queue.remove());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.display();
    }
}

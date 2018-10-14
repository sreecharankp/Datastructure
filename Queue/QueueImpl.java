public class QueueImpl<T> {
    private int capacity;
    private T[] queueArray;
    private int currentSize = 0;
    private int front = 0;
    private int rear = -1;

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        this.queueArray = (T[]) new Object[this.capacity];
    }

    public void enqueue(T element) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + element);
        } else {
            rear++;
            if (rear == capacity - 1) {
                rear = 0;
            }
            queueArray[rear] = element;
            currentSize++;
            System.out.println("Element " + element + " is pushed to Queue !");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            front++;
            if (front == capacity - 1) {
                System.out.println("Pop operation done ! removed: " + queueArray[front - 1]);
                front = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArray[front - 1]);
            }
            currentSize--;
        }
    }

    private boolean isQueueEmpty() {
        return (currentSize == 0);
    }

    private boolean isQueueFull() {
        return (currentSize == capacity);
    }

    public static void main(String a[]) {

        QueueImpl queue = new QueueImpl(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}

public class DequeDblLinkedListImpl<T> {

    public class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<T> front;
    Node<T> rear;

    public void insertFront(T element) {
        Node node = new Node(element, front, null);
        System.out.println("adding at front: " + element);
        if (front != null) {
            front.prev = node;
        }
        if (front == null) {
            rear = node;
        }
        front = node;
    }

    public void insertRear(T element) {
        Node node = new Node(element, null, rear);
        System.out.println("adding at rear: " + element);
        if (rear != null) {
            rear.next = node;
        }
        if (rear == null) {
            front = node;
        }
        rear = node;
    }

    public void removeFront() {
        if (front == null) {
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        Node temp = front.next;
        if (temp != null) {
            temp.prev = null;
        }
        if (temp == null) {
            rear = null;
        }
        System.out.println("removed from front: " + front.value);
        front = temp;
    }

    public void removeRear() {
        if (rear == null) {
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        Node temp = rear.prev;
        if (rear != null) {
            temp.next = null;
        }
        if (rear == null) {
            front = null;
        }
        System.out.println("removed from rear: " + rear.value);
        rear = temp;
    }

    public static void main(String a[]) {
        DequeDblLinkedListImpl<Integer> deque = new DequeDblLinkedListImpl<Integer>();
        deque.insertFront(34);
        deque.insertFront(67);
        deque.insertFront(29);
        deque.insertFront(765);
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
        deque.insertRear(43);
        deque.insertRear(83);
        deque.insertRear(84);
        deque.insertRear(546);
        deque.insertRear(356);
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeRear();
        deque.removeFront();
        deque.removeFront();
        deque.removeFront();
    }
}

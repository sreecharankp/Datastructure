import java.util.NoSuchElementException;

public class StackUsingLinkedlist<T> {

    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<T> head;
    Node<T> tail;
    int size = 0;

    public void push(T element) {
        Node<T> temp = new Node<T>(element, head, null);

        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        if (tail == null) {
            tail = temp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void pop() {
        if (size == 0) throw new NoSuchElementException();
        Node<T> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + temp.value);
    }

    public T peek() {
        return head.value;
    }

    public void traverse() {
        System.out.println("iterating forward..");
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void main(String a[]) {
        StackUsingLinkedlist<Integer> dll = new StackUsingLinkedlist<Integer>();
        dll.push(10);
        dll.push(34);
        dll.traverse();
        dll.pop();
        dll.traverse();
    }
}

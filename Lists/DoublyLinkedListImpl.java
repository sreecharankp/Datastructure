import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<T> {

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
    int size;

    public DoublyLinkedListImpl() {
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T element) {
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

    public void addLast(T element) {

        Node<T> temp = new Node<T>(element, null, tail);

        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if (head == null) {
            head = temp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node<T> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + temp.value);
    }

    public void removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node<T> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + temp.value);
    }

    public void iterateForward() {
        System.out.println("iterating forward..");
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void iterateBackward() {
        System.out.println("iterating backword..");
        Node<T> temp = tail;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.prev;
        }
    }

    public static void main(String a[]) {

        DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl<Integer>();
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addLast(56);
        dll.addLast(364);
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
    }
}

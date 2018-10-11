public class SinglyLinkedListImpl<T> {

    public class Node<T> implements Comparable<T> {

        T value;
        Node<T> nextRef;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node<T> nextRef) {
            this.nextRef = nextRef;
        }

        @Override
        public int compareTo(T value) {
            if (this.value == value) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    Node<T> head;
    Node<T> tail;

    public void add(T element) {

        Node<T> nd = new Node();
        nd.setValue(element);
        System.out.println("Adding: " + element);

        if (head == null) {
            head = nd;
            tail = nd;
        } else {
            tail.setNextRef(nd);
            tail = nd;
        }
    }

    public void addAfter(T element, T after) {

        Node<T> tmp = head;
        Node<T> refNode = null;

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.compareTo(after) == 0) {
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }

        if (refNode != null) {
            Node<T> nd = new Node();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if (tmp.getNextRef() == null) {
                tail = nd;
            }
            tmp.setNextRef(nd);
        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void deleteFront() {
        if (head == null) {
            System.out.println("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if (head == null) {
            tail = null;
        }
        System.out.println("Deleted: " + tmp.getValue());
    }

    public void deleteAfter(T after) {
        Node<T> tmp = head;
        Node<T> refNode = null;

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.compareTo(after) == 0) {
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }

        if (refNode != null) {
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if (refNode.getNextRef() == null) {
                tail = refNode;
            }
            System.out.println("Deleted: " + tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }

    public void traverse() {

        System.out.println("Traversing to all nodes..");
        Node<T> tmp = head;
        while (true) {
            if (tmp == null) {
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }

    public static void main(String a[]) {
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.addAfter(76, 54);
        sl.deleteFront();
        sl.deleteAfter(76);
        sl.traverse();

    }
}
import java.util.*;

public class DoubleEndedQueueImpl<T> {

    private List<T> deque = new ArrayList();

    public void insertFront(T element) {
        System.out.println("adding at front: " + element);
        deque.add(0, element);
        System.out.println(deque);
    }

    public void insertRear(T element) {
        System.out.println("adding at Rear: " + element);
        deque.add(element);
        System.out.println(deque);
    }

    public void removeFront() {
        if (deque.isEmpty()) {
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        T element = deque.remove(0);
        System.out.println("Removing at front: " + element);
        System.out.println(deque);
    }

    public void removeRear() {
        if(deque.isEmpty()){
            System.out.println("Deque underflow!! unable to remove.");
            return;
        }
        T element = deque.remove(deque.size() - 1);
        System.out.println("Removing at front: " + element);
        System.out.println(deque);
    }

    public void peakFront() {
        T element = deque.get(0);
        System.out.println("peakFront : " + element);
    }

    public void peakRear() {
        T element = deque.get(deque.size() - 1);
        System.out.println("peakRear : " + element);
    }

    public static void main(String a[]) {

        DoubleEndedQueueImpl deq = new DoubleEndedQueueImpl();
        deq.insertFront(34);
        deq.insertRear(45);
        deq.removeFront();
        deq.removeFront();
        deq.removeFront();
        deq.insertFront(21);
        deq.insertFront(98);
        deq.insertRear(5);
        deq.insertFront(43);
        deq.removeRear();
    }
}

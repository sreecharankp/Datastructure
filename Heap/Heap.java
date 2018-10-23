public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int delete(int index) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Heap is Empty");
        }

        int parent = getParent(index);
        int deleatedValue = heap[index];

        heap[index] = heap[size - 1];
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapFromBelow(index, size - 1);
        } else {
            fixHeapFromAbove(index);
        }
        size--;
        return deleatedValue;
    }

    private void fixHeapFromBelow(int index, int lastHeapIndex) {

        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    private int getChild(int index, boolean isLeft) {
        return (2 * index) + (isLeft ? 1 : 2);
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;

        fixHeapFromAbove(size);
        size++;
    }

    private void fixHeapFromAbove(int index) {
        int newValue = heap[index];

        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    private int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            if (heap[i] != 0) {
                System.out.print(heap[i] + ", ");
            }
        }
    }

    private void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;

            fixHeapFromBelow(0, lastHeapIndex - i - 1);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(1);

        System.out.println();
        heap.printHeap();

        System.out.println();
        System.out.println(heap.peek());

        heap.sort();

        System.out.println();
        heap.printHeap();
    }
}

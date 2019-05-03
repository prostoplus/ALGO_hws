import java.util.Arrays;

public class Deque {

    private int[] array;
    private int size;
    private int start;
    private int end;
    private int capacity;

    public Deque(int size) {
        this.size = size;
        array = new int[size];
        capacity = 0;
        start = 0;
        end = -1;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insertLeft(int i) {
        if (isFull()) throw new FullDeque();
        if (--start < 0) {
            start = size - 1;
        }
        array[start] = i;
        capacity++;
    }

    public int removeLeft() {
        if (++start > size - 1)
            start = 0;
        capacity--;
        return array[start - 1];
    }

    public void insertRight(int i) {
        if (isFull()) throw new FullDeque();
        if (++end > size){
            end = 0;
        }
        array[end - 1] = i;
        capacity++;
    }

    public int removeRight() {
        if (--end < 0) end = size - 1;
        capacity--;
        return array[end];
    }

    @Override
    public String toString() {
        return "Deque{" + "array=" + Arrays.toString(array) + '}';
    }
}
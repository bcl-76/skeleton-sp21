package deque;

public class ArrayDeque<T> {

    private int size;
    private T[] array;
    private int front;
    private int last;

    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[8];
        front = 0;
        last = 0;
    }

    public void resize(int length){
        T[] newarray = (T[]) new Object[length];
        for(int i = 0;i < size; i++){
            newarray[i] = array[i];
        }
        front = 0;
        last = size;
        array = newarray;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }

    }
}

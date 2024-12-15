package deque;

import jh61b.junit.In;
import net.sf.saxon.functions.ConstantFunction;

public class LinkedListDeque<T> {

    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(T i, IntNode n,IntNode p){
            item = i;
            next = n;
            prev = p;
        }
    }

    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item){
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(item,sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> t = new LinkedListDeque<>();
        LinkedListDeque<Integer> r = new LinkedListDeque<>(6);
        r.addFirst(3);
        r.addLast(4);
        r.addLast(5);
        r.addLast(6);
        r.printDeque();
        System.out.print(r.get(1));
    }

    /*Adds an item of type T to the front of the deque.
    You can assume that item is never null*/
    public void addFirst(T item){
        IntNode newNode = new IntNode(item,sentinel.next,sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /*Adds an item of type T to the back of the deque.
    You can assume that item is never null.*/
    public void addLast(T item){
        IntNode newNode = new IntNode(item,sentinel,sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /*Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(sentinel.next.item == null){
            return null;
        }
        size -= 1;
        T x = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return x;
    }

    public T removeLast(){
        if(sentinel.prev.item == null){
            return null;
        }
        size -= 1;
        T x = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return x;
    }

    public T get(int index){
        if(index > size - 1){
            return null;
        }
        int i = 0;
        IntNode p = sentinel;
        while (i <= index){
            i += 1;
            p = p.next;
        }
        return p.item;
    }

    private T getRecursive(IntNode p,int index){
        if(index == size){
            return p.item;
        }
        return getRecursive(p.next,index-1);
    }

    public T getRecursive(int index){
        IntNode p = sentinel.next;
        if (index < 0 || index >= size){
            return null;
        }
        return getRecursive(p,index);
    }
}

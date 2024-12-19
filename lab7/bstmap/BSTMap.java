package bstmap;

import java.util.Iterator;
import java.util.Set;
import java.util.Set;

public class BSTMap<K extends Comparable,V> implements Map61B<K,V>{
    private Node root;

    private class Node{
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap(){}

   private int size(Node x){
        if (x == null){
            return 0;
        }else return x.size;
   }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public void clear() {
        root = null;
    }

    private V get(Node x,K key){
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.right,key);
        else if (cmp < 0) return get(x.left,key);
        else            return x.val;
    }

    @Override
    public V get(K key) {
        return get(root,key);
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private Node put(Node x,K key,V val){
        if(x == null)   throw new IllegalArgumentException("calls put() with a null key");
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            x.val = val;
        } else if (cmp < 0) {
            x.left = put(x.left,key,val);
        }else {
            x.right = put(x.right,key,val);
        }
        x.size = 1 + size(x.right) + size(x.left);
        return x;
    }

    @Override
    public void put(K key, V value) {
        root = put(root,key,value);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }
}

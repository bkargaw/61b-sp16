package lab8;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by brukargaw on 6/20/17.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private static class BST<K extends Comparable<K>,V>{
        K key;
        V value;
        BST <K,V> left = null;
        BST<K,V> right = null;
        public BST(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    BST<K,V> root;
    int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    /** Removes all of the mappings from this map. */
    public void clear(){
        root = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        if (root == null) return false;
        return containsKey(root, key);
    }

    private boolean containsKey(BST node, K key){
        if (node == null) return false;
        if (node.key.compareTo(key) == 0) return true;
        return (containsKey(node.right, key) || containsKey(node.left, key));
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        if (root == null) return null;
        return get(root, key);
    }

    private V get(BST node,K key){
        if (node == null) return null;
        switch(node.key.compareTo(key)) {
            case -1 :
                return  get(node.right,key);
            case 1 :
                return  get(node.left,key);
            default :
                return (V) node.value;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){

        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        BST<K,V> node =  new BST<>(key, value);
        if (root == null){
            root = node;
        }else{
            put(root,node);
        }
        size++;
    }

    private void put(BST parent, BST child){
        if (parent == null) parent = child;
        if (0 < parent.key.compareTo(child.key)){
            put(parent.right,child);
        }else{
            put(parent.left,child);
        }

    }



    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        throw new UnsupportedOperationException("operation not supported");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){

        return null;
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value){
        throw new UnsupportedOperationException("operation not supported");
    }

    public Iterator<K> iterator(){
        throw new UnsupportedOperationException("operation not supported");
    }
}

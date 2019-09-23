package lesson1;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exercise3<K, V> {

    private K key;
    private V value;

    public Exercise3(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Exercise3<String, Integer> ex1 = new Exercise3<>("Mike", 29);
        System.out.println(ex1.getKey());
        System.out.println(ex1.getValue());
        TreeMap<String, TreeMap<String, TreeSet<Integer>>> lol = new TreeMap<>();

    }
}

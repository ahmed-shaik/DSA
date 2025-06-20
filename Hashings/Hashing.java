package Hashings;

import java.util.*;

public class Hashing {
    public static void majorityElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = arr.length;
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > n / 3) {
                System.out.println("Majority Element: " + num);
                return;
            }
        }
        System.out.println("No Majority Element");
    }

    public static void main(String[] args) {
        // Types of Hashing in java
        // 1. Map - hashMap, linkedHashMap, treeMap
        // - hashMap is used for fast retrieval of data using key-value pairs.
        // - linkedHashMap maintains the insertion order of elements.
        // - treeMap is used for sorted key-value pairs, it sorts the keys in natural
        // order or by a custom comparator.
        // 2. Set - hashSet, linkedHashSet, treeSet
        // - hashSet is used to store unique elements without any particular order.
        // - linkedHashSet maintains the insertion order of elements.
        // - treeSet is used for sorted unique elements, it sorts the elements in
        // natural order or by a custom comparator.

        // insert, // delete, search, update operations are performed in O(1) time

        // put(key, value) - O(1)
        // get(key) - O(1)
        // containsKey(key) - O(1)
        // remove(key) - O(1)
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("one", 1);
        // hm.put("two", 2);
        // hm.put("three", 3);
        // System.out.println("HashMap: " + hm);
        // // get value by key
        // System.out.println("Value for key 'two': " + hm.get("two"));
        // // check if key exists
        // System.out.println("Contains key 'three': " + hm.containsKey("three"));
        // // remove key-value pair
        // System.out.println(hm.remove("one"));
        // System.out.println("HashMap after removing key 'one': " + hm);
        // // size of the HashMap
        // System.out.println("Size of HashMap: " + hm.size());
        // // isempty check
        // System.out.println("Is HashMap empty? " + hm.isEmpty());
        // // empty the HashMap
        // hm.clear();

        // iteration over HashMap

        // Set<String> keys = hm.keySet();
        // for (String key : keys) {
        // System.out.println("Key: " + key + ", Value: " + hm.get(key));
        // }

        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // // LinkedHashMap maintains the insertion order of elements
        // lhm.put("India", 100);
        // lhm.put("USA", 200);
        // lhm.put("China", 300);
        // System.out.println("LinkedHashMap: " + lhm);

        // TreeMap<String, Integer> tm = new TreeMap<>();
        // keys are sorted in natural order
        // O(log n) time complexity for put, get, containsKey, remove operations
        // tm.put("India", 100);
        // tm.put("USA", 200);
        // tm.put("China", 300);
        // System.out.println("TreeMap: " + tm);
    }
}
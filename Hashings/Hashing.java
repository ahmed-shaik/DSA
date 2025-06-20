package Hashings;

import java.util.*;

public class Hashing {
    public static void majorityElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) > arr.length / 3) {
                System.out.println("Majority Element: " + key);
                return;
            }
        }
        System.out.println("No Majority Element");
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (hm.get(curr) == null) {
                return false;
            } else {
                if (hm.get(curr) == 1) {
                    hm.remove(curr);
                } else {
                    hm.put(curr, hm.get(curr) - 1);
                }
            }
        }
        return hm.isEmpty();
    }

    public static int countDistinctElements(int[] arr) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : arr) {
            distinctElements.add(num);
        }
        return distinctElements.size();
    }

    public static void unionAndIntersection(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int num : arr1) {
            unionSet.add(num);
            intersectionSet.add(num);
        }
        int count = 0;
        for (int num : arr2) {
            unionSet.add(num);
            if (intersectionSet.contains(num)) {
                count++;
                intersectionSet.remove(num);
            }
        }

        System.out.println("Union: " + unionSet.size());
        System.out.println("Intersection: " + count);

    }

    public static int largestSubarrayWith0Sum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
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

        // anagram check
        // String s1 = "listen";
        // String s2 = "silent";
        // System.out.println(isAnagram(s1, s2));

        // HashSet
        // no duplicate elements, unordered collection, null values allowed
        // HashSet<String> hs = new HashSet<>();
        // add - O(1)
        // contains - O(1)
        // remove - O(1)
        // HashSet<Integer> hs = new HashSet<>();
        // hs.add(1);
        // hs.add(3);
        // hs.add(3);
        // hs.add(4);
        // hs.add(4);
        // System.out.println("HashSet: " + hs);
        // // contains
        // if (hs.contains(3)) {
        // System.out.println("HashSet contains 3");
        // } else {
        // System.out.println("HashSet does not contain 3");
        // }
        // // remove
        // hs.remove(3);
        // System.out.println("HashSet after removing 3: " + hs.contains(3));
        // System.out.println("HashSet after removing 3: " + hs);
        // // size
        // System.out.println("Size of HashSet: " + hs.size());
        // // isEmpty
        // System.out.println("Is HashSet empty? " + hs.isEmpty());
        // // clear
        // hs.clear();

        // Iteration on HashSet
        // Iterator it = hs.iterator();
        // while (it.hasNext()) {
        // System.out.println("Element: " + it.next());
        // }

        // for (Integer num : hs) {
        // System.out.println("Element using for-each: " + num);
        // }
        // LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        // LinkedHashSet maintains the insertion order of elements
        // add - O(1)
        // contains - O(1)
        // remove - O(1)
        // lhs.add(1);
        // lhs.add(2);
        // lhs.add(3);
        // lhs.add(12);
        // lhs.add(8);
        // lhs.add(1);
        // System.out.println("LinkedHashSet: " + lhs);

        // TreeSet
        // TreeSet stores unique elements in sorted order, null values not allowed
        // add - O(log n)
        // contains - O(log n)
        // remove - O(log n)
        // TreeSet<Integer> ts = new TreeSet<>();
        // ts.add(5);
        // ts.add(1);
        // ts.add(3);
        // ts.add(2);
        // ts.add(4);
        // System.out.println("TreeSet: " + ts);

        int[] arr = { 3, -2, 3, 1, -11, 2, -2, 2 };
        // System.out.println(countDistinctElements(arr));

        // int arr1[] = { 1, 2, 3, 4, 5 };
        // int arr2[] = { 4, 5, 6, 7, 8 };
        // unionAndIntersection(arr1, arr2);

        System.out.println(largestSubarrayWith0Sum(arr));
    }
}
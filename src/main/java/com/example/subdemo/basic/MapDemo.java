package com.example.subdemo.basic;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {

    public static void main(String[] args) throws Exception {

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "a");
        linkedHashMap.put("b", "b");
        Entry<String, String> head = getHead(linkedHashMap);
        System.out.println(head.getKey());

        Entry<String, String> tail = getTail(linkedHashMap);
        System.out.println(tail.getKey());

        Entry<String, String> tail2 = getTailByReflection(linkedHashMap);
        System.out.println(tail2.getKey());
    }

    //O(1)
    public static <K, V> Entry<K, V> getHead(Map<K, V> map) {
        return map.entrySet().iterator().next();
    }

    //O(n)
    public static <K, V> Entry<K, V> getTail(Map<K, V> map) {
        Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
        Entry<K, V> tail = null;
        while (iterator.hasNext()) {
            tail = iterator.next();
        }
        return tail;
    }

    //O(1)
    public static <K, V> Entry<K, V> getTailByReflection(Map<K, V> map)
            throws NoSuchFieldException, IllegalAccessException {
        Field tail = map.getClass().getDeclaredField("tail");
        tail.setAccessible(true);
        return (Entry<K, V>) tail.get(map);
    }

}

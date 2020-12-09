package com.zjutkz.leetcode.android.lru;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final int DEFAULT_MAX_THRESHOLD = 10;

    private int maxThreshold;

    public LinkedHashMapLRUCache() {
        try {
            modifyAccessOrder();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        maxThreshold = DEFAULT_MAX_THRESHOLD;
    }

    private void modifyAccessOrder() throws NoSuchFieldException, IllegalAccessException {
        Class<?> clz = LinkedHashMap.class;
        Field field = clz.getDeclaredField("accessOrder");
        field.setAccessible(true);
        field.set(this, true);
    }

    public LinkedHashMapLRUCache(int maxThreshold) {
        try {
            modifyAccessOrder();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.maxThreshold = maxThreshold;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxThreshold;
    }
}

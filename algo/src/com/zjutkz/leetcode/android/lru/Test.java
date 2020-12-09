package com.zjutkz.leetcode.android.lru;

//https://my.oschina.net/zjllovecode/blog/1634410
//https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/lru-suan-fa
public class Test {

    public static void main(String[] args) {
        //LinkedHashMapLRUCache<String,String> cache = new LinkedHashMapLRUCache<String,String>(3);
        LRUCache cache = new LRUCache(3);

        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");

        System.out.println(cache);
    }
}

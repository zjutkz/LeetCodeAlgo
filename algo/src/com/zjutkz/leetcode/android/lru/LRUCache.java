package com.zjutkz.leetcode.android.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static final int DEFAULT_MAX_THRESHOLD = 10;
    private Node head;
    private Node tail;

    private Map<String,Node> holder;

    private int maxThreshold;
    private int count;

    public LRUCache() {
        head = new Node("head", "");
        tail = new Node("tail", "");
        head.next = tail;
        tail.pre = head;

        holder = new HashMap<>();

        maxThreshold = DEFAULT_MAX_THRESHOLD;
    }

    public LRUCache(int maxThreshold) {
        head = new Node("head", "");
        tail = new Node("tail", "");
        head.next = tail;
        tail.pre = head;

        holder = new HashMap<>();

        this.maxThreshold = maxThreshold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = head.next;
        while (node != tail) {
            sb.append("key: ").append(node.key).append(", value: ").append(node.value).append(", ");
            node = node.next;
        }

        return sb.toString();
    }

    public boolean contains(String key) {
        Node node = holder.get(key);
        moveToHead(node);

        return node != null;
    }

    public void put(String key, String value) {
        Node node = null;
        if (holder.containsKey(key)) {
            node = holder.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            holder.put(key, node);
            addToHead(node);
        }

        if(count > maxThreshold) {
            popTail();
        }
    }

    public String get(String key) {
        if(!holder.containsKey(key)) {
            return "";
        }

        Node node = holder.get(key);
        moveToHead(node);

        return node.value;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        --count;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;

        ++count;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void popTail() {
        Node node = tail.pre;
        removeNode(node);
    }

    private static class Node {

        public String key;
        public String value;
        public Node pre;
        public Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

/* Ref: https://www.youtube.com/watch?v=xDEuM5qa0zg */

import java.util.*;

class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev, next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

class LRUCache {
    int capacity;
    Node<Integer, Integer> head, tail;
    HashMap<Integer, Node<Integer, Integer>> map;
    int count = 0;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node<Integer, Integer>(0, 0);
        this.tail = new Node<Integer, Integer>(0, 0);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        this.map = new HashMap<>();

    }

    public void addToHead(Node<Integer, Integer> node) {

        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;

    }

    public void removeNode(Node<Integer, Integer> node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);

            removeNode(node);
            addToHead(node);

            return node.value;
        } else
            return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(1, 5);
        cache.set(4, 5);
        cache.set(6, 7);
        System.out.println(cache.get(4));
        cache.set(1, 2);
        System.out.println(cache.get(3));
    }
}

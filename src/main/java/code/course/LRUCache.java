package code.course;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@SuppressWarnings("unused")
class Data<KEY, D> {
    final KEY key;
    final D data;
    Data next;
    Data prev;

    Data(KEY key, D data) {
        this.key = key;
        this.data = data;
    }

    public Data getNext() {
        return next;
    }

    public void setNext(Data next) {
        this.next = next;
    }

    public Data getPrev() {
        return prev;
    }

    public void setPrev(Data prev) {
        this.prev = prev;
    }

    public KEY getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Data{" +
                "key=" + key +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data<?, ?> data = (Data<?, ?>) o;
        return Objects.equals(key, data.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

@SuppressWarnings("unused")
public class LRUCache<KEY, D> {

    final private ReadWriteLock lock = new ReentrantReadWriteLock();
    final private Lock writeLock = lock.writeLock();
    final private Lock readLock = lock.readLock();

    private int capacity = 3;
    private volatile int index = 0;

    private Map<KEY, Data> map = new ConcurrentHashMap<>(3);
    private Data head;
    private Data<KEY, D> tail;

    LRUCache(final int capacity) {
        this.capacity = capacity;
        lock.writeLock();
    }

    public void remove(Data data) {
        try {
            writeLock.lock();
            if (capacity > index) return;

            if (data == null) return;
            if (data == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Data nextElement = data.next;
                Data prevElement = data.prev;
                if (nextElement != null) {
                    prevElement = nextElement.prev;
                }
                if (prevElement != null) {
                    prevElement.next = nextElement;
                }
            }
            map.remove(data.key);
            index--;
        } finally {
            writeLock.unlock();
        }
    }

    private void setHead(Data<KEY, D> element) {
        if (element == null) {
            return;
        }
        if (head == null) {
            head = element;
            tail = head;
        } else {
            element.next = head;
            head.prev = element;
            element.prev = null;
            head = element;
        }
        map.putIfAbsent(element.key, element);
        index++;
    }

    public Data get(KEY key) {
        try {
            writeLock.lock();
            Data element;
            if (map.get(key) != null) {
                element = map.get(key);
                remove(element);
            } else {
                System.out.println("key [" + key + "] missing..");
                element = null;
            }

            setHead(element);
            return element;
        } finally {
            writeLock.unlock();
        }
    }

    public void put(KEY key, Data data) {
        try {
            writeLock.lock();
            if (capacity <= index) {
                remove(tail);
            }
            if (map.get(key) != null) {
                System.out.println("already present... " + data);
            } else {
                setHead(data);
            }
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        Data<Integer, String> d1 = new Data(1, "one");
        Data<Integer, String> d2 = new Data(2, "two");
        Data<Integer, String> d3 = new Data(3, "three");
        Data<Integer, String> d4 = new Data(4, "four");
        Data<Integer, String> d5 = new Data(5, "five");
        Data<Integer, String> d6 = new Data(6, "six");
        cache.put(1, d1);
        cache.put(2, d2);
        cache.put(3, d3);
        cache.put(4, d4);
        System.out.println(cache.map);
        cache.get(2);
        cache.get(2);
        cache.put(1, d1);
        cache.put(5, d5);
        cache.put(6, d6);
        cache.remove(d6);
        System.out.println(cache.map);
    }


}

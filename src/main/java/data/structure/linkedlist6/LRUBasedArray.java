package data.structure.linkedlist6;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 */
public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private T[] value;

    private int count;

    private int capacity;

    private Map<T, Integer> holder;

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[]) new Object[capacity];
        this.holder = new HashMap<>(capacity);
    }

    /**
     * 模拟访问某个值
     *
     * @param obj
     */
    public void offer(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("缓存不支持null");
        }

        Integer index = holder.get(obj);
        if (index == null) {
            if (isFull()) {
                removeAndCache(obj);
            } else {
                cache(obj,count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     * @param obj
     */
    public void removeAndCache(T obj) {
        T key = value[--count];
        holder.remove(key);
        cache(obj,count);
    }

    /**
     * 缓存数据到头部，但要先右移
     * @param obj
     * @param end 数组右移的边界
     */
    public void cache(T obj,int end) {
        rightShift(end);
        value[0] = obj;
        holder.put(obj, 0);
        count++;
    }

    /**
     * 若缓存中有指定的值，则更新位置
     * @param end
     */
    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);

    }

    /**
     * end左边的数据统一右移一位
     * @param end
     */
    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }
}

package com.course.line.array;

/**
 * @author freedoow
 */
public class ArrayList<E> {
    private E[] data;
    private int capacity;
    private int size;

    public ArrayList(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public ArrayList() {
        this(15);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * 指定位置插入元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,  require index > 0 && index < size");
        }

        if (size == data.length) {
            resize(capacity * 2);
        }

        // 最后一个到index 向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    private void resize(int newCapacity) {
        //创建一个 newCapacity容量的数组
        E[] newDate = (E[]) new Object[newCapacity];
        // 拷贝
        for (int i = 0; i < size; i++) {
            newDate[i] = data[i];
        }
        //赋值
        data = newDate;
        //重新赋值
        capacity = newCapacity;
    }

    /**
     * 头插入
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 尾插入
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取索引对应的值
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail,");
        }
        return data[index];
    }

    /**
     * 获取最后一个
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 找到一个元素的索引位置
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 是否包含某个元素
     *
     * @param target
     * @return
     */
    public boolean contains(E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 修改
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed,  require index > 0 && index < size");
        }
        data[index] = e;
    }

    /**
     * 移除第一个
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }


    /**
     * 移除最后一个
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定index元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed,  require index > 0 && index < size");
        }

        // size小于4分之1 缩容
        if (size == data.length / 4) {
            resize(data.length / 4);
        }

        E res = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return res;
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

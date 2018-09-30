package com.yongren.github;

import java.security.PublicKey;
import java.util.Arrays;

// A custom ArrList
public class YRArray {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 2;
    private transient Object[] data = null;

    // constructer
    public YRArray(int initCapacity) {
        if(initCapacity < 0) {
            throw new IllegalArgumentException("wrong initCapacity num: " + initCapacity);
        }else {
            this.data = new Object[initCapacity];
        }
    }
    public YRArray() {
        this(DEFAULT_CAPACITY);
    }

    public boolean add(Object elm) {
        checkIncrese(-1, null);
        data[size++] = elm;
        return true;
    }
    public boolean add(int idx, Object elm) {
        if(idx == size) {
            add(elm);
        }else if(checkInRanged(idx)){
            if(size < data.length) {
                System.arraycopy(data, size, data, size + 1, size - idx); // 就是 a[5] = 6; 这样赋值
                data[idx] = elm;
            }else {
                checkIncrese(idx, elm);
            }
            size++;
        }
        return true;
    }
    public void remove(int idx) {

    }
    public Object valueAtIndex(int idx) {
        checkInRanged(idx);
        return data[idx];
    }
    public int getSize() {
        return size;
    }

    private void checkIncrese(int idx, Object obj) {
        if(size >= data.length) {
            Object[] arr = new Object[size * 2];

            if(idx == -1 && obj == null) {

                System.arraycopy(this.data, 0, arr, 0, size);
                System.out.println(">> temp arr is : " + Arrays.toString(arr));

            }else {
                System.out.println("|-- orgArr is : " + Arrays.toString(data));
                System.arraycopy(this.data, idx, arr, idx + 1, size - idx);
                System.out.println("|-- after extent arr is : " + Arrays.toString(arr));
            }

            data = arr;
            arr = null;
        }
    }
    private boolean checkInRanged(int idx) {
        if(idx > this.size || idx < 0) {
            throw new IllegalArgumentException("idx (" + idx + ") out of range");
        }
        return true;
    }


}

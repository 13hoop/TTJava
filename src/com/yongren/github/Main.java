package com.yongren.github;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        hashTableTest001();

//        arryListTest();

//        lambdaTest();

        newCollectionTest();


    }

    static void newCollectionTest() {

        // ---- java8新特性之  不可变集合 ----
        // 不可变的
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7);
        List staticList = List.of(1,2,3,4,5,6);

//        list.add(555);
//        list.forEach(System.out::println);

//        staticList.add(777);
//        staticList.forEach(System.out::println);

    }

    static void lambdaTest() {
        // ---- java8新特性之 Lambda 表达式的2种形式 ----
        List<Integer> list = Arrays.asList(1, 2, 3,4,5,6,7);

        // old
        System.out.println(" -- old --");
        for (Integer x: list) {
            System.out.println(x);
        }

        // new 可使用 Arrow Style
        System.out.println(" -- Arrow style --");
        list.forEach(x -> System.out.println(x));
        // 特别的，可使用 :: 对普通方法进行转换
        System.out.println(" -- :: style --");
        list.forEach(System.out::println);

        System.out.println(" -- stream --");
        list.stream().map(x -> x * x).forEach(System.out::println);
    }

     static void hashTableTest001() {

        HashMap<String, Object> hm = new HashMap();
        System.out.println(hm.size());

        hm.put("001", "张三");
        hm.put("002", "李四");
        hm.put("003", "王麻子");
        hm.put("004", "王华");

        Iterator it = hm.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key: " + key + " Value: " + hm.get(key));
        }

        for(Map.Entry ety: hm.entrySet()) {
            System.out.println("key: " + ety.getKey() + " Value: " + ety.getValue());
        }
    }

    // auto copy & increase
    static void arryListTest() {

        // 数组的扩容
        int arr1[] = {0, 1, 2, 3, 4, 5};
        int arr2[] = {0, 11, 12, 13, 14, 15};
        int[] arr3 = new int[10];

        System.arraycopy(arr1,1, arr1, 2, 5 - 1);
        System.out.println(" arr1: " + Arrays.toString(arr1));

        System.arraycopy(arr1,0, arr3, 0, arr1.length);
        System.out.println("arr1 扩展2倍后的arr3: " + Arrays.toString(arr3));

        // 数据元素类型的扩展
        YRArray yrArr = new YRArray();
        yrArr.add(0);
        yrArr.add(1);
        yrArr.add(33);

    }
}

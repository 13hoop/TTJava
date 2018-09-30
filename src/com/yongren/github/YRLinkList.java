package com.yongren.github;

public class YRLinkList {

    private class Node<T> {
        T value;
        Node nextN;
    }


//
//    private int count = 0;
//    private static int DEFAULT_COUNT = 3;
//    public YRLinkList(int: count){
//
    public YRLinkList() {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();

        first.value = "to";
        second.value = "be";
        third.value = "not";

        first.nextN = second;
        second.nextN = third;

        /**
         *
         * insert At Header -- 这样写并不能完全容易理解
         * Node header = new Node();
         * header.value = "SKSPIE: ";
         * header.nextN = first;
         * 更好的方式应该是
         */
        Node oldHeader = first;
        Node header = new Node();
        header.value = "SKSPIE: ";
        header.nextN = oldHeader;

        // 从原表头删除最是容易：
        header = first.nextN;


    }


}

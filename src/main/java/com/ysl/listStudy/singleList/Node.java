package com.ysl.listStudy.singleList;


public class Node<T> {
    public T t;

    public Node next;

    public Node(T t) {
        this.t = t;
    }

    public Node(T t, Node next) {
        this.t = t;
        this.next = next;
    }
}

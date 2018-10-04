package com.ysl.listStudy.singleList;

/**
 * @author aarony
 * @Created 2018-10-04 14:20
 * @E-mail aarony@synnex.com
 */
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

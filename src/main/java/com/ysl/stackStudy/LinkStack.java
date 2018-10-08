package com.ysl.stackStudy;

import java.util.Stack;

/**
 * @author aarony
 * @Created 2018-10-08 10:09
 * @E-mail aarony@synnex.com
 */
public class LinkStack<T> {
    /**
     * 链式栈
     */
    class Node{
        private T data;

        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;

    private int size;

    /**
     * 入栈
     * @return
     */
    public void push(T element){
        top = new Node(element,top);
        size++;
    }

    /**
     * 空栈
     */
    public LinkStack() {
        top = null;
    }

    /**
     * 以指定元素创建链栈
     */
    public LinkStack(T t){
        top = new Node(t,null);
        size++;
    }

    /**
     * 出栈
     */
    public T pop(){
        Node oldTop = top;
        top = top.next;

        oldTop.next = null;
        size--;
        return oldTop.data;
    }

    /**
     * 查看栈顶元素
     *
     */
    public T peek(){
        return top.data;
    }

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        Integer ele = (Integer) stack.peek();
        System.out.println(stack);

    }



}

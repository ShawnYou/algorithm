package com.ysl.queueStudy;

/**
 * @author aarony
 * @Created 2018-10-10 16:56
 * @E-mail aarony@synnex.com
 */

/**
 * 循环队列的实现
 */
public class CircleQueue {
    private String[] elementData;

    private int n;

    private int front;

    private int tail;

    public CircleQueue(int capacity) {
        elementData = new String[capacity];

        n = capacity;
    }

    /**
     * 入队列
     */
    public Boolean enqueue(String item){
        if((tail+1)%n == front){
            //队列满了
            return false;
        }
        elementData[tail] = item;
        tail = (tail+1)%n;
        return true;
    }

    /**
     * 出队列
     */
    public String dequeue(){
        if(tail == front){
            //队列为空
            return null;
        }
        String item = elementData[front];
        front = (front+1)%n;
        return item;
    }
}

package com.ysl.queueStudy;



/**
 * 数组实现队列
 */
public class ArrayQueue {

    private String[] elementData;

    int front = 0;

    int tail = 0;

    int n = 0;
    /**
     * 申请一个大小为capacityd的队列
     */
    public ArrayQueue(int capacity){
        elementData = new String[capacity];
        n = capacity;
    }

    /**
     * 入队列
     * 当tail移动到最右边的时候，即使数组里面还有空闲空间，也无法往队列里面添加数据了
     *  方案：
     *  （1）每次出队都进行一次数据搬移， 时间复杂度 O(N)
     *  （2）出队时候不用搬移数据，当没有空余空间的时候，只需要在入队的时候 集中进行一次数据搬移。
     *
     *  采用方案2  方案2性能要高一些
     */
    public Boolean enqueue(String item){
        //尾指针指向最后
        if(tail == n){
            if(front == 0){
                //队列满了
                return false;
            }
            for (int i = front; i < tail ; i++) {
                elementData[i-front] = elementData[i];
            }
            tail = tail - front;
            front = 0;
        }
        elementData[tail] = item;
        tail++;
        return true;
    }

    /**
     * 出队列
     */
    public String dequeue(){
        //队列为空
        if(front == tail){
            System.out.println("队列为空");
            return null;
        }
        String tempItem = elementData[front];
        elementData[front] = null;
        front++;
        return tempItem;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");



        String item = queue.dequeue();

        String item1 = queue.dequeue();

        queue.enqueue("6");
        queue.enqueue("7");
        queue.enqueue("8");

        System.out.println(item);
    }

}

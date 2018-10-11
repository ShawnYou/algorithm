package com.ysl.queueStudy;



/**
 * @author aarony
 * @Created 2018-10-10 16:17
 * @E-mail aarony@synnex.com
 */


/**
 *  使用链表实现队列
 */
public class LinkQueue {

    class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node front = null;

    private Node tail = null;


    /**
     * 入队列
     */
    public Boolean enqueue(String item){
        if(tail == null){
            Node newNode = new Node(item,null);
            tail = newNode;
            front = newNode;
        }else {
            Node newNode = new Node(item,null);
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    /**
     * 出队列
     */
    public String dequeue(){
        if(front == null){
            return null;
        }
        String data = front.data;
        front = front.next;

        if(front == null){
            tail = null;
        }
        return data;
    }

    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.enqueue("11");
        queue.enqueue("22");
        queue.enqueue("33");
        queue.enqueue("44");

        String item = queue.dequeue();
        String item1 = queue.dequeue();
        String item2 = queue.dequeue();
        String item3 = queue.dequeue();
        System.out.println(item);
    }
}

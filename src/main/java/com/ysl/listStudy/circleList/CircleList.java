package com.ysl.listStudy.circleList;

/**
 * @author aarony
 * @Created 2018-10-04 14:58
 * @E-mail aarony@synnex.com
 */
public class CircleList {


    public Node head;

    public CircleList() {
        initList();
    }

    //初始化链表
    void initList(){
        head = new Node(null);
        head.next = head;
    }


    public void addNode(Node node){
        Node temp = head;
        while (temp.next!=head){
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    public void insertNodeByIndex(int index,Node node){
        if(index<1 || index>size()){
            System.out.println("位置有误");
            return;
        }
        Node temp = head;
        int length = 1;
        while (temp.next!=head){
            if(index == length++){
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(Object obj){
        Node temp = head;
        while (temp.next!=head){
            if(temp.next.t == obj){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public void deleteNodeByIndex(int index){
        if(index<1 || index>size()){
            System.out.println("位置有误");
            return;
        }
        Node temp = head;
        int length = 1;
        while (temp.next!=head){
            if(index == length++){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public int size(){
        int len = 0;
        Node temp = head;
        while (temp.next!=head){
            len++;
            temp = temp.next;
        }
        return len;
    }


    public static void main(String[] args) {
        CircleList circleList = new CircleList();
        circleList.addNode(new Node(1));
        circleList.addNode(new Node(2));

        circleList.insertNodeByIndex(2,new Node(4));

        //circleList.deleteNode(4);
        circleList.deleteNodeByIndex(2);
        System.out.println(circleList);
    }

}

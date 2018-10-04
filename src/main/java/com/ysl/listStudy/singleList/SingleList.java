package com.ysl.listStudy.singleList;

/**
 * @author aarony
 * @Created 2018-10-04 14:21
 * @E-mail aarony@synnex.com
 */
public class SingleList {
    /**
     * 单链表
     */
    public Node head;

    public int length(){
        int len = 0;
        Node temp = head;
        while (temp.next!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public SingleList() {
        initList();
    }

    void initList(){
        head = new Node(null);
        head.next = null;
    }

    //末尾添加节点
    public void addNode(Node node){
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        //最后一个节点 或者头节点， next指向新的节点
        temp.next = node;
    }

    /**
     * 在指定位置插入节点
     * 关键：找到需要插入位置的前一个节点
     * @param index（链表的位置）
     * @param node （插入的节点）
     */
    public void insertNodeByIndex(int index,Node node){
        //判断指定位置是否合法
        if(index<1||index>length()+1){
            System.out.println("位置不合法");
            return;
        }

        Node temp = head;
        int length = 1;
        while (temp.next!=null){
            //temp表示当前位置的前一个节点
            if(index == length++){
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 指定的位置删除节点
     * 关键：找到当前位置的前一个节点
     * @param index
     */
    public void deleteNodeByIndex(int index){
        //判断指定位置是否合法
        if(index<1||index>length()+1){
            System.out.println("位置不合法");
            return;
        }
        Node temp = head;
        int length = 1;
        while (temp.next!=null){
            if(index == length++){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addNode(new Node(1));
        singleList.addNode(new Node(2));
        singleList.addNode(new Node(3));
        singleList.addNode(new Node(4));
        singleList.addNode(new Node(5));
        singleList.addNode(new Node(6));

        singleList.insertNodeByIndex(3,new Node(11));

        singleList.deleteNodeByIndex(5);
        System.out.println(singleList);
    }
}

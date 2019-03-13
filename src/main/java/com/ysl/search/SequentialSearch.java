package com.ysl.search;

/**
 * Created by shawn_lin on 2018/7/8.
 */
public class SequentialSearch<String,Integer> {
    //基于无序链表的顺序查找来构造符号表
    private Node head;

    private class Node{
        private String key;
        private Integer value;
        private Node next;

        public Node(String key, Integer value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(String key,Integer value){
        for(Node node = head;node!=null;node = node.next){
            if(key.equals(node.key)){
                //命中
                node.value = value;
                return;
            }
        }
        //未命中,则创建新的节点作为头节点
        head = new Node(key,value,head);
    }

    //按照顺序搜索链表的键值
    public Integer get(String key){
        for(Node node = head;node!=null;node = node.next){
            if(key.equals(node.key)){
                //命中
                return node.value;
            }
        }
        //未命中
        return null;
    }

}

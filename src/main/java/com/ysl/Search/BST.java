package com.ysl.Search;

/**
 * Created by shawn_lin on 2018/7/10.
 */
public class BST<Key extends Comparable<Key>,Value> {
    /**
     * 二叉查找树
     *
     * 定义： 二叉树， 每个节点都含有一个Comparable的键，且含有的键值都大于左子树的任意节点的键值，小于右子树的任意节点的键值
     */


    /**
     * 特点：
     * （1）每个节点有且只有一个父节点 （根节点除外，根节点没有父节点）
     * （2）键之间有顺序之分以支持高效的查找
     *  (3) 每个节点都只有左右两个链接
     */
    private Node head;

    class Node{
        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int N;
        public Node(Key key,Value value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    //通过递归的方式实现 查找二叉树的实现
    public Node put(Node node,Key key,Value value){
        if(key==null||value==null){
            throw new IllegalArgumentException("key or value not empty");
        }
        if(node == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(node.key);
        if(cmp<0){
            node.left = put(node.left,key,value);
        }
        else if(cmp>0){
            node.right = put(node.right,key,value);
        }else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void put(Key key,Value value){
        put(head,key,value);
    }

    public int size(){
        return size(head);
    }

    public int size(Node node){
        if(node == null){
            return 0;
        }else {
            return node.N;
        }
    }

    private Value get(Node head,Key key){
        //在根节点的子树中查找key对应的值
        if(head == null){
            //二叉树为空
            return null;
        }
        int cmp = key.compareTo(head.key);
        if(cmp<0){
            return get(head.left,key);
        }else if(cmp>0){
            return get(head.right,key);
        }else {
            return head.value;
        }
    }

    public Value get(Key key){
        return get(head,key);
    }

    private void delete(Key key){
        //TODO 文档介绍
    }

    /**
     * 删除最小的键
     * (1)递归检索左子树，直到空链接
     * @param node
     */
    private void deleteMin(Node node){
        if(node == null){

        }
    }

    private void deleteMax(){

    }

    public Key min(){
        return min(head).key;
    }

    //获取最小的键
    private Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    //获取最大的键
    private Node max(Node node){
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }

    private Key max(){
        return max(head).key;
    }

    //向上取整
    private Key ceilling(Key key){
        return ceilling(head,key).key;
    }

    private Node ceilling(Node node,Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }
        if(cmp>0){
            return ceilling(node.right,key);
        }
        Node t = ceilling(node.left,key);
        if(t !=null){
            return t;
        }else {
            return node;
        }
    }

    //向下取整
    public Key floor(Key key){
        return floor(head,key).key;
    }

    //待优化
    private Node floor(Node node,Key key){
        //TODO 写技术文档
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }
        if(cmp < 0){
            floor(node.left,key);
        }
        Node t = floor(node.right,key);
        if(t != null){
            return t;
        }else {
            return node;
        }
    }

    /**
     * 查找排名为K的键（递归实现）即树中正好有K个键小于它
     * （1）左子树的节点数大于K，则在左子树里面寻找
     * （2）左子树的节点数小于K,则在右子树里面寻找
     * （3）左子树的节点数等于，则根节点就是要找的键
     *
     * @param k
     * @return
     */
    public Node select(Node node,int k){
        if(node == null){
            return null;
        }
        int leftCount = size(node.left);
        if(leftCount>k){
            return select(node.left,k);
        }else if(leftCount<k){
            return select(node.right,k-leftCount-1);
        }else {
            return node;
        }
    }

    /**
     * 给键排名
     * @param key
     * @return
     */
    public int rank(Node node,Key key){
        if(node == null){
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0 ){
            return rank(node.left,key);
        }else if(cmp > 0){
            return rank(node.right,key);
        }else {
            return size(node.left);
        }
    }

    public int rank(Key key){
        return rank(head,key);
    }
}

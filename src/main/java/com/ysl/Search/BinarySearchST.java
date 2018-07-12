package com.ysl.Search;


import com.ysl.util.IOUtil;
import java.util.Scanner;

/**
 * Created by shawn_lin on 2018/7/8.
 */
public class BinarySearchST<K extends Comparable<K>,V> {
    //默认的容量大小
    private static final int INIT_CAPACITY = 2;
    //有序数组的二分查找

    //存储key的数组
    private K[] keys;
    //存储value的数组
    private V[] values;
    //数组长度
    private int N;

    public BinarySearchST(){
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity){
        keys = (K[])new Comparable[capacity];
        values = (V[])new Object[capacity];
    }

    public int size(){
        return N;
    }

    //使用递归的方式实现二分查找算法
    public int rank1(K key, int start,int end){
        if(end<start){
            //keys里面的元素 都小于key
            return start;
        }
        int mid = start + (end-start)/2;
        int result = key.compareTo(keys[mid]);
        if(result<0){
            return rank1(key,start,mid-1);
        }else if(result>0){
            return rank1(key,mid+1,end);
        }else {
            return mid;
        }
    }
    //二分查找 （方式二）
    public int rank(K key){
        int start = 0;
        int end = N-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            int result = key.compareTo(keys[mid]);
            if(result<0){
                end = mid-1;
            }else if(result>0){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return start;
    }

    public V get(K key){
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i<N&&key.compareTo(keys[i])==0){
            return values[i];
        }else {
            return null;
        }
    }

    public void put(K key,V value){
        if(key == null){
            throw new IllegalArgumentException("put is null");
        }


        int i = rank(key);
        //查找键 找到键就更新值
        if(i<N&&keys[i].compareTo(key)==0){
            values[i] = value;
            return;
        }

        //键就在数组之中 但是没有找到对应的键
        for(int j = N;j>i;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public K min(){
        return keys[0];
    }

    public K max(){
        return keys[N-1];
    }

    public K select(int i){
        return keys[i];
    }

    public K ceiling(K key){
        int i = rank(key);
        return keys[i];
    }

    //向下取整
    public K floor(K key){
        return null;
    }

    public static void main(String[] args) {
        BinarySearchST<String,Integer> binarySearchST = new BinarySearchST<String,Integer>();
        Scanner scanner = IOUtil.readFile();
        for(int i = 0;scanner.hasNext();i++){
            String word = scanner.next();
            binarySearchST.put(word,i);
        }
        for(String s:binarySearchST.keys){
            System.out.println(s+":"+binarySearchST.get(s));
        }

    }

    public void resize(int capacity){
        K[] tempKeys = (K[])new Comparable[capacity];
        V[] tempValues = (V[])new Object[capacity];
        for(int i = 0;i<N;i++){
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        keys = tempKeys;
        values = tempValues;
    }




}

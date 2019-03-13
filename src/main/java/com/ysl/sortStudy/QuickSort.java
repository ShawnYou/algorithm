package com.ysl.sortStudy;

/**
 * @author aarony
 * @Created 2019-03-12 13:00
 * @E-mail aarony@synnex.com
 */

/**
 * 快速排序
 */

public class QuickSort implements Sort{
    @Override
    public int[] doSort(int[] arr) {
        quick(arr,0,arr.length-1);
        return arr;
    }

    @Override
    public int[] doSortPlus(int[] arr) {
        return new int[0];
    }

    private void quick(int[] data,int front,int end){
        if(front >= end){
            return;
        }

        int pivot = partition(data,front,end);
        quick(data,front,pivot-1);
        quick(data,pivot+1,end);
    }

    private int partition(int[] data,int front,int end){
        int pivot = data[end];
        int i = front;
        for (int j = i; j< end; j++) {
            if(data[j] < pivot){
                if(i == j){
                    i++;
                }else {
                    int temp = data[i];
                    data[i++] = data[j];
                    data[j] = temp;
                }
            }
        }

        int temp = data[i];
        data[i] = data[end];
        data[end] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] testData = new int[]{3,1,4,6,2,9,8,0,7,5};

        QuickSort quickSort = new QuickSort();
        quickSort.doSort(testData);

        System.out.println(testData);
    }

}

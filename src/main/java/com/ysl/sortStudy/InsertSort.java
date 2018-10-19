package com.ysl.sortStudy;



/**
 * 插入排序
 */
public class InsertSort implements Sort{

    @Override
    public int[] doSort(int[] arr) {
        if(arr.length<=1){
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i-1;
            for (;j>=0;j--){
                if(value < arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j] = value;
        }

        return arr;
    }

    @Override
    public int[] doSortPlus(int[] arr) {
        return new int[0];
    }
}

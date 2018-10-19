package com.ysl.sortStudy;

/**
 * 选择排序
 */
public class SelectSort implements Sort{

    @Override
    public int[] doSort(int[] arr) {
        if(arr.length <=1){
            return arr;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = minIndex+1; j < arr.length; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    @Override
    public int[] doSortPlus(int[] arr) {
        return new int[0];
    }
}

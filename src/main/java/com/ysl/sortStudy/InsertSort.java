package com.ysl.sortStudy;



/**
 * 插入排序
 */
public class InsertSort {
    public static int[] insertSort(int[] arr,int n){
        if(arr.length<=1){
            return arr;
        }

        for (int i = 1; i < n; i++) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2};

        int[] temp = insertSort(arr,6);


    }
}

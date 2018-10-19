package com.ysl.sortStudy;



/**
 * 冒泡排序
 */
public class BubbleSort implements Sort{
    /**
     * 普通版本
     * @param arr
     * @return
     */
    @Override
    public int[] doSort(int[] arr) {
        if(arr.length<=1){
            return null;
        }
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * 优化版本
     *
     * 设置标志位
     * 当没有数据交换的时候，跳出循环
     */
    @Override
    public int[] doSortPlus(int[] arr) {
        if(arr.length<=1){
            return null;
        }

        for(int i = 0;i<arr.length-1;i++){
            boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                return arr;
            }
        }
        return arr;
    }
}

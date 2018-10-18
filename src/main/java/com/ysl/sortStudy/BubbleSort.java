package com.ysl.sortStudy;



/**
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 普通版本
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
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
    public static int[] bubbleSortPlus(int[] intArr){
        if(intArr.length<=1){
            return null;
        }

        for(int i = 0;i<intArr.length-1;i++){
            boolean flag = false;
            for (int j = 0; j < intArr.length-i-1; j++) {
                if(intArr[j] > intArr[j+1]){
                    int temp = intArr[j+1];
                    intArr[j+1] = intArr[j];
                    intArr[j] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                return intArr;
            }
        }
        return intArr;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{3,5,4,2,1,6};
        //int[] arr = bubbleSort(intArr);
        int[] arr = bubbleSortPlus(intArr);
        System.out.println(arr);
    }
}

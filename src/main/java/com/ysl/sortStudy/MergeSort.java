package com.ysl.sortStudy;


/**
 * 归并排序
 * 时间复杂度：nlogn
 * 适合大规模的数据排序
 */

public class MergeSort implements Sort{
    @Override
    public int[] doSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
        return arr;
    }

    @Override
    public int[] doSortPlus(int[] arr) {
        return new int[0];
    }

    private void mergeSort(int[] data,int front,int end){
        if(front >= end){
            return;
        }

        int mid = (front+end)/2;
        mergeSort(data,front,mid);
        mergeSort(data,mid+1,end);

        merge(data,front,mid,end);
    }

    private void merge(int[] data,int front,int mid,int end){
        int[] temp = new int[end-front+1];
        int f = front;
        int m = mid+1;
        int k = 0;
        while (f <= mid && m <= end){
            if(data[f]<data[m]){
                temp[k++] = data[f++];
            }else {
                temp[k++] = data[m++];
            }
        }

        //判断哪个数组还有剩余
        int startIndex = f;
        int endIndex = mid;
        if(m<=end){
            startIndex = m;
            endIndex = end;
        }

        while (startIndex<=endIndex){
            temp[k++] = data[startIndex++];
        }

        //将临时数组 赋值给原数组
        for(int i =0;i<end-front+1;i++){
            data[front+i] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] testData = new int[]{3,1,4,6,2,9,8,0,7,5};
        MergeSort mergeSort1 = new MergeSort();
        mergeSort1.doSort(testData);

        System.out.println(testData);
    }
}

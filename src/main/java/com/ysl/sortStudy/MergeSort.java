package com.ysl.sortStudy;


/**
 * 归并排序
 * 时间复杂度：nlogn
 * 适合大规模的数据排序
 */

//TODO  need fix bug
public class MergeSort implements Sort{
    @Override
    public int[] doSort(int[] arr) {
        return mergeSortRecursion(arr,0,arr.length-1);
    }

    private static int[] mergeSortRecursion(int[] arr,int pre,int tail){
        //终止条件
        if(pre >= tail){
            return arr;
        }

        int mid = (pre+tail)/2;
        mergeSortRecursion(arr,0,mid);
        mergeSortRecursion(arr,mid+1,tail);

        //将最后逇两个数组 合并成一个数组
        return merge(arr,pre,mid,tail);
    }

    public static int[] merge(int[] arr,int pre,int mid,int tail){
        //申请一个和arr[pre...tail]大小的临时数组
        int[] temp = new int[tail-pre+1];
        int i = pre;
        int j = mid+1;
        int k  = 0;
        while (i<=mid && j<=tail){
            if(arr[i] > arr[j]){
                temp[k++] = arr[j++];
            }else {
                temp[k++] = arr[i++];
            }
        }

        //找到还有剩余的数组
        int start = i;
        int end = mid;
        if(j<=tail){
            start = j;
            end = tail;
        }

        //将数组剩余的元素放在临时数组
        while (start<=end){
            temp[k++] = arr[start++];
        }

        //将临时数组 拷贝回原数组
        for (int l = 0; l < tail - pre; l++) {
            arr[pre+i] = temp[i];
        }

        return arr;

    }

    @Override
    public int[] doSortPlus(int[] arr) {
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,9,3,5,7};
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.doSort(arr);
    }
}

package com.ysl.sortStudy;

/**
 * @author aarony
 * @Created 2019-03-12 15:21
 * @E-mail aarony@synnex.com
 */

/**
 * 线性排序：计数排序  时间复杂度O(n)
 */
public class CountingSort {
    private void countSort(int[] data,int n){
        if(n <= 1){
            return;
        }

        //查找数据范围
        int max = data[0];
        for (int i = 1; i < data.length-1; i++) {
            if(max<data[i]){
                max = data[i];
            }
        }

        //申请一个大小为max+1的数组，记录每个元素出现次数
        int[] c = new int[max+1];

        for (int i = 0; i < c.length-1; i++) {
            c[i] = 0;
        }

        //计算每个元素的出现次数
        for (int i = 0; i < data.length; i++) {
            c[data[i]]++;
        }

        //逐渐累加
        for(int i = 1;i<=max;i++){
            c[i] = c[i-1] + c[i];
        }

        //排序后的数组
        int[] ret = new int[n];

        for(int i = n-1; i>=0 ; i--){
            int count = c[data[i]];
            ret[count-1] = data[i];
            c[data[i]]--;
        }

        for (int i = 0; i < ret.length; i++) {
            data[i] = ret[i];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2,5,3,0,2,3,0,3,3,1,1,1};
        CountingSort countingSort = new CountingSort();
        countingSort.countSort(data,data.length);
        System.out.println(data);

    }
}

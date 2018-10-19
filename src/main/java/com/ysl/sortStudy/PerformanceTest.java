package com.ysl.sortStudy;


import java.util.Date;



public class PerformanceTest {
    public static void main(String[] args) {

        /**
         *  冒泡排序
         */
        BubbleSort bubbleSort = new BubbleSort();
        long bubule = calcPerformanceTime(bubbleSort);
        System.out.println("bubble time:"+bubule);

        /**
         * 插入排序
         */
        InsertSort insertSort = new InsertSort();
        long insert = calcPerformanceTime(insertSort);
        System.out.println("insert time:"+insert);
        /**
         * 选择排序
         */
        SelectSort selectSort = new SelectSort();
        long select = calcPerformanceTime(selectSort);
        System.out.println("select time:"+select);
    }

    private static long calcPerformanceTime(Sort sort){
        Date pre = new Date();
        long preTime = pre.getTime();
        for(int i = 0;i<100000;i++){
            int[] result = new int[200];
            for(int j = 0;j<200;j++){
                int item = (int)Math.random()*20;
                result[j] = item;
            }
            if(sort instanceof BubbleSort){
                sort.doSortPlus(result);
            }
            sort.doSort(result);
        }
        Date now = new Date();
        long nowTime = now.getTime();

        return nowTime-preTime;
    }
}

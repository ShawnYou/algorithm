package com.ysl.search;


/**
 * 关于二分查找的几个变形问题
 * （1）查找第一个值等于给定值的元素
 * （2）查找最后一个值等于给定值的元素
 * （3）查找第一个大于等于给定值的元素
 * （4）查找最后一个小于等于给定值的元素
 */
public class BinarySearchPlus {

    public int binarySearchFindFirstElement(int[] data,int n,int value){
        int low = 0;
        int high = n-1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if(data[mid] == value){
                if((mid == 0)||data[mid-1]!=value){
                    return mid;
                }else {
                    high = mid -1;
                }
            }else if(data[mid] < value){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }

        return -1;
    }

    public int binarySearchFindListElement(int[] data,int n,int value){
        int low = 0;
        int high = n-1;

        while (low <= high){
            int mid = low + ((high - low)>>1);

            if(data[mid] == value){
                if((mid == n-1)||data[mid+1]!=value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else if(data[mid] < value) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearchFindFirstLargerAndEqualsElement(int[] data, int n, int value) {
        int low = 0;
        int high = n-1;

        while (low <= high){
            int mid = low + ((high - low)>>1);

            if(data[mid] >= value){
                if((mid == 0)||data[mid-1]<value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearchFindLastLessAndEqualsElement(int[] data, int n, int value) {
        int low = 0;
        int high = n-1;

        while (low <= high){
            int mid = low + ((high - low)>>1);

            if(data[mid] <= value){
                if((mid == n-1)||(data[mid+1]>value)){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else {
                high = mid - 1;
            }

        }

        return -1;
    }
}

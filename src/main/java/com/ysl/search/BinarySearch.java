package com.ysl.search;


/**
 * 二分查找（简单版本）
 */
public class BinarySearch {
    private int search(int[] data,int target){
        int front = 0;
        int end = data.length-1;
        return binarySearch(data,target,front,end);
    }

    private int binarySearch(int[] data,int target,int low,int high){
        while (low <= high){
            int mid = low+((high-low)>>1);

            if(data[mid]<target){
                low = mid+1;
            }else if(data[mid] ==target){
                return mid;
            }else {
                high = mid -1;
            }
        }

        return -1;
    }

    private int binarySearchInternally(int[] data,int low,int high,int target){
        if(low > high){ return -1;}

        int mid = low + ((high-low)>>1);

        if(data[mid]<target){
            return binarySearchInternally(data,mid+1,high,target);
        }else if(data[mid] == target){
            return mid;
        }else {
            return binarySearch(data,low,mid-1,target);
        }
    }

    public static void main(String[] args) {
        int[] testData = new int[]{3,4,7,9,11,12,14,15};
        BinarySearch binarySearch = new BinarySearch();
        //int index = binarySearch.search(testData,17);

        int index = binarySearch.binarySearchInternally(testData,0,testData.length-1,17);
        System.out.println(index);
    }
}

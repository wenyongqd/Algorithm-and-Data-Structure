package BinaryTree;

import java.util.ArrayList;

public class binarySerach {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int result = binarySearch(arr, 0, arr.length -1,1234);
        System.out.println(result);
        int arr2[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList result2 = newbinarySearch(arr2, 0, arr2.length -1, 1000);
        System.out.println(result2);

    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal){

        /**
         * 二分查找思路分析：
         * 1. 首先确定该数组的中间下标 mid=（left+right）/2
         * 2. 然后让需要查找的数fingVal和arr[mid]比较
         * 2.1 findVal>arr[mid]，说明你要查找的数在mid的右边，因此需要递归的向右查找
         * 2.2 findVal<arr[mid]，说明你要查找的数在mid左边，因此需要递归向左查找
         * 2.3 findVal==arr[mid]，说明找到，就返回
         *
         * 什么时候我们需要结束递归
         * 1）找到就结束
         * 2）递归完整个数组，仍然没有找到findVal，也需要结束递归。当left>right就需要退出
         */
        //当left > right 时，说明递归整个数组，但是没有找到
        if(left > right) {
            return -1;
        }
        int mid = (left + right)/2; //中间下标
        int midVal = arr[mid]; //中间值

        if (findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal );
        } else if( findVal < midVal) { //向左递归
            return binarySearch(arr, left, mid -1, findVal);
        } else {
            return mid;
        }
    }
    //完成一个课后思考题目：
    /*
        课后思考题：（1，8，10，89，1000，1000，1234）当一个有序数组中
        有多个相同的数值时，如何将所有的数值都查找到，比如这里的1000
     */

    public static ArrayList<Integer> newbinarySearch(int[] arr, int left, int right, int findVal){

        //当left > right 时，说明递归整个数组，但是没有找到
        if(left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right)/2; //中间下标
        int midVal = arr[mid]; //中间值

        if (findVal > midVal) { //向右递归
            return newbinarySearch(arr, mid + 1, right, findVal );
        } else if( findVal < midVal) { //向左递归
            return newbinarySearch(arr, left, mid -1, findVal);
        } else {
            /**
             * 思路分析：
             * 1. 在找到mid索引位置，不要马上返回
             * 2. 向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
             * 3. 向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
             * 4. 将ArrayList返回
             */
            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;

            while (true) {
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }

                resIndexlist.add(arr[temp]);
                temp -= 1;
            }
            resIndexlist.add(arr[mid]);
            temp = mid + 1;

            while (true) {
                if(temp > arr.length -1 || arr[temp] != findVal) {
                    break;
                }

                resIndexlist.add(arr[temp]);
                temp += 1;

            }
            return resIndexlist;

        }
    }

}

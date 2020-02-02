package Search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println("index = " + index);
    }

    //编写插值查找算法
    //插值查找算法也要求数组是有序的
    /**
     *
     * @param arr
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //注意：
        //findVal < arr[0]和findVal > arr[arr.length]这两个条件必须有
        //否则我们得到的mid可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { //说明向左递归查找
            return insertValueSearch(arr, left, mid -1, findVal);
        } else {
            return mid;
        }
    }
}

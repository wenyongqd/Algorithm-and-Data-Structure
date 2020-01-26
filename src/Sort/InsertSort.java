package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);

    }

    //插入排序
    public static void insertSort(int[] arr) {
        //使用逐步推导的方式
        //第1轮 {101, 34, 119, 1} => {34, 101, 119, 1}

        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

        //给insertval找到插入的位置
        //说明
        //1. insertIndex >= 0 保证给InsertVal找插入位置, 不越界
        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3. 就需要将arr[insertIndex]后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //
            insertIndex--;
        }
        //当退出while循环时，说明插入的位置找到， insertIndex+1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第一轮操作后");
        System.out.println(Arrays.toString(arr));

        //第二轮
        insertVal = arr[2];
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex]; //
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;

        System.out.println("第二轮操作后");
        System.out.println(Arrays.toString(arr));

    }
}

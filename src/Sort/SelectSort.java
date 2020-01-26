package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr1 = {101, 34, 119, 1};
        selectSort(arr1);

        int[] arr = new int[80000];
        for (int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000); //生成一个[0, 80000]的数

        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是" + data1Str);

        selectSort(arr);

//        System.out.println("排序后的结果是:" + Arrays.toString(arr));
        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是" + data2Str);

    }


    //选择排序
    public static void selectSort(int[] arr) {
        //使用逐步推导的方式来讲解选择排序

        //在推导的过程中，我们发现了规律，因此可以使用一个for循环来解决
        //选择排序的时间复杂度仍然是O(n^2)
        //第一轮
        //原始的数组：101，34，119，1
        //第一轮排序：1，34，119，101
        //第1轮
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i; //假定当前最小处的索引就是0
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //说明假定的最小值并不是最小值
                    min = arr[j]; //重置min
                    minIndex = j; //重置minIndex

                }
            }

            //将最小值，放在arr[0]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }


//            System.out.println("第"+(i + 1)+"轮后");
//            System.out.println(Arrays.toString(arr));
        }


//        //第2轮
//        minIndex = 1; //假定当前最小处的索引就是0
//        min = arr[1];
//
//        for (int j = 1 + 1; j < arr.length; j++) {
//            if (min > arr[j]) { //说明假定的最小值并不是最小值
//                min = arr[j]; //重置min
//                minIndex = j; //重置minIndex
//
//            }
//        }
//
//        //将最小值，放在arr[0]，即交换
//        if (minIndex != 1) {
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//
//        System.out.println("第二轮后");
//        System.out.println(Arrays.toString(arr));
//
//        //第3轮
//        minIndex = 2; //假定当前最小处的索引就是0
//        min = arr[2];
//
//        for (int j = 2 + 1; j < arr.length; j++) {
//            if (min > arr[j]) { //说明假定的最小值并不是最小值
//                min = arr[j]; //重置min
//                minIndex = j; //重置minIndex
//
//            }
//        }
//
//        //将最小值，放在arr[0]，即交换
//        if (minIndex != 2) {
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }
//
//        System.out.println("第三轮后");
//        System.out.println(Arrays.toString(arr));
    }
}

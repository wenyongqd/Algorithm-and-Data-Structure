package Sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, -2};
        //为了容易理解，我们把冒泡排序的演变过程，给大家展示
        //第一堂排序，就是将最大的数排在最后

        //小结冒泡排序规则
        //(1) 一共进行数组的大小-1次的循环
        //(2) 每一趟排序的次数在逐渐的减少
        //(3) 如果我们发现在某趟排序中，没有发生依次交换，可以提前结束冒泡排序，这个就是优化
        //    注：如果没有进行交换过，说明已经交换结束



        //测试一下冒泡排序的速度O(n^2)，给80000个数据
        //创建一个80000个的随机数据
        int[] arr = new int[80000];
        for (int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000); //生成一个[0, 80000]的数

        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是" + data1Str);



        bubbleSort(arr);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是" + data2Str);


//        //第二堂排序
//        for (int j = 0; j < arr.length - 1 - 1; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//
//        System.out.println("第二趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        //第三堂排序
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//
//        System.out.println("第三趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        //第四堂排序
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//
//        System.out.println("第四趟排序后的数组");
//        System.out.println(Arrays.toString(arr));

    }
    //将冒泡排序封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0; //临时变量，用于存放数字
        boolean flag = false; //标示变量，标示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

//            System.out.println("第" + i + "趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if ( !flag) { //在一趟排序中，依次交换都没有发生
                break;
            } else {
                flag = false; //重置flag，进行下次判断
            }
        }
    }
}

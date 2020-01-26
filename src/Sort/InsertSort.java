package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};
//        insertSort(arr);

        int[] arr = new int[80000];
        for (int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*8000); //生成一个[0, 80000]的数

        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是" + data1Str);

        insertSort(arr);

        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是" + data2Str);

    }

    //插入排序
    public static void insertSort(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化

        for (int i = 1; i < arr.length; i++) {

            insertVal = arr[i];
            insertIndex = i - 1; //即arr[1]的前面这个数的下标

            //给insertval找到插入的位置
            //说明
            //1. insertIndex >= 0 保证给InsertVal找插入位置, 不            arr[insertIndex + 1] = insertVal;越界
            //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            //3. 就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; // {101, 101, 119, 1}
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到， insertIndex+1

            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }


//            System.out.println("第"+i+"轮操作后");
//            System.out.println(Arrays.toString(arr));

        }


//        //使用逐步推导的方式
//        //第1轮 {101, 34, 119, 1} => {34, 101, 119, 1}
//
//        //定义待插入的数
//        int insertVal = arr[1];
//        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标
//
//        //给insertval找到插入的位置
//        //说明
//        //1. insertIndex >= 0 保证给InsertVal找插入位置, 不越界
//        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
//        //3. 就需要将arr[insertIndex]后移
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; // {101, 101, 119, 1}
//            insertIndex--;
//        }
//        //当退出while循环时，说明插入的位置找到， insertIndex+1
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第一轮操作后");
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; //
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第二轮操作后");
//        System.out.println(Arrays.toString(arr));
//
//        //第三轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;
//
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex]; //
//            insertIndex--;
//        }
//
//        arr[insertIndex + 1] = insertVal;
//
//        System.out.println("第三轮操作后");
//        System.out.println(Arrays.toString(arr));

    }
}

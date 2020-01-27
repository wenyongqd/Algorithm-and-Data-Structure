package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int temp[] = new int[arr.length]; //归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左边递归分解
            mergeSort(arr, left, mid, temp);
            //向右边递归分解
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right,temp);
        }
    }

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right,int[] temp) {
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0; //指向temp数组的当前节点

        //（一）
        //先吧左右两边的有序数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) { //继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //就将左边的当前元素，拷贝到temp数组
            //后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { //反之，将右边的有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //（二）
        //把有剩余数据的一边的数据依次全部填充到temp
        while ( i <= mid) { //说明左边的有序序列还有剩余元素,就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while ( j <= right) { //说明右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //（三）
        //将temp数组的元素依次拷贝到arr
        //并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        //第一次合并 tempLeft=0，right=1 //tempLeft=2，right=3//tempLeft=0, right=3
        //最后一次 tempLeft=0，right=7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }


    }
}

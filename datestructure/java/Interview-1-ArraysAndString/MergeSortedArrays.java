import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] str1 = {2, 3, 4, 10, 11, 19,28,36,89};
        int[] str2 = {1, 4, 8, 9, 15, 18, 21};

        System.out.println(Arrays.toString(mergeSortedArrays(str1, str2)));
    }

    public static int[] mergeSortedArrays(int[] str1, int[] str2) {
        int[] sortedArrays = new int[str1.length + str2.length];

        if ( str1.length == 0 || str2.length == 0) {
            System.out.println("input array can't be null");
        }

        int i = 0;
        int j = 0;
        int t = 0;

        while (i < str1.length && j < str2.length) {
            if (j == str2.length || str1[i] <= str2[j]) {
                sortedArrays[t] = str1[i];
                i++;
                t++;
            }
    
            if (i == str1.length || str1[i] > str2[j]) {
                sortedArrays[t] = str2[j];
                j++;
                t++;
            }
        }

        while(i < str1.length && j >= str2.length) {
            sortedArrays[t] = str1[i];
            t++;
            i++;
        }

        while(j < str2.length && i >= str1.length) {
            sortedArrays[t] = str2[j];
            t++;
            j++;
        }
        return sortedArrays;
    }



}
import java.util.*;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            temp[0] = i;
            for (int j = i+1; j < nums.length; j++) {
                if ( nums[j] == target - firstNum ) {
                    temp[1] = j;
                    return temp;
                }                
            }
        }        
        return null;   
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums,6)));
    }
}
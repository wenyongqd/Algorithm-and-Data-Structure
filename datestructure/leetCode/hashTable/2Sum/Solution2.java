import java.util.*;

class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
    
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }      
            return null;   
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum(nums,6)));
    }
}
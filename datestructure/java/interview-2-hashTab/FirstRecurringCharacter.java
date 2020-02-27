import java.util.Hashtable;

//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4];
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,5]
//It should return 1

//Given an array = [2,3,4,5]
//It should return undefined

class FirstRecurringCharacter {

    public static void main(String[] args) {
        int[] arr = {2,5,1,2,3,5,1,2,4};
        int[] arr1 = {2,1,1,2,3,5,1,2,4};
        int[] arr2 = {2,3,4,5};

        System.out.println(firstRecurringCharacter(arr2));
    }

    public static int firstRecurringCharacter(int[] arr) {
        Hashtable<Integer, Integer> hashTab = new Hashtable<>();
        int number = -1;
        for (int i = 0; i < arr.length; i++) {
            if(hashTab.containsKey(arr[i])){
                return arr[i];
            }
            hashTab.put(arr[i], arr[i]);
        }
        return number;

    }
}
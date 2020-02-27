/**
 * Is Unique: Implement an algorithm to determine if a string has all unique charaters,
 * What if you cannot use additional data structure.
 **/

 public class IsUnique {

    public static void main(String[] args) {

        String str = "abcdefghijklmn,.";

        if (isUniqueChars(str) == true) {
            System.out.println("This string is unique.");
        } else {
            System.out.println("This string is not unique.");
        }
    }

    static boolean isUniqueChars(String str) {
        if( str.length() > 128) {  
            return false;
        }

        boolean[] mark = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int strIth = (int) str.charAt(i);
            if (mark[strIth]) {
                return false;
            }
            mark[strIth] = true;
        }
        return true;
    }

    
 }

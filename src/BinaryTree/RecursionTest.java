package BinaryTree;

public class RecursionTest {
    public static void main(String[] args) {
        test(4);

    }

    public static void test(int n) {

        System.out.println("n=" + n);
        if(n > 2) {
            test(n - 1);
        }


    }
}

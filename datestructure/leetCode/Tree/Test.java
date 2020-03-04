import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> als = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        ArrayList<Integer> a3 = new ArrayList<Integer>();
        ArrayList<Integer> a4 = new ArrayList<Integer>();
        // 下面是添加行，你可以用循环添加固定的行
        // 每一列就是一个ArrayList<Integer>，你可以任意添加，长度不固定吧
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a2.add(2);
        a3.add(3);
        als.add(a1);
        als.add(a2);
        als.add(a3);
        als.add(a4);
        ArrayList b = new ArrayList();
        b = als.get(0);
        Collections.reverse(als);
        System.out.println(b);
        System.out.println(als);
    }
}
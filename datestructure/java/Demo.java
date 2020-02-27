import java.util.ArrayList;

public class Demo {
    static ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words)
            sentence.add(w);
        for (String w : more)
            sentence.add(w);
        return sentence;
    }
    // ArrayList<String> sentence = new ArrayList<String>;

    public static void main(String[] args) {

        String[] str = new String[10];
        String str4 = "nihao,ma";
        String[] str2 = new String[] {"n", "h"};
        String[] str3 = str4.split(",");
        String str5 = str2.join()``;
        int[] intstr = new int[]{1,2,3};
        String[] sentence1 = { "wayne" };
        String[] sentence2 = { "he" };

        ArrayList<String> sentence = merge(sentence1, sentence2);
        
        System.out.println(sentence);
        System.out.println(intstr[1]);
        System.out.println(str4);
    }
    
}
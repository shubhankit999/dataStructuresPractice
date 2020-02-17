import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String str1 = "efgh";
        String str2 = "jghi";

        String str = str1 + str2;

        System.out.println(str);

        getUniqueChar(str);

    }

    private static void getUniqueChar(String str) {
        char[] chars = str.toCharArray();
        List<Character> cc = new ArrayList<>();
        for(char c : chars) {
            if(cc.contains(c)) {

            } else {
                cc.add(c);
            }
        }
        System.out.println("size = " + cc.size());
    }
}

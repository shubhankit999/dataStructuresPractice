import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubString {

    public static void main(String args[]) {

        String s1 = "GeeksForGeeks";
        String s2 = "GeeksQuiz";


        Map<Integer, Character> map = new HashMap<>();
        List<Character> chars = new ArrayList<>();
        int pointer = 0;
        for (char ch : s1.toCharArray()) {
            chars.add(ch);
            map.put(pointer++, ch);
        }

//        for(Integer c : map.keySet()) {
//            System.out.println(c);
//        }

        int cc = 0;
        for(int i=0; i<s2.length(); i++) {
            int c = 0;
            for(int j=i; j<s2.length(); j++) {
                //System.out.println(s2.substring(j, j+1));
                if(map.containsValue(s2.charAt(j)) && (cc==c+1)) {
                    cc = j;
                    System.out.println("cc " + cc);
                    c = c +1;
                }
            }
        }

    }


}

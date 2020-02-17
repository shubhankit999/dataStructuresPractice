import org.apache.logging.log4j.util.Strings;

public class ShortestLengthChain {

    public static void main(String args[]) {

        String str1 = "TOON";
        String str2 = "POON";

        int diffCount = getDiffCount(str1,str2);

        System.out.println("only 1 char difference : " + diffCount);

    }

    private static int getDiffCount(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);
        char v1[] = str1.toCharArray();
        char v2[] = str2.toCharArray();

        int diffCount = 0;
        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                ++diffCount;
            }
            k++;
        }

        return diffCount;
    }
}

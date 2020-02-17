package Array;

import java.util.HashMap;
import java.util.Map;

public class LCSIncreasingNumber {

    public static void main(String[] args) {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};

        Map<Integer, Integer> map = new HashMap<>();

        int l[] = new int[arr.length];


        for(int i=0; i<arr.length; i++) {
            int k = arr[i];
            l[i] = 1;
            for(int j=i+1; j<arr.length; j++) {
                if (k < arr[j]) {
                    l[i] = l[i] + 1;
                    k = arr[j];
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.println(l[i]);
        }
    }
}

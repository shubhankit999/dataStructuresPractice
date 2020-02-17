package Array;

public class ZeroSum {

    public static void main(String[] args) {

        int[] ar = {1,-1,1};
        int k = 5;
        if((k>ar.length) || (k%2 != 0)) {
            System.out.println("not present");
        }
        int noOfOne = 0;
        int noOfMinusOne = 0;
        for(int i=0; i<ar.length; i++) {
            if(ar[i]==1) {
                noOfOne = noOfOne +1;
            } else {
                noOfMinusOne = noOfMinusOne +1;
            }
        }

        System.out.println(noOfMinusOne);
        System.out.println(noOfOne);
        if((noOfMinusOne >= k/2) && (noOfOne >= k/2)) {
            System.out.println("present");
        }
    }
}

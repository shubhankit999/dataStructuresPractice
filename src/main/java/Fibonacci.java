public class Fibonacci {

    public static void main(String[] args) {
        int[] ar = {-2,-3,4,-1,-2,1,5,-3};
        int maxi = findMax(ar);
//        for(int i=0; i<ar.length; i++) {
//            int m = findSeries(ar, i);
//            if (maxi < m) {
//                maxi = m;
//            }
//        }
        System.out.println("max = " + maxi);

    }

    static int findSeries(int i) {
        int c = 0, a = 0, b = 1;
        if(i==0) {
            return 0;
        }
        for(int j=2; j<=i; j++) {
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    static int findSeries(int[] ar, int i) {
        int c = ar[i];
        int k =ar[i];
        if(i==-1) {
            return 0;
        }
        for(int j=i+1; j<ar.length; j++) {
            if(c < (k + ar[j])) {
                c = k + ar[j];
            }
            k = k+ar[j];
        }
        return c;
    }

    static int findMax(int[] ar) {
        int maxSoFar = ar[0];
        int currentMax = ar[0];

        for(int i=1; i< ar.length; i++) {
            currentMax = Math.max(ar[i], currentMax+ar[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}


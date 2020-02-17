package Array;

public class KLargest {
    public static void main(String[] args) {

        int[] ar = {1, 23, 12, 9, 30, 2, 50};
        Long startMillisec = System.currentTimeMillis();
        //findTwoLargest(ar, ar.length);
        findKLargest(ar,ar.length,4);
        Long endMillisec = System.currentTimeMillis();

        System.out.println("Time taken " + (endMillisec-startMillisec));

    }

    private static  void findTwoLargest(int[] ar, int n) {
        int fLargest = ar[0];
        int sLargest = 0;

        for(int i=1; i<n; i++) {
            if(ar[i] > fLargest) {
                sLargest = fLargest;
                fLargest = ar[i];
            }
        }
        System.out.println("fLargest " + fLargest);
        System.out.println("sLargest " + sLargest);

    }

    private static  void findKLargest(int[] ar, int n, int k) {

        for(int i=0; i<k; i++) {
            int b = 0;
            for(int j=0; j<n-i-1; j++) {
                if(ar[j] > ar[j+1]) {
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
                b=j;
            }
            System.out.println(ar[b+1]);
        }
    }

    private static void printKLargest() {
        int br[] = new int[3];

    }
}

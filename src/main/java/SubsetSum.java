public class SubsetSum {

    public static void main() {
        int ar[] = {4, 1, 10, 12, 5, 2};
        int sum = 9;

        boolean n[] = new boolean[10];
        for(int i=0; i<n.length; i++) {
            n[i] = false;
        }

        for(int i=0; i<ar.length; i++) {
            for(int j=0; j<n.length; j++) {
                if(!n[j]) {
                    if(ar[i] == j) {
                        n[j] = true;
                    }
                } else if(n[j]) {
                    //n
                }
            }
        }
    }
}

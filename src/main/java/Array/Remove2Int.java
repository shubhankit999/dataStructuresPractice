package Array;

public class Remove2Int {
    public static void main(String[] args) {
        int n = 5;
        int ar[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = i + 1;
            sum = sum + ar[i];
        }
        int s = 6;
        boolean found = false;
        for (int i = 0; i < n / 2; i++) {
            if ((sum - (ar[i] + ar[i + 1])) == s) {
                System.out.println("found 1 = " + i);
                found = true;
            } else if ((sum - (ar[n - i - 1] + ar[n - i - 2])) == s) {
                System.out.println("found 2 = " + i);
                found = true;
            }
        }

        System.out.println("found = " + found);

    }
}

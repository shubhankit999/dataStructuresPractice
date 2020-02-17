package Array;

public class PathToEndMatrix {

    public static void main(String[] args) {

        int ar[][] = {
                { 1, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 1 }
        };
        //System.out.println(isPathExists(ar, 5));
        findPath(ar, 5, 5);
    }

    private static boolean isPathExists(int ar[][], int n) {

        ar[0][0] = -1;
        for(int i=1; i<n; i++) {
            if(!(ar[i][0] == 0)) {
               ar[i][0] = ar[i-1][0];
            }
        }

        for(int i=1; i<n; i++) {
            if(! (ar[0][i] == 0)) {
                ar[0][i] = ar[0][i-1];
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(! (ar[i][j] == 0)) {

                    if(ar[i][j - 1] > ar[i - 1][j]) {
                        System.out.println("i = " + (i-1) + ", j= " + j);
                    } else {
                        System.out.println("i = " + i + ", j =" + (j-1));
                    }
                    ar[i][j] = Math.min(ar[i][j - 1], ar[i - 1][j]);

                }
            }
        }

        return (ar[n-1][n-1] == -1);
    }

    public static void findPath(int ar[][], int r, int c) {
        int N[][] = new  int[r][c];

        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                N[i][j] = 0;
            }
        }

        if(!findPathUtil(ar, 0, 0, 5, N)) {
            System.out.println("Doesn't exist");
            return;
        }
        System.out.println("Exists");
        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(N[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean findPathUtil(int ar[][], int r, int c, int n, int N[][]) {
        if(r==n-1 && c==n-1) {
            N[r][c] = 1;
            return true;
        }

        if(isSafe(ar, r, c)) {
            if(findPathUtil(ar,r+1, c,n, N)) {
                N[r][c] = 1;
                return true;
            }
            if(findPathUtil(ar,r, c+1,n, N)) {
                N[r][c] = 1;
                return true;
            }

            N[r][c] = 0;
            return false;
        }

        return false;
    }

    private static boolean isSafe(int ar[][], int r, int c) {
        if(r>=0 && c>=0 &&r<5 && c<5 && (ar[r][c] == 1)) {
            return true;
        }
        return false;
    }
}

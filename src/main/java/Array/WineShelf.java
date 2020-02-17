package Array;

public class WineShelf {

    static int N = 100;
    static int[][] dp = new int[N][N];
    public static void main(String[] args) {
        int[] cost = {2,4,6,2,5};
        int[] year = {1,2,3,4,5};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int yMaxCost = findYearMaxCost(cost,0, 1, 5);
        System.out.println(yMaxCost);
    }

    static void findMaxCost(int[] cost, int[] year) {
        for(int i=0; i<year.length; i++) {

        }
    }

    static int findYearMaxCost(int cost[], int begin, int end, int n) {
        if(dp[begin][end] != -1) {
            return dp[begin][end];
        }
        int year = n- ( end - begin );
        if(begin==end) {
            return year * cost[begin];
        }
        int l = cost[begin] * year + findYearMaxCost(cost, begin+1, end, n);
        int r = cost[end] * year + findYearMaxCost(cost, begin, end-1, n);
        return Math.max(l, r);
    }
}

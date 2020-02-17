package Array;

public class ColorAdjacentElements {

    public static int ROW = 8;
    public static int COLUMN = 8;

    public static void main(String[] args) {

        int ar[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        colorIndex(ar, ar[3][3], 3, 3, 3);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }

    }

//    {{1, 1, 1, 1, 1, 1, 1, 1},
//        {1, 1, 1, 1, 1, 1, 0, 0},
//        {1, 0, 0, 1, 1, 0, 1, 1},
//        {1, 3, 3, 3, 3, 0, 1, 0},
//        {1, 1, 1, 3, 3, 0, 1, 0},
//        {1, 1, 1, 3, 3, 3, 3, 0},
//        {1, 1, 1, 1, 1, 3, 1, 1},
//        {1, 1, 1, 1, 1, 3, 3, 1}, };

    private static void colorIndex(int ar[][], int preColor, int r, int c, int color) {

        if (r >= ROW || c >= COLUMN) {
            return;
        }
        if(r < 0 || c < 0) {
            return;
        }
        if(ar[r][c] == preColor){
            ar[r][c] = color;
            colorIndex(ar, preColor, r - 1, c, color);
            colorIndex(ar, preColor, r, c - 1, color);
            colorIndex(ar, preColor, r + 1, c, color);
            colorIndex(ar, preColor, r, c + 1, color);
        }
    }
}

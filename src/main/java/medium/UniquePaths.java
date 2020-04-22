package medium;

import java.util.Arrays;

public class UniquePaths {


    public static void main(String[] args) {
        int m = 51, n = 9;
        new UniquePaths().uniquePaths(m,n);
    }

    int globalCount = 0;


    public int uniquePaths(int m, int n) {

//        traverseGridByBackTracking(0,0, m, n);
//
//        return globalCount;


        int[][] d = new int[m][n];

        for(int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];


    }

    public void traverseGridByBackTracking(int x, int y, int m, int n){
        if(x == m - 1 && y == n - 1){
            globalCount++;
            return;
        }

        if(x+1 < m){
            traverseGridByBackTracking(x+1, y, m, n);
        }

        if(y+1 < n){
            traverseGridByBackTracking(x, y+1, m, n);
        }
    }
}

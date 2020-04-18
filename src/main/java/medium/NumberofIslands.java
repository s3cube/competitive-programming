package medium;

public class NumberofIslands {

    public static void main(String[] args) {
        char input[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','1','1'}
        };

        int output = new NumberofIslands().numIslands(input);

        System.out.println(output);

    }

    public int numIslands(char[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    DFS(grid,i, j);
                    islands++;
                }
            }
        }


        return islands;
    }

    public void DFS(char[][] grid, int i, int j){


        grid[i][j] = '0';


        if(i > 0 && grid[i-1][j] == '1'){
            DFS(grid, i - 1, j);
        }

        if(j > 0 && grid[i][j-1] == '1'){
            DFS(grid, i , j-1);
        }

        if(i < grid.length - 1 && grid[i+1][j] == '1'){
            DFS(grid, i+1 , j);
        }

        if(j < grid[0].length - 1 && grid[i][j+1] == '1'){
            DFS(grid, i , j+1);
        }

    }
}

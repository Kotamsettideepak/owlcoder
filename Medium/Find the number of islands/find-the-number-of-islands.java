//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public void dfs(char[][] grid, int row, int col, boolean visited[][]) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || visited[row][col]
                || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, row + 1, col, visited); // down
        dfs(grid, row - 1, col, visited); // up
        dfs(grid, row, col + 1, visited); // right
        dfs(grid, row, col - 1, visited); // left
        dfs(grid, row + 1, col + 1, visited); // down right
        dfs(grid, row - 1, col - 1, visited); // up left
        dfs(grid, row + 1, col - 1, visited); // down left
        dfs(grid, row - 1, col + 1, visited); // up right
    }
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int c = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != '0' && visited[row][col] == false) {
                    dfs(grid, row, col, visited);
                    c++;
                }
            }
        }
        return c;
    }
}
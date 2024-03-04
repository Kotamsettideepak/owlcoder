//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution {
    public boolean stack[];
    public boolean visited[];

    public boolean moon(ArrayList<ArrayList<Integer>> adj, int curr) {
        stack[curr] = true;
        visited[curr] = true;
        boolean cycle=false;
        for (int i : adj.get(curr)) {
            if (stack[i]) {
                return true;
            } else if (!visited[i]) {
                cycle =cycle || moon(adj, i);
            }
        }
        stack[curr] = false;
        return cycle;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        stack = new boolean[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && moon(adj, i)) {
                return true;
            }
        }
        return false;
    }
}

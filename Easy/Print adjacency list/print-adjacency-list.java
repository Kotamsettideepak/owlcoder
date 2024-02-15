//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][2];
            for (int i = 0; i < m; i++) {
                s = in.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
            }
            Solution ob = new Solution();
            List<List<Integer>> A = ob.printGraph(n, edges);
            for (var i : A) {
                Collections.sort(i);
                for (int j : i) {
                    out.print(j + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> r=new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int [] i:edges){
            int a= i[0],b=i[1];
            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(b);
                map.put(a,l);
            }if(map.containsKey(b)){
                map.get(b).add(a);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(a);
                map.put(b,l);
            }
        }
        for(int i=0;i<V;i++){
            if(map.containsKey(i)){
                r.add(map.get(i));
            }else{
                r.add(new ArrayList<>());
            }
        }
        return r;
    }
}
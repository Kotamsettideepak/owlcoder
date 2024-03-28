//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Pair {
    int distance, source;

    Pair(int distance, int source) {
        this.source = source;
        this.distance = distance;
    }

    int getSource() {
        return source;
    }

    int getDistance() {
        return distance;
    }
}

class cmpt implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.distance, p2.distance);
    }
}

class Solution {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> qu = new PriorityQueue<>(new cmpt());
        qu.add(new Pair(0,S));
        distance[S] = 0;
        Pair p;
        int source, dis;
        while (!qu.isEmpty()) {
            p = qu.poll();
            source = p.getSource();
            dis = p.getDistance();
            for (ArrayList<Integer> i : adj.get(source)) {
                if (dis + i.get(1) < distance[i.get(0)]) {
                    distance[i.get(0)] = dis + i.get(1);
                    qu.add(new Pair(distance[i.get(0)], i.get(0)));
                }
            }
        }
        return distance;
    }
}

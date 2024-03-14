//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends




//User function Template for Java

class Solution
{
    static class Pair {
        int arrival, departuer;

        Pair(int departuer, int arrival) {
            this.arrival = arrival;
            this.departuer = departuer;
        }

        int getArrival() {
            return arrival;
        }

        int getDepartuer() {
            return departuer;
        }
    }

    static class cmpt implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.getArrival(), p2.getArrival());
        }
    }

    static int findPlatform(int arr[], int dep[], int n) {
        List<Pair> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new Pair(dep[i], arr[i]));
        }
        boolean flag;
        Collections.sort(l, new cmpt());
        ArrayList<List<Pair>> al = new ArrayList<>();
        for (Pair p : l) {
            flag = true;
            if (al.isEmpty()) {
                List<Pair> r = new ArrayList<>();
                r.add(p);
                al.add(r);
            } else {
                for (List<Pair> r : al) {
                    if (r.get(r.size() - 1).getDepartuer() < p.getArrival()) {
                        r.add(p);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    List<Pair> r = new ArrayList<>();
                    r.add(p);
                    al.add(r);
                }
            }
        }
        return al.size();
    }
}


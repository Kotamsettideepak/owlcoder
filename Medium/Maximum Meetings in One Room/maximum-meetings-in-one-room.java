//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Pair {
    int start;
    int index;

    Pair(int start, int index) {
        this.start = start;

        this.index = index;
    }

    int getStart() {
        return start;
    }

    int getIndex() {
        return index;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] s, int[] e) {
        ArrayList<Integer> al = new ArrayList<>();
        SortedMap<Integer, Pair> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(e[i])) {
                Pair p = map.get(e[i]);
                if (s[i] > p.getStart()) {
                    map.put(e[i], new Pair(s[i], i));
                }
            } else {
                map.put(e[i], new Pair(s[i], i));
            }
        }
        int end = Integer.MIN_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i).getStart() > end) {
                al.add(map.get(i).getIndex()+1);
                end = i;
            }
        }
        Collections.sort(al);
        return al;
    }
}
     

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
         ArrayList<Integer> al = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        al.add(map.size());
        int j = 0, check;
        for (int i = k; i < n; i++) {
            check = map.get(A[j]);
            if (check == 1 || check==0) {
                map.remove(A[j]);
            }else{
                map.put(A[j],check-1);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            al.add(map.size());
            j++;
        }
        return al;       // code here 
    }
}


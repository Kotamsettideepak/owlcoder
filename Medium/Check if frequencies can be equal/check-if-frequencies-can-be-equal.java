//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Integer> al1 = new ArrayList<>(map.values());
        ArrayList<Integer> al2 = new ArrayList<>(map.values());
        for (int i = 0; i < al1.size() - 1; i++) {
            if (al1.get(i) != al1.get(i + 1)) {
                if (al1.get(i) > al1.get(i + 1)) {
                    al1.set(i, al1.get(i) - 1);
                    al2.set(i + 1, al2.get(i + 1) - 1);
                    if (al1.get(i) == 0) {
                        al1.remove(i);
                    }
                    if (al2.get(i + 1) == 0) {
                        al2.remove(i + 1);
                    }
                    break;
                } else if (al1.get(i) < al1.get(i + 1)) {
                    al1.set(i, al1.get(i) - 1);
                    al2.set(i + 1, al2.get(i + 1) - 1);
                    if (al1.get(i) == 0) {
                        al1.remove(i);
                    }
                    if (al2.get(i + 1) == 0) {
                        al2.remove(i + 1);
                    }
                    break;
                }
            }
        }
        Set<Integer> st = new HashSet<>(al1);
        Set<Integer> st2 = new HashSet<>(al2);
        return st.size() == 1 || st2.size() == 1;
    }
}
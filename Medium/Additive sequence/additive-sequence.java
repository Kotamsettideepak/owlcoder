//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ss = new Solution();
            boolean result = ss.isAdditiveSequence(s);
            System.out.println((result == true ? 1 : 0));
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1;
        int c1, c2, carry = 0, sum;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                c1 = Character.getNumericValue(s1.charAt(i));
            } else {
                c1 = 0;
            }
            if (j >= 0) {
                c2 = Character.getNumericValue(s2.charAt(j));
            } else {
                c2 = 0;
            }
            sum = c1 + c2 + carry;
            if (sum > 9) {
                carry = sum / 10;
                sb.append(sum % 10);
            } else {
                sb.append(sum);
                carry = 0;
            }
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }

    public boolean moon(String s, int st) {
        String a, b, c, d;
        boolean valid = false, res = false;
        for (int i = st; i < s.length(); i++) {
            a = s.substring(st, i + 1);
            valid = false;
            for (int j = i + 1; j < s.length(); j++) {
                b = s.substring(i + 1, j + 1);
                c = s.substring(j + 1, s.length());
                d=add(a,b);
                if (c.startsWith(d)) {
                    if (c.length() == d.length()) {
                        return true;
                    } else {
                        valid = true && moon(s, j);
                    }
                }
            }
            res = res || valid;
        }
        return res;
    }

    public boolean isAdditiveSequence(String s) {
        if (s.length() < 3) {
            return false;
        }
        return moon(s, 0);
    }
}

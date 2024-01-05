import java.util.*;
import java.lang.Math;

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> al = new ArrayList<>();
        int length = s.length();
        for (int i = 1; i <= (int) Math.pow(2, length) - 1; i++) {
            String temp = "";
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1) {
                    temp += String.valueOf(s.charAt(j));
                }
            }
            al.add(temp);
        }
        Collections.sort(al);
        return al;
    }
}
import java.util.*;
import java.lang.Math;

class Solution {
    public int count(String s) {
        int c = 0;
        for (char t : s.toCharArray()) {
            if (t == '1') {
                c++;
            }
        }
        return c;
    }

    public int numberOfBeams(String[] bank) {
        int c = 0, x = 0, sum = 0;
        for (int i = 0; i < bank.length; i++) {
            c = count(bank[i]);
            if (c == 0)
                continue;
            for (int j = i + 1; j < bank.length; j++) {
                x = count(bank[j]);
                if (x != 0) {
                    sum += (c * x);
                    break;
                }
            }
        }
        return sum;
    }
}
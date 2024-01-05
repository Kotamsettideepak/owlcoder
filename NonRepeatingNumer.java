import java.util.*;
import java.lang.Math;

class Solution {
    public int[] singleNumber(int[] nums) {
        int r1 = 0, r2 = 0;
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        int sb = 0;
        while ((xor & 1) == 0) {
            xor = xor >> 1;
            sb++;
        }
        for (int i : nums) {
            if ((i >> sb & 1) == 1) {
                r1 ^= i;
            } else {
                r2 ^= i;
            }
        }
        xor = Math.min(r1, r2);
        r2 = Math.max(r1, r2);
        r1 = xor;
        return new int[] { r1, r2 };
    }
}
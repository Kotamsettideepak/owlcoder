import java.util.*;
import java.lang.Math;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int keys = 0, temp;
        for (int i : nums) {
            if (map.containsKey(i)) {
                temp = map.get(i);
                map.put(i, temp + 1);
            } else {
                map.put(i, 1);
                keys++;
            }
        }
        // System.out.println(map);
        int answer = 0;
        for (int i : map.keySet()) {
            temp = map.get(i);
            if (temp % 3 == 0) {
                answer += (temp / 3);
            } else if ((temp % 3) % 2 == 0) {
                answer += (temp / 3) + ((temp % 3) / 2);
            } else if ((temp - 4) % 3 == 0 && temp - 4 > 0) {
                answer += ((temp - 4) / 3) + 2;
            } else if (temp % 2 == 0) {
                answer += (temp / 2);
            } else {
                return -1;
            }
        }
        return answer;
    }
}
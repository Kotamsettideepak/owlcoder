import java.util.*;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area;
        int max = 0;
        int temp = 0;
        for (int[] i : dimensions) {
            temp = Math.abs(i[0] - i[1]);
            if (temp > max) {
                max = temp;
                area = i[0] * i[1];
            }
        }
        return area;
    }

    }

    public static void main(String[] args) {
        Solution ob = new Solution();
        int arr[][] = { { 2, 6 }, { 5, 1 }, { 3, 10 }, { 8, 4 } };
        int a = ob.areaOfMaxDiagonal(arr);
    }
}
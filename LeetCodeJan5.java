import java.util.*;
import java.lang.Math;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr, 1);
        int length = nums.length;
        int max = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (arr[j] > temp)
                        temp = arr[j];
                }
            }
            arr[i] += temp;
            if (max < arr[i])
                max = arr[i];
        }
        // System.out.println(Arrays.toString(arr));
        return max;
    }
}
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Proceduer:
    take an array with given array size and fillit with 1's using Array.fill(Array_name,1)
    now travel on nums check how many numbers are less than the current and parallely check corresponding index which we take all elements to 1
    in thaht take maximum and add it to the corresponding main number index on which loop is iteerating 'i'th index
    take another max and check parallely the max arr[i]
    return max;

    
    
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

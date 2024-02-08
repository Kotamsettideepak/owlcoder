//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    static long trappingWater(int arr[], int n) {
        int right[] = new int[n];
        int left[] = new int[n];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (arr[i] > max1) {
                max1 = arr[i];
            }
            right[i] = max1;
            if (arr[j] > max2) {
                max2 = arr[j];
            }
            left[j] = max2;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(Math.abs(arr[i] - right[i]), Math.abs(arr[i] - left[i]));
        }
        return sum;
    }
}
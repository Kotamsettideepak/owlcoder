//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] nums){
        if(nums.length==1)return 0;
        int stop=0,next_stop=0;
        int steps=0;
        for(int i=0;i<nums.length;i++){
            next_stop=Math.max(next_stop,i+nums[i]);
            if(i==stop){
                stop=next_stop;
                steps++;
                if(stop>=nums.length-1){
                    return steps;
                }
            }
        }
        return -1;
    }
}
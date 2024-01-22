//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void moon(int arr[],List<Integer>temp,List<List<Integer>> l){
        if(temp.size()==arr.length){
            l.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(temp.contains(arr[i]))continue;
            else{
                temp.add(arr[i]);
                moon(arr,temp,l);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<String> find_permutation(String S) {
        int arr[] = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = i;
        }
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        List<String> res = new ArrayList<>();
        moon(arr, al, l);
        String temp = "";
        for (List<Integer> j : l) {
            for (int i = 0; i < j.size(); i++) {
                temp += String.valueOf(S.charAt(j.get(i)));
            }
            if(!(res.contains(temp)))res.add(temp);
            temp = new String("");
        }
        Collections.sort(res);
        return res;
    }
}
//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void moon(Stack<Integer>s, int n,int i){
        if(s.isEmpty())return;
        int a=s.pop();
        // System.out.println("index "+i+" "+a);
        moon(s,n,i+1);
        if(n!=i)s.push(a);
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int r=(int)Math.floor((sizeOfStack+1)/2);
        r=sizeOfStack%2==0 ?r+1:r;
        moon(s,r,1);
    } 
}


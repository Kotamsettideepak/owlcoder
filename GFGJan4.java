import java.util.*;
import java.lang.Math;


class Solution {
    static int singleElement(int[] arr , int N) {
       int r=0;
       int c;
       for(int i=0;i<32;i++){
           c=0;
           for(int j:arr){
               if(((j>>i)&1) != 0){
                   c++;
               }
           }
           if(c%3!=0){
               r=r|(1<<i);
           }
       }
       return r;
    }
}
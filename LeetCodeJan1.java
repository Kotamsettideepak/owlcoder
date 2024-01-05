import java.util.*;
import java.lang.Math;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int  c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gr=0,si=0;
        while(true){
            if(gr>=g.length || si>=s.length){
                break;
            }
            if(g[gr]<=s[si]){
                c++;
                gr++;
                si++;
            }else{
                si++;
            }

        }
        return c;
    }
}
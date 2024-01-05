import java.util.*;
import java.lang.Math;

class Solution {
    public boolean isThere(List<Integer> al,int t){
        int i=0,j=al.size()-1,mid;
        while(i<=j){
            mid=(i+j)/2;
            if(al.get(mid)==t){
                return true;
            }
            else if(al.get(mid)>t){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return false;
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> al= new ArrayList<>();
        boolean flag;
        for(int i=0;i<nums.length;i++){
            flag=false;
            if(al.size()==0){
                List<Integer> l= new ArrayList<>();
                l.add(nums[i]);
                al.add(l);
            }else{
                for(int j=0;j<al.size();j++){
                    if(!(isThere(al.get(j),nums[i]))){
                        al.get(j).add(nums[i]);
                        Collections.sort(al.get(j));
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    List<Integer> l= new ArrayList<>();
                    l.add(nums[i]);
                    al.add(l);  
                }
            }
        }
        return al;
    }
}
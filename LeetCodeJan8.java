import java.util.*;

class LeetCodeJan8 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int answer=0;
        
        if(root==null)return 0;
        else if(root.val<=high && root.val>=low){
            answer+=root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }
        else if(root.left!=null &&(root.left.val<=high && root.left.val>=low)){
            answer+=rangeSumBST(root.left,low,high);
        }
        else if(root.right!=null && (root.right.val<=high && root.right.val>=low)){
            answer+=rangeSumBST(root.right,low,high);
        }
        else if(root.val>high || root.val<low){
            answer+=rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        }

        return answer;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static int commonAncestors(TreeNode root, int value,ArrayList <TreeNode> ptree){
        int res=0;
        if(root.left!=null)
        {
            res=commonAncestors(root.left,value,ptree);
            if(res==1)
            {
                ptree.add(root);
                return 1;
            }
        }
        if(root.right!=null)
        {
            res=commonAncestors(root.right,value,ptree);
            if(res==1)
            {
                ptree.add(root);
                return 1;
            }
        }
        if(root.val==value)
        {
            return 1;
        }
        else{
            return 0;
        }
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList <TreeNode> ptree=new ArrayList<>();
        ArrayList <TreeNode> qtree=new ArrayList<>();
        int res=commonAncestors(root,p.val,ptree);
        res=commonAncestors(root,q.val,qtree);
        Collections.reverse(ptree);
        Collections.reverse(qtree);
        ptree.add(p);
        qtree.add(q);
        ArrayList<TreeNode> commonElements = new ArrayList<>(ptree);

        // Retain only elements that are also in list2
        commonElements.retainAll(qtree);
        // System.out.println(qtree);
        for(int i=0;i<qtree.size();i++)
        {
        System.out.println(qtree.get(i).val);
        }
        return commonElements.get(commonElements.size()-1);


    }
}
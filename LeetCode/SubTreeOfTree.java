/**
Runtime: 5 ms, faster than 97.05% of Java online submissions for Subtree of Another Tree.
Memory Usage: 39.2 MB, less than 63.83% of Java online submissions for Subtree of Another Tree.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution
{
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        List<TreeNode> foundNodes = new ArrayList<TreeNode>();
        find(s, t.val, foundNodes);
        
        int i=0;
        boolean isSubtree = false;
		for(i=0; i<foundNodes.size(); i++)
		{
			TreeNode node = foundNodes.get(i);
			isSubtree = isSubtreeFind(t, node);
			//System.out.println("  isSubtree___ : " + isSubtree);
			if(isSubtree)
			{
				break;
			}
		}
        return isSubtree; 
    }
	
	public boolean isSubtreeFind(TreeNode t, TreeNode node)
	{
		if(t == null && node == null)
		{
			return true;
		}
		if(t == null || node == null)
		{
			return false;
		}
		if(t.val != node.val)
		{
			return false;
		}
		/*if(s.data == node.data)
		{
			return true;
		}*/
		
		return t.val == node.val && isSubtreeFind(t.left, node.left) && isSubtreeFind(t.right, node.right);
	}
	
	public void find(TreeNode node, int data, List<TreeNode> foundNodes)
	{
		if(node == null)
		{
			return;
		}
		if(node.val == data)
		{
			foundNodes.add(node);
		}
		find(node.left, data, foundNodes);
		find(node.right, data, foundNodes);
	}
}
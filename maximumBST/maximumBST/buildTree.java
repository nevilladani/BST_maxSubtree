package maximumBST;

public class buildTree 
{
	int[] inorder;
	int[] postorder;
	TreeNode node;
	
	public buildTree() {
		// TODO Auto-generated constructor stub
	}
	public buildTree(int[] inorder, int[] postorder) 
	{
		this.inorder = inorder;
		this.postorder = postorder;
		this.node = bTree(inorder,postorder);
	}
	
	public TreeNode bTree(int[] inorder, int[] postorder) {
        return addTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode addTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        int rootVal = postorder[pe];
        
        TreeNode root = new TreeNode(rootVal);
        System.out.print(rootVal+",");
        //root.minV = rootVal;
        //root.maxV = rootVal;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootVal) {
                TreeNode left = addTree(inorder, is, i - 1, postorder, ps, ps + i - is - 1);
                TreeNode right = addTree(inorder, i + 1, ie, postorder, pe - ie + i, pe - 1);
                if (right!=null)
                	right.parent = root;
                if (left!=null)
                	left.parent = root;
                root.maxSubVal = 1;
                //if (root.minV > left.minV)
                //	root.minV = left.minV;
                //if (root.maxV < left.maxV)
                //	root.maxV = left.maxV;
                
                root.left = left;
                root.right = right;
                
            }
        }
        return root;
    }

}

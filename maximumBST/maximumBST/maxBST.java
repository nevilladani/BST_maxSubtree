package maximumBST;

import java.io.*;
import java.util.*;

public class maxBST 
{
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("Algotrithm Project");
    	System.out.println("By Nevil Ladani");
    	System.out.println("Email: npl130030@utdallas.edu");
    	System.out.println();
    	System.out.println("Challenge Question: BST Problem");
    	
    	File f = new File("bst.txt");
    	int tt=0;
    	int n = 0;
    	int[] inorder = new int[1];
		int[] postorder = new int[1];
    	int y=0;
    	TreeNode fake = new TreeNode(-1);
    	fake.left = fake;
    	fake.right = fake;
    	
		try{
    		
        	Scanner scanner = new Scanner(f);
        	tt=scanner.nextInt();
        	
        for(int x=0;x<tt;x++)
        {	
        	System.out.println("Tree- " + (x+1));
        	n=scanner.nextInt();
    		System.out.println("Number of Nodes: "+ n);
    		inorder = new int[n];
    		postorder = new int[n];
    		
    		for(int i = 0; i<n; i++)
    		{
    			postorder[i] = scanner.nextInt();
    		}
    		for(int i = 0; i<n; i++)
    		{
    			inorder[i] = scanner.nextInt();
    		}
    		
    		for(int i=0;i<n ;i++)
    		{
    				System.out.print(inorder[i] + "  ");
    				

    		}
    		System.out.println();
    		for(int i=0;i<n ;i++)
    		{
    			System.out.print(postorder[i] + "  ");
    		}
    		
    		buildTree t = new buildTree(inorder, postorder);
    		System.out.println();
    		maxBST s = new maxBST();
    		s.searchMax(t.node,0,10000, t.node,0);
    		
    		
    		TreeNode finalNode;
    		
    		finalNode = s.maxSub(t.node, t.node);
    		
    		TreeNode qn;
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		//System.out.println(t.node.val +"   " + t.node.maxSubVal );
    		
    		System.out.println("Root node for maximum sub-BST: "+finalNode.val);
    		System.out.println("Number of Nodes in maximum sub-BST: "+finalNode.maxSubVal);
    		System.out.println();
    		System.out.println("Preorder traversal - Tree Structure");
    		s.searchMax(finalNode,0,10000, finalNode,1);
    		
    		System.out.println();
    		System.out.println();
    		
    		
    		System.out.println();
        }
    		scanner.close();
    	}
        catch(FileNotFoundException filenotfoundexception)
    	{
       		System.out.println("File not found.");
    	}
    	     
		catch(IOException ioexception)
    	{
       		System.out.println("File input error occured!");
       
    	}		
		
				
		
		
	}
	public TreeNode maxSub(TreeNode rNode, TreeNode maxN)
	{
		
		
		TreeNode rootNode = rNode;
		TreeNode maxNode = maxN;
		maxBST m = new maxBST();
		//System.out.println(maxNode.val +"   " + maxNode.maxSubVal );
		if(rootNode.left!=null)
			m.searchMax(rootNode.left,0,10000,rootNode.left,0);
		if(rootNode.right!=null)
			m.searchMax(rootNode.right,0,10000,rootNode.right,0);
		
		if((rootNode.left!=null)&&maxNode.maxSubVal<rootNode.left.maxSubVal)
		{		
				maxNode = rootNode.left;
		}
		else if((rootNode.right!=null)&&maxNode.maxSubVal<rootNode.right.maxSubVal)
		{	
			maxNode = rootNode.right;
			
		}
		if(rootNode.left!=null)
		{
			if(rootNode.left.left!=null&&rootNode.left.right!=null)
			{
				//System.out.println("yyyy" + rootNode.left.val +"   " + rootNode.left.maxSubVal );
				maxSub(rootNode.left, maxNode);
			
			}
		}	
		if(rootNode.right!=null)
		{
			if(rootNode.right.right!=null && rootNode.right.left!=null)
			{
				//System.out.println("aaaa" + rootNode.right.val +"   " + rootNode.right.maxSubVal );
				maxSub(rootNode.right, maxNode);
			
			}
		}
		
	return maxNode;	
	}
	public void searchMax(TreeNode tn, int mlV, int mrV, TreeNode tc,int flag)
	{
		
		int maxlV = mlV;
		int maxrV = mrV;
		//if(tn.left == null && tn.right == null)
		//{
			//System.out.println("DDD");
		//if(flag==1)
		{	
			
			System.out.print(tn.val+ "  ");
		}	
		//}
		
		
		
		if((tn.left !=null) && (tn.left.val< tn.val) && (tn.left.val >maxlV)) // 
		{	
			if((tn.left !=null) && tn.parent!=null && tn.parent.val < tn.val&& (tn != tc))
				maxlV = tn.parent.val;

			
			if(tn.left.val > maxlV)
			{
				tc.maxSubVal++; 
				searchMax(tn.left, maxlV,maxrV, tc,flag);
			}
		}
		if((tn.right !=null) && (tn.right.val> tn.val) && (tn.right.val <maxrV)) // 
		{	
			if((tn.right !=null) && tn.parent!=null && tn.parent.val > tn.val && (tn != tc))
				maxrV = tn.parent.val;
				
			if((tn.right.val <maxrV))
			{
				tc.maxSubVal ++;
				searchMax(tn.right, maxlV,maxrV, tc,flag);
			}
		}
		
	}
	
	
}

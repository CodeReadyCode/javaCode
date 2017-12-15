package solutions;
// Recursive Java program for level order traversal of Binary Tree
 
/* Class containing left and right child of current 
   node and key value*/
class OrderLevelNode
{
    int data;
    OrderLevelNode left, right;
    public OrderLevelNode(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree1
{
    // Root of the Binary Tree
    OrderLevelNode root;
 
    public BinaryTree1()
    {
        root = null;
    }
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
//        for (i=1; i<=h; i++)
//            printGivenLevel(root, i);
       // for (i=1; i<=h; i++)
            printGivenLevel(root.left, 3/2+1);
       // printGivenLevelMostRight(root.right, 3);
          //  printGivenLevelRightNode(root.right,2);
         //   printGivenLevelRightNode(root.right,2/2);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(OrderLevelNode root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    /* Print nodes at the given level */
    void printGivenLevel (OrderLevelNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1){
        	System.out.print(root.data + " ");
        }
           
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);	
            printGivenLevel(root.right, level-1);
        }
    }
    
    void printGivenLevelRightNode (OrderLevelNode root, int level)
    {
    	 if (root == null)
			return;
		if (level == 1) {

			if (root.right != null) {
				printGivenLevelRightNode(root.right, level - 1);
				System.out.print(root.data + " ");
			}
			if (root.left != null) {
				System.out.print(root.data + " ");
				printGivenLevelRightNode(root.left, level - 1);
			}
		}
         else if (level > 1)
         {
        	 printGivenLevelRightNode(root.left, level-1);	
        	 printGivenLevelRightNode(root.right, level-1);
         }
    }
    
  
     
    /* Driver program to test above functions */
    public static void main(String args[])
    {
       BinaryTree1 tree = new BinaryTree1();
       tree.root= new OrderLevelNode(1);
       tree.root.left= new OrderLevelNode(2);
       tree.root.right= new OrderLevelNode(3);
       tree.root.right.right= new OrderLevelNode(8);
       tree.root.left.left= new OrderLevelNode(4);
       tree.root.left.right= new OrderLevelNode(5);
        
       System.out.println("Level order traversal of binary tree is ");
       tree.printLevelOrder();
    }
}
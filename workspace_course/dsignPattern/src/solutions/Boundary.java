package solutions;
//Java program to print boundary traversal of binary tree
  
/* A binary tree Boundary has data, pointer to left child
   and a pointer to right child */
class Boundary 
{
    int data;
    Boundary left, right;
  
    Boundary(int item) 
    {
        data = item;
        left = right = null;
    }
}
  
class BinaryTree 
{
    Boundary root;
  
    // A simple function to print leaf Boundarys of a binary tree
    void printLeaves(Boundary Boundary) 
    {
        if (Boundary != null) 
        {
            
  
            // Print it if it is a leaf Boundary
            if (Boundary.left == null && Boundary.right == null)
                System.out.print(Boundary.data + " ");
            printLeaves(Boundary.left);
            printLeaves(Boundary.right);
        }
    }
  
    // A function to print all left boundry Boundarys, except a leaf Boundary.
    // Print the Boundarys in TOP DOWN manner
    void printBoundaryLeft(Boundary Boundary) 
    {
        if (Boundary != null) 
        {
            if (Boundary.left != null) 
            {
                  
                // to ensure top down order, print the Boundary
                // before calling itself for left subtree
                System.out.print(Boundary.data + " ");
                printBoundaryLeft(Boundary.left);
            } 
            else if (Boundary.right != null) 
            {
                System.out.print(Boundary.data + " ");
                printBoundaryLeft(Boundary.right);
            }
  
            // do nothing if it is a leaf Boundary, this way we avoid
            // duplicates in output
        }
    }
  
    // A function to print all right boundry Boundarys, except a leaf Boundary
    // Print the Boundarys in BOTTOM UP manner
    void printBoundaryRight(Boundary Boundary) 
    {
        if (Boundary != null) 
        {
            if (Boundary.right != null) 
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this Boundary
                printBoundaryRight(Boundary.right);
                System.out.print(Boundary.data + " ");
            } 
            else if (Boundary.left != null) 
            {
                printBoundaryRight(Boundary.left);
                System.out.print(Boundary.data + " ");
            }
            // do nothing if it is a leaf Boundary, this way we avoid
            // duplicates in output
        }
    }
  
    // A function to do boundary traversal of a given binary tree
    void printBoundary(Boundary Boundary) 
    {
        if (Boundary != null) 
        {
            System.out.print(Boundary.data + " ");
  
            // Print the left boundary in top-down manner.
            printBoundaryLeft(Boundary.left);
  
            // Print all leaf Boundarys
            printLeaves(Boundary.left);
            printLeaves(Boundary.right);
  
            // Print the right boundary in bottom-up manner
            printBoundaryRight(Boundary.right);
        }
    }
       
    // Driver program to test above functions
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Boundary(20);
        tree.root.left = new Boundary(8);
        tree.root.left.left = new Boundary(4);
        tree.root.left.right = new Boundary(12);
        tree.root.left.right.left = new Boundary(10);
        tree.root.left.right.right = new Boundary(14);
        tree.root.right = new Boundary(22);
        tree.root.right.right = new Boundary(25);
        tree.printBoundary(tree.root);
  
    }
}
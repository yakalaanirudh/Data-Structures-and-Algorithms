//Create a BST from a given preorder traversal array
//{10,4,2,8,5,9,15,12,20}

class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node createBST(int[] arr,int start,int end){
        if(start>end){
            return null;
        }

        Node node=createNewNode(arr[end]);

        int i;
        for(i=start+1;i<=end;i++){
            if(arr[i]>node.data){
                break;
            }
        }

        node.left=createBST(arr,start+1,i-1);
        node.right=createBST(arr,i,end);

        return node;
    }

    public Node insert(Node node, int val) {
        if(node == null) {
            return createNewNode(val);
        }

        if(val < node.data) {
            node.left = insert(node.left, val);
        } else if((val > node.data)) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public void inorder(Node node){
        if(node==null){
            return;
        }

        inorder(node.left);

        System.out.print(node.data+" ");

        inorder(node.right);
    }
}

public class BST27 {

    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        int[] postOrder={2,5,9,8,4,12,20,15,10};
        root=a.createBST(postOrder,0,postOrder.length-1);
        a.inorder(root);

    }

}

/*
{2,5,9,8,4,12,20,15,10} //This is the given post order traversal
{2 4 5 8 9 10 12 15 20} //This is the output in inorder traversal of the created binary tree

Postorder traversal is
root
left
right


We can observe that
In postorder the order is root left right         //{10,4,2,8,5,9,15,12,20}
so the first element in the given array is the root//10
And the first element from front that is greater than root is right child    //15

So now we create BST from {4,2,8,5,9}   4 is root   8 is right child    2 is left child
So now we create BST from {8,5,9}
8 is root for right child   5 is root for left child    9 is right child

we create BST from {15,12,20}
115 is root
112 is root for left child
220 is right child
 */
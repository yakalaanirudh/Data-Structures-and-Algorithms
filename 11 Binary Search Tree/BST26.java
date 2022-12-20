//Create a BST from a given postorder traversal array
//[2,5,9,8,4,12,20,15,10]
//import java.util.*;

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
        for(i=end-1;i>=start;i--){
            if(arr[i]<node.data){
                break;
            }
        }

        node.left=createBST(arr,start,i);
        node.right=createBST(arr,i+1,end-1);

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

public class BST26 {

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
left
right
root

We can observe that
In postorder the order is left right root         //{2,5,9,8,4,12,20,15,10}
so the last element in the given array is the root//10
And the first element from back that is less than root is left child    //4

So now we create BST from {2,5,9,8,4}   4 is root   2 is left child
So now we create BST from {5,9,8}
8 is root for right child   5 is root for left child    9 is right child

we create BST from {12,20,15}
15 is root
12 is root for left child
20 is right child
 */
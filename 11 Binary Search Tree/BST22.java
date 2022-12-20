//Construct Balanced BST from given values
//{8,6,12,34,23,3}
/*
        8
    6           12
3                   34
                23

The BST constructed from the given values in same order is not balanced
 */

import java.util.*;
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node constructBalancedBST(int[] arr){
        Arrays.sort(arr);

        return constructBalancedBSTUtil(arr,0,arr.length-1);
    }

    public Node constructBalancedBSTUtil(int[] arr,int start,int end){
        if(start<end){
            return null;
        }

        int mid=(start+end)/2;

        Node node=createNewNode(arr[mid]);

        node.left=constructBalancedBSTUtil(arr,start,mid-1);
        node.right=constructBalancedBSTUtil(arr,mid+1,end);

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

public class BST22 {

    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        int[] arr={8,6,12,18,34,23,3};
        root=a.constructBalancedBST(arr);

        a.inorder(root);
    }

}

/*
We sort the given array
Put the median of the sorted array as root
Then we do the same recursively to [start,median-1]
Then we do the same recursively to [median-1,end]
 */
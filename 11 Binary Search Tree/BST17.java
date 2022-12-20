//Get the kth smallest element in the BST

//import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
}

class BST{
    static int countElement=0;

    public Node getKthSmallestElementBST(Node node,int k){
        if(node==null){
            return null;
        }

        Node left=getKthSmallestElementBST(node.left,k);

        if(left!=null){
            return left;
        }

        countElement++;

        if(countElement==k){
            return node;
        }

        return getKthSmallestElementBST(node.right,k);
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

}


public class BST17{
    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);

        Node kthSmallest=a.getKthSmallestElementBST(root,3);

        if(kthSmallest!=null){
            System.out.println(kthSmallest.data);
        }else{
            System.out.println("There are more values than given value");
        }
    }
}

/*
            8
    6           15
2       7   null     20

1st small   2
2nd small   6
3rd small   7
5th small   15
8th small   null
 */

/*
Lest say we want 3rd smallest value

 */
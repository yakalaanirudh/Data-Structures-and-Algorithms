//Check if two elements of BST are same

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
}

class BST{
    public boolean checkIfTwoBSTContainSameElement(Node node1,Node node2){

        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        inorder(node1,list1);
        inorder(node2,list2);

        return list1.equals(list2);

    }

    public void inorder(Node node,List<Integer> list){
        if(node==null){
            return;
        }

        inorder(node.left,list);

        list.add(node.data);

        inorder(node.right,list);

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


public class BST19 {

    public static void main(String[] args) {
        BST a = new BST();
        Node root1 = null;

        root1 = a.insert(root1, 8);
        root1 = a.insert(root1, 3);
        root1 = a.insert(root1, 6);
        root1 = a.insert(root1, 10);
        root1 = a.insert(root1, 4);
        root1 = a.insert(root1, 7);
        root1 = a.insert(root1, 1);
        root1 = a.insert(root1, 14);
        root1 = a.insert(root1, 13);

        Node root2=null;

        root2 = a.insert(root2, 8);
        root2 = a.insert(root2, 3);
        root2 = a.insert(root2, 6);
        root2 = a.insert(root2, 10);
        root2 = a.insert(root2, 4);
        root2 = a.insert(root2, 7);
        root2 = a.insert(root2, 1);
        root2 = a.insert(root2, 14);
        root2 = a.insert(root2, 13);

        System.out.println(a.checkIfTwoBSTContainSameElement(root1,root2));

    }

}
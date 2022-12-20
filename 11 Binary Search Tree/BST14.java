//Check if there exists a pair for given sum

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
}

class BST{

    //In the below function we return true if there exists a pair for given sum false otherwise(set method)
    public boolean ifPairExists(Node node,int sum){
        HashSet<Integer> set=new HashSet<>();

        return ifPairExistsUtil(node,sum,set);
    }


    public boolean ifPairExistsUtil(Node node,int sum,HashSet<Integer> set){
        if(node==null){
            return false;
        }

        if(set.contains(sum-node.data)){    //We check if sum-node.value is in set
            return true;                    //If there return true
        }
        set.add(node.data);                 //There or not there add current node value to set

        if(ifPairExistsUtil(node.left,sum,set)){        //Go to node.left
            return true;
        }

        return ifPairExistsUtil(node.right,sum,set);    //Go to node.right
    }

    //In the below function we return true if there exists a pair for given sum false otherwise(Array method)
    //Convert BST to an inorder array
    public boolean checkIfPairExists(Node node,int sum){
        List<Integer> list=new ArrayList<>();

        inorder(node,list);
        return checkIfPairExistsUtil(sum,list);
    }

    public void inorder(Node node,List<Integer> list){
        if(node==null){
            return;
        }

        inorder(node.left,list);

        list.add(node.data);

        inorder(node.right,list);
    }

    //We start at first and last element
    private boolean checkIfPairExistsUtil(int sum,List<Integer> list){
        int start=0;
        int end=list.size()-1;

        while(start<end){           //As long as start<end
            int currentSum=list.get(start)+list.get(end);   //We take sum of two elements and start and end

            if(currentSum==sum){            //If currentsum ==required return true
                return true;
            }else if(currentSum<sum){       //If currentsum less increment start by 1 position
                start++;
            }else{                          //If currentsum less decrement end by 1 position
                end--;
            }
        }
        return false;
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

public class BST14 {

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

        System.out.println(a.ifPairExists(root,17));
        System.out.println(a.checkIfPairExists(root,17));
    }

}
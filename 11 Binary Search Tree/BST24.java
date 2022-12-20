//Get the floor and ceil value for a given value in BST

import java.util.*;
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public List<Node> getFloorAndCeil(Node node,int val){
        if(node==null){
            return new ArrayList<>();
        }

        Node floor=null;
        Node ceil=null;

        while(node!=null){
            if(val<node.data){
                ceil=node;
                node=node.left;
            }else if(val>node.data){
                floor=node;
                node=node.right;
            }else{
                ceil=floor=node;
                break;
            }
        }

        List<Node> result=new ArrayList<>();
        result.add(floor);
        result.add(ceil);

        return result;
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

public class BST24 {

    public static void main(String[] args) {
        BST a = new BST();
        Node root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 15);
        root = a.insert(root, 6);
        root = a.insert(root, 2);
        root = a.insert(root, 7);
        root = a.insert(root, 20);
        root = a.insert(root, 5);
        root = a.insert(root, 12);

        List<Node> data=a.getFloorAndCeil(root,4);

        if(data.get(0)!=null){
            System.out.println(data.get(0).data);
        }else{
            System.out.println("Floor doesnt exist");
        }

        if(data.get(1)!=null){
            System.out.println(data.get(1).data);
        }else{
            System.out.println("Ceil doesnt exist");
        }
    }

}

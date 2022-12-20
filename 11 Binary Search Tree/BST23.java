//Get inorder predecessor for a given value
class Node {
    Node left;
    Node right;
    int data;
}
class BST {

    public Node getInorderPredecessor(Node node,int val){
        if(node==null) {
            return null;
        }

        Node inorderPredecessor=null;

        while(node!=null){
            if(val<node.data){
                node=node.left;
            }else if(val>node.data){
                inorderPredecessor=node;
                node=node.right;
            }else{
                if(node.left!=null){
                    inorderPredecessor=getPredecessor(node);
                }
                break;
            }
        }
        return node!=null ?inorderPredecessor :null;
    }

    public Node getPredecessor(Node node){
        if(node==null){
            return null;
        }

        Node temp=node.left;

        while(temp.right!=null){
            temp=temp.right;
        }
        return temp;
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


public class BST23 {

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

        Node inorderPredecessor=a.getInorderPredecessor(root,20);

        if(inorderPredecessor!=null){
            System.out.println("Inorder Predecessor:" + inorderPredecessor.data);
        }else{
            System.out.println("Inorder Predecessor: doesnt exist");
        }
    }

}
/*
{2 5 6 7 8 15 20}
Inorder predecessor is the before value in the inorder array whether its smaller or greater
2   Null
25  Null as 25 doesnt exist

 */

  /*
Lets say we found value at a node
The inorder predecessor will be just smaller element

The values in the left subtree are all smaller
The value at the right most leaf node is the highest in left subtree
So as long as node.right is not null we call the node

So the inorder predecessor is rightmost left node
  */
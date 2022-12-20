//this gives inOrder succesor of the element in BST
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node getInorderSuccessor(Node node, int val) {
        if(node == null) {
            return null;
        }

        Node inorderSuccessor = null;

        while(node != null) {
            if(val < node.data) {
                inorderSuccessor = node;
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                if(node.right != null) {
                    inorderSuccessor = getSuccessor(node);
                }
                break;
            }
        }
        return node != null ? inorderSuccessor : null;
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

    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        Node temp = node.right;

        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;

    }

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }
}

public class BST10 {

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

        Node inorderSuccessor = a.getInorderSuccessor(root, 3);
        if(inorderSuccessor != null) {
            System.out.println("Inorder Successor: " + inorderSuccessor.data);
        } else {
            System.out.println("Inorder Successor doesn't exists");
        }
    }

}


/*
BST is
                                    8
                            3                   10
                    1               6                   14
                                4       7           13

//The parent for 6 is 3
//But the inorder parent for 6 is 8
//Inorder parent value should be always greater

//Inorder node successor
8   10
6   7
1   3
7  8
14  null        as  no value greater than 14
8   null        because no parent for 8
10  null        because no parent of 10>10
 */

 /*
Inorder successor is just bigger element
In Node traversal of BST the node that lies just after the given node is inorder successor
In Node traversal of BST the node that lies just before the given node is inorder predecessor

Lets say we  want for 6
6<8(root)   inorder=8   node=node.left=3
4>3         inorder=8   node=node.ight=6
6=6         node right is not null
so getsuccessor


getsuccessor function
return temp ehich is node.right
if(node.left!=null) traverse it till null and set temp to last node.left
return temp as getsuccessor

 */

 /*
Lets say we found value at a node
The inorder successor will be just bigger element

The values in the right subtree are all greater
The value at the left most leaf node is the lowest in right subtree
So as long as node.left is not null we call the node

So the inorder successor is leftmost right node
  */
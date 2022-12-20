//this gives inOrder parent of the element in BST
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public Node getInorderParent(Node node, int val) {
        if(node == null) {
            return null;
        }

        Node inorderParent = null;

        while(node != null) {
            if(val < node.data) {
                inorderParent = node;
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                break;
            }
        }

        return node != null ? inorderParent : null;
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

public class BST9 {

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

        Node inorderParentNode = a.getInorderParent(root, 3);
        if(inorderParentNode != null) {
            System.out.println("Inorder Parent: " + inorderParentNode.data);
        } else {
            System.out.println("Inorder Parent not exists");
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

//Inorder child parent
1   3
4   6
6   8
13  14
14  null        as  o value greater than 14
8   null        because no parent for 8
10  null        because no parent of 10>10
 */

 /*
Inorder parent is next highest value
                    8
            3                           10
    1               6          null             14
null    null    4       7   null    null    13      null
3 and 10 children of 8
1 and 6 children of 3
null and 14 children of 10
null and null children of 1
4 and 7 children of 6
null and null children of null
13 and null children of 14
Inorder Parent of 6    8      but parent is 3
Inorder Parent of 7    8      but parent is 6
Inorder Parent od 4    6
Inorder Parent of 13    14
Inorder parent of 14    null
Inorder Parent of 10    null because 14 not traversed yet
Parent should be greater than asked value
 */
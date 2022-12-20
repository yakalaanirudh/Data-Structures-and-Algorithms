//In this program we all the elements in the BST Inorder(Sorted Order)

//The logic is we start from the root go left till we get a null
//As soon as we get a null we will print the parent of that null node and we go right from parent
//We go through it recursively
//(If a nodes left tree is printed we will print that node and go on to print right tree)
class Node {
    Node left;
    Node right;
    int data;
}

class BST {

    public void inorder(Node node) {
        if(node == null) {      //If node is null return null
            return;
        }

        inorder(node.left);                 //Go to left
        System.out.print(node.data + " ");  //If no left print the current node
        inorder(node.right);                //Go to current nodes right
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

public class BST3 {

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

        a.inorder(root);
    }

}

/*
BST is
                                    8
                            3                   10
                    1               6                   14
                                4       7           13

//The output is 1,3,4,6,7,8,10,13,14
 */

/*
We will start at 8(root)
We will travel to the leftmost leaf node 1
To 1 left node is null (We cant print null)
so we print 1(parent) go to right which is also null(we cant print null)
Now we go parent of 1 since 3s left is done we will print 3 go to right
Travel to left most node    4
left is null so parent print 4 go right  null so we return to 4s parent 6
print 6
go to right
print 7
 */
//Convert BST to a sorted Doubly Linked List

class Node {
    Node left;
    Node right;
    int data;
}
class BST {

    Node headLinkedList;
    Node prev;
    public void bstToDoublyLinkedList(Node node){
        if(node==null) {
            return;
        }
        bstToDoublyLinkedList(node.left);

        if(prev==null){
            headLinkedList=null;
        }else{
            node.left=prev;         //When we encounter leaf node we make it head and set its prev to null and set prev's next to leaf
            prev.right=node;
        }

        prev=node;                  //Make prev current node

        bstToDoublyLinkedList(node.right);      //Go to
    }

    public void printList(){
        Node node=headLinkedList;

        while(node!=null){
            System.out.println(node.data+" ");
            node=node.right;
        }
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


public class BST21 {

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

        a.bstToDoublyLinkedList(root);
        a.printList();
    }

}
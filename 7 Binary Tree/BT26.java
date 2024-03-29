//Print Vertical Order of Binary Tree

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Node {
    Node left;
    Node right;
    int data;
}

class BinaryTree {

    public void printVerticalOrder(Node node) {
        if (node == null) {
            return;
        }
        int hd = 0;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<Integer, ArrayList<Integer>>();

        getVerticalOrder(node, hd, m);

        for (Map.Entry<Integer, ArrayList<Integer>> cm : m.entrySet()) {
            System.out.println(cm.getValue());
        }
    }

    public void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
        if (node == null) {
            return;
        }

        if (m.get(hd) == null) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(node.data);
            m.put(hd, l);
        } else {
            ArrayList<Integer> l = m.get(hd);
            l.add(node.data);
            m.put(hd, l);
        }

        getVerticalOrder(node.left, hd - 1, m);
        getVerticalOrder(node.right, hd + 1, m);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}

public class BT26 {

    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        a.printVerticalOrder(root);
    }

}
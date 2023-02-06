//Serialize & Deserialize a Binary tree

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
  }
  
  class BinaryTree {

    public void serialize(Node node, List<Integer> list) {
        if (node == null) {
            list.add(-1);
            return;
        }
        
        list.add(node.data) ;
        serialize(node.left, list);
        serialize(node.right, list);
    }

    int deSerializeIndex = 0;

    public Node deSerialize(List<Integer> pre) {
    if (pre.get(deSerializeIndex) == -1) {
        deSerializeIndex++;
        return null;
    }
    Node newNode = createNewNode(pre.get(deSerializeIndex++));
    
    newNode.left = deSerialize(pre);
    newNode.right = deSerialize(pre);

    return newNode;
    
    }


    public Node createNewNode(int val) {
      Node newNode = new Node();
      newNode.data = val;
      newNode.left = null;
      newNode.right = null;
      return newNode;
    }
  }
  
  public class BT70 {
  
    public static void main(String[] args) {
  
      BinaryTree a = new BinaryTree();
  
      Node root = a.createNewNode(2);
      root.left = a.createNewNode(7);
      root.left.left = a.createNewNode(10);
      root.left.right = a.createNewNode(6);
      root.right = a.createNewNode(9);
      root.right.right = a.createNewNode(3);

      List<Integer> list=new ArrayList<>();
      a.serialize(root,list);
    
      root=a.deSerialize(list);
    }
  }
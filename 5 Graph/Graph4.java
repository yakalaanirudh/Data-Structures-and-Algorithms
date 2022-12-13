//Depth First Search Using Adjacency List

import java.util.*;

class Graph{
    List<List<Integer>> graph;      //This means this is a list named graph whose entries are individual lists
    boolean visited[];              //This is an array of boolean values equal to number of vertices

    Graph(int nodes){
        graph =new ArrayList<>();       //We create a new array list
        visited=new boolean[nodes];     //An array of type boolean whose length is equal to number of nodes

        for(int i=0;i<nodes;i++){       //Add a new array list at every index of arraylist
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){   //means get that index a and add b to the list in that index
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void dfs(int start){
        Stack<Integer> stack=new Stack<>();

        stack.push(start);
        visited[start]=true;

        while(!stack.isEmpty()){
            Integer node=stack.pop();
            System.out.print(node+" ");

            List<Integer> neighboursList=graph.get(node);   //Get the list at that index from graphlist

            for(Integer neighbour:neighboursList){          //for each element in the graph list
                if(!visited[neighbour]){                    //if it is not visited
                    stack.push(neighbour);                  //add them to queue
                    visited[neighbour]=true;                //set visited to true
                }
            }
        }
    }
}

public class Graph4{
    public static void main(String[] args){
        int nodes=7;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(0,2);
        a.addEdge(1,3);
        a.addEdge(2,4);
        a.addEdge(3,5);
        a.addEdge(4,5);
        a.addEdge(4,6);

        a.dfs(0);
    }
}
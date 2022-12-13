//Check if undirected graph has a cycle

import java.util.*;
class Graph{
    List<List<Integer>> graph;      //This means this is a list named graph
    boolean visited[];
    int nodes;

    Graph(int nodes){
        graph =new ArrayList<>();
        visited=new boolean[nodes];
        this.nodes=nodes;

        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    //Here we are checking from nodes for every node if there is a cycle from that node
    //For the very first node(0) all are unvisited so
    //if(!visited[i])   yields true
    //we go to if(dfs(0,-1) as parent of first node is -1
    public boolean ifUndirectedGraphHasCycle(){
        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                if(dfs(i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    //dfs(0,-1)
    //set visited[0] is true
    //get adjacent list at index 0
    //the first vertex in list is 1 and it is unvisited so we go dfs(1,0)
    //we check the parent child relationship by passing parent as second paramter
    //we check if it is parent in else if block if child is not parent we return true

        else if example
        lets say graph 0 1
        start at 0
        go to 1 now at 1 next is 0
        dfs(0,-1)
            dfs(1,0)
                for one child is 0
                (0!=0) false so we return false from line 70

    */
    public boolean dfs(int index,int parent){

        visited[index]=true;

        List<Integer> children=graph.get(index);

        for(Integer child:children){
            if(!visited[child]){
                dfs(child,index);
            }else if(child!=parent){
                return true;
            }
        }
        return false;
    }
}

public class Graph12{
    public static void main(String[] args){
        int nodes=3;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);

        System.out.println(a.ifUndirectedGraphHasCycle());
    }
}

/*
Cycle means if i start from a point can i reach the same point again

Lets say there is a graph 1-2-3
when we start dfs from 1
it ll go 1
for 2 it can go to 1 or 3
but 1 is already visited so it can given there is a cycle
but we prevent it say 1 is parent of 2
parent child is only 1 level
1 is parent of 2 and 2 is parent of 3
but 1 is not parent of 3
 */
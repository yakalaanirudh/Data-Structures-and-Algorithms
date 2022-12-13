//Check if Directed Graph has cycle using InDegree BFS

import java.util.*;
class Graph{
    List<List<Integer>> graph;      //This means this is a list named graph
    boolean visited[],recursiveStack[];
    int nodes;

    Graph(int nodes){
        graph =new ArrayList<>();
        visited=new boolean[nodes];
        recursiveStack=new boolean[nodes];
        this.nodes=nodes;

        for(int i=0;i<nodes;i++){
            graph.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){
        graph.get(a).add(b);
    }

    public boolean ifDirectedGraphHasCycle(){
        for(int i=0;i<nodes;i++){
            if(dfs(i)) {
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int index){

        if(recursiveStack[index]){
            return true;
        }

        if(visited[index]){
            return false;
        }

        visited[index]=true;
        recursiveStack[index]=true;

        List<Integer> neighboursList=graph.get(index);

        for(Integer neighbour:neighboursList){
            if(dfs(neighbour)){
                return true;
            }
        }

        recursiveStack[index]=false;
        return false;
    }
}

public class Graph14{
    public static void main(String[] args){
        int nodes=4;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);
        a.addEdge(3,0);


        System.out.println(a.ifDirectedGraphHasCycle());
    }
}
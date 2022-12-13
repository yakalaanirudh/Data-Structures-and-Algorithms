//Check if directed graph has a cycle

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

        if(recursiveStack[index]){      //If true in recursive stack we return true
            return true;
        }

        if(visited[index]){         //If true in visited we return false
            return false;
        }
                                            //Else we set recursive stack and visited to true and
        visited[index]=true;
        recursiveStack[index]=true;

        List<Integer> neighboursList=graph.get(index);

        for(Integer neighbour:neighboursList){
            if(dfs(neighbour)){
                return true;                //If we visit an element which is already in recursive stack we return true
            }
        }

        recursiveStack[index]=false;        //Here we pop from recursive stack if that element has no more children
        return false;
    }
}

public class Graph13{
    public static void main(String[] args){
        int nodes=5;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);
        a.addEdge(0,3);
        a.addEdge(3,4);
        a.addEdge(4,0);

        System.out.println(a.ifDirectedGraphHasCycle());
    }
}
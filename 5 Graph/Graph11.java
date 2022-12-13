//Check if source to path exists in Directed Graph

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

    //do a dfs from the source then check in boolean list if index of destination ==true
    public boolean ifSourceConnectedToDestination(int source,int destination){
        dfs(source);

        return visited[destination];
    }
    public void dfs(int start){
        Stack<Integer> stack=new Stack<>();

        stack.push(start);
        visited[start]=true;

        while(!stack.isEmpty()){
            Integer node=stack.pop();
            System.out.print(node+" ");

            List<Integer> neighboursList=graph.get(node);

            for(Integer neighbour:neighboursList){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
    }
}

public class Graph11{
    public static void main(String[] args){
        int nodes=5;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);
        a.addEdge(3,2);
        a.addEdge(3,0);
        a.addEdge(2,4);

        System.out.println(a.ifSourceConnectedToDestination(0,3));
        System.out.println(a.ifSourceConnectedToDestination(0,2));
    }
}
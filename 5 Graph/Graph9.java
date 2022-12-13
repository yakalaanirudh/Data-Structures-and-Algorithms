//Get Connected Components in Undirected Graph

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

    public int numberOfConnectedComponent(){
        int numberOfConnectedComponent=0;

        for(int i=0;i<nodes;i++){       //we start at 0
            if(!visited[i]){            //Initially it is unvisited(0)
                this.dfs(i);            //so well do dfs for 0
                numberOfConnectedComponent++;
            }
        }

        return numberOfConnectedComponent;
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

public class Graph9{
    public static void main(String[] args){
        int nodes=7;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);
        a.addEdge(0,3);
        a.addEdge(3,2);

        System.out.println(a.numberOfConnectedComponent());
    }
}

/*
    public int numberOfConnectedComponent(){
        int numberOfConnectedComponent=0;

        for(int i=0;i<nodes;i++){
            if(!visited[i]){
                this.dfs(i);
                numberOfConnectedComponent++;
            }
        }

        return numberOfConnectedComponent;
    }

    After we do dfs from 0 all vertices that can be reached will be true

    Lets say we have 18 vertices 1-10 connected 11-15 connected 16-18 connected

    dfs 1 will make true from 1 to 10   so 1
    dfs 11 will make true from 11 to 15 so 2
    dfs 16 will make true from 16 to 18 so 3
 */

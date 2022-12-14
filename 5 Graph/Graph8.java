//Check if directed graph is strongly connected
//Array.fill(10) makes all entries of that array equal to 10
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
    }

    public boolean ifDirectedGraphStronglyConnected(){

        for(int i=0;i<nodes;i++){
            dfs(i);

            for(int j=0;j<nodes;j++){
                if(!visited[j]){
                    return false;
                }
            }

            Arrays.fill(visited,false);
        }
        return true;
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


public class Graph8{
    public static void main(String[] args){
        int nodes=7;

        Graph a=new Graph(nodes);

        a.addEdge(0,1);
        a.addEdge(1,2);
        a.addEdge(2,0);
        a.addEdge(0,3);
        a.addEdge(3,2);

        System.out.println(a.ifDirectedGraphStronglyConnected());
    }
}

//A strongly connected graph all vertices acn be reached from all vertices

//We do dfs for all vertices
//We do dfs for 1
//Set visited to true for that are reached
//To do dfs for next vertex we set all values to false by using fill
//We do dfs for 2
//Set visited to true for that are reached
//To do dfs for next vertex we set all values to false by using fill
//We do dfs for 3
//Set visited to true for that are reached
//Only if we get all true for each vertex dfs visited is the graph strongly connected
//Even if one is unvisited in any iteration we return false

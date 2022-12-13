//Dijkstras Shortest Path Problem

import java.util.*;

class Edge{         //A class edge which has the properties of the target node from one edge and the distance to it
    int targetNode;
    int distanceFromNode;

    Edge(int targetNode,int distance){
        this.targetNode=targetNode;
        this.distanceFromNode=distance;
    }
}
class Graph{        //Graph
    List<List<Edge>> graph;             //Adjacency List
    boolean visited[];                  //Visited array
    int distance[];                     //Distance Array

    Graph(int nodes){                   //Here we create a graph with given number of nodes
        graph=new ArrayList<>();        //Adjacency List
        visited=new boolean[nodes];     //Visited array
        distance=new int[nodes];        //Distance Array

        for(int i=0;i<nodes;i++){               //Add a list to every index of list
           graph.add(i,new ArrayList<>());
           distance[i]=Integer.MAX_VALUE;       //Set distance to infinity initially
        }
    }
    //At the creation of graph add edges with source destination and distance
    public void addEdge(int sourceNode,int targetNode,int distance){
        graph.get(sourceNode).add(new Edge(targetNode,distance));
    }


    public int minimumDistanceBetweenTwoNodes(int source,int destination) {
        if (source == destination){
            return 0;
        }

        //A Priority Queue whose entry is edge(target and distance)
        PriorityQueue<Edge> minHeap=new PriorityQueue<>((e1,e2) ->e1.distanceFromNode-e2.distanceFromNode);

        distance[source]=0;                     //Set source distance as 0
        minHeap.add(new Edge(0,0));     //add the edge (source(target),distance)    (0,0)

        while(!minHeap.isEmpty()){              //when heap is not empty poll the first element it has (target,dist)
            int v=minHeap.poll().targetNode;    //get the target node

            if(visited[v]){                     //If it is visited leave it
                continue;
            }

            visited[v]=true;                //Else set it as visited

            List<Edge> childList=graph.get(v);  //get the list for that node

            for(Edge child:childList){                  //for every node in that list
                int dist=child.distanceFromNode;        //get the distance property from that node
                int childNode=child.targetNode;         //get the targetNode property from that node


                //If child Node not visited AND distance to current Node+distance from current node <current Distance property in that node
                //set distance =distance to current Node+distance from current node
                //set the distance property in the node to=distance to current Node+distance from current node
                //add the element to heap
                if(!visited[childNode] && (distance[v]+dist<distance[childNode])){
                    distance[childNode]=distance[v]+dist;
                    child.distanceFromNode=distance[v]+dist;
                    minHeap.add(child);
                }
            }
        }

        return distance[destination];
    }
}

public class Graph18{
    public static void main(String[] args){
        int nodes=5;
        Graph a=new Graph(nodes);

        a.addEdge(0,1,1);
        a.addEdge(0,2,7);
        a.addEdge(1,2,5);
        a.addEdge(1,4,4);
        a.addEdge(4,3,2);
        a.addEdge(2,3,6);

        System.out.println(a.minimumDistanceBetweenTwoNodes(0,3));
    }
}
//Breadth First Search

import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Queue<Integer> q;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        q = new LinkedList<Integer>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex (int v) {
        for(int j=0; j<nVerts; j++) {
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false) {
                return j;
            }
        }
        return -1;
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        q.add(0);
        int v2;

        while(!q.isEmpty()) {
            int v1 = q.remove();
            while((v2=getAdjUnvisitedVertex(v1))!=-1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }
}

public class Graph2 {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        theGraph.addEdge(4, 5);
        theGraph.addEdge(1, 3);

        System.out.println("DFS Visits: ");
        theGraph.bfs();
        System.out.println();
    }

}

/*
class Vertex

It has two properties a label of type character vertex "A"
and a boolean which is true if that vertex is visited
It has  a constructor named vertex which takes the above two properties as arguments


class Graph
It has a property named MAX_VERTS to count number of vertices this graph can hold
It has a property named VertexList to store all given vertices in a list
The entry of an element in list is a vertex which has the properties of a vertex
Property adj Matrix to see edges occur between which edges
Property nverts to count number of vertices added
Property Queue to add the index of the vertex in the vertexList

addVertex method adds a new vertex at the next index of the list
addEdge adds edge between the given vertices
dispalyvertex prints the vertice's label at that index of list


getAdjUnvisitedVertex(int v)
at this point we added at all vertices of the graph
if there is a adjacent vertex to the vertex and it is not visited returnt the adjacent vertice's index from vertexlist


bfs
first we call bfs with the first vertex
mark it as visited in the list
print its label
add that vertex index to queue

Now as long as queue is not empty
we remove the first element from queue
we get the adjacent vertices of the given vertex that are not visited mark them as visisted in the vertexlist
print the vertex label
and add them to the queue
 */
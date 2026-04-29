import java.util.ArrayList;
import java.util.List;

public class EveryPath5 {

    public static void cycleFour(Graph wDigraph){

        // vertex from graph in list
        ArrayList<Graph.Vertex> vertices = new ArrayList<>(wDigraph.getVertices());

        // make sure to check each vertex as a start
        for(int i = 0; i < vertices.size(); i++){
            Graph.Vertex start = vertices.get(i); // current vertex
            dfsFour(wDigraph, start, start, new ArrayList<>(List.of(start)), new ArrayList<>()); // use DFS
        }

    }

    // want to use DFS because we want to follow a path to the end to check for a cycle of length 4
    public static void dfsFour(Graph wDiGraph, Graph.Vertex start, Graph.Vertex current, List<Graph.Vertex> path, List<Double> weights){

        // look at all outgoing edges of current node
        ArrayList<Graph.Edge> edges = new ArrayList<>(wDiGraph.getEdgesFrom(current));


        if(path.size() == 4){ // base case, check if cycle exists
            double totalWeight = 0.0;
            for(int i = 0; i < edges.size(); i++){
                totalWeight += weights.get(i);
            }
            for(int i = 0; i < edges.size(); i++){ // look at all outgoing edges of fourth node
                if(edges.get(i).toVertex == start){ // if point back to start, is a cycle
                    weights.add(edges.get(i).weight);
                    System.out.println("Cycle: " + path + " -> last node points to " +  start.value);


                    System.out.println("Total Weight of Path: " + totalWeight);
                    weights.remove(weights.size() - 1);
                }
            }
            return; // stop because path is length 4
        }

        // recursive case (path size < 4, because we check if path is 4 first everytime we call dfsFour)
        for(int i = 0; i < edges.size(); i++){
            Graph.Edge e = edges.get(i); // at specific outward edge...
            if(!path.contains(e.toVertex)){ // if next vertex isn't already in path
                path.add(e.toVertex);
                weights.add(e.weight);
                dfsFour(wDiGraph, start, e.toVertex, path, weights); // continue with next vertex

                //remove to try other adj nodes/vertices (backtracking w DFS)
                path.remove(path.size() - 1);
                weights.remove(weights.size() -1);
            }
        }

    }

    public static void main(String[] args){
        Graph wDigraph = new Graph();
        Graph.Vertex v0 = wDigraph.addVertex("0");
        Graph.Vertex v1 = wDigraph.addVertex("1");
        Graph.Vertex v2 = wDigraph.addVertex("2");
        Graph.Vertex v3 = wDigraph.addVertex("3");
        Graph.Vertex v4 = wDigraph.addVertex("4");

        wDigraph.addDirectedEdge(v0, v1, 1);
        wDigraph.addDirectedEdge(v1, v2, 2);
        wDigraph.addDirectedEdge(v2, v3, 3);
        wDigraph.addDirectedEdge(v3, v0, 4);
        wDigraph.addDirectedEdge(v0, v2, 5);
        wDigraph.addDirectedEdge(v2, v4, 6);
        wDigraph.addDirectedEdge(v4, v1, 7);
        wDigraph.addDirectedEdge(v1, v0, 8);

        cycleFour(wDigraph);
    }







}


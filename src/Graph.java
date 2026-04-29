import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

// Graph class as seen in the textbook


public class Graph {

    public static class Vertex{
        public String value;

        public Vertex(String value){
            this.value = value;
        }

        @Override
        public String toString(){
            return value;
        }
    }

    public static class Edge{
        Vertex fromVertex;
        Vertex toVertex;
        double weight;

        public Edge(Vertex fromVertex, Vertex toVertex, double weight){
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
            this.weight = weight;
        }
    }


    HashMap<Vertex, ArrayList<Edge>> fromEdges;
    HashMap<Vertex, ArrayList<Edge>> toEdges;

    public Graph(){
        fromEdges = new HashMap<Vertex, ArrayList<Edge>>();
        toEdges = new HashMap<Vertex, ArrayList<Edge>>();
    }

    public Collection<Edge> getEdges(){
        HashSet<Edge> edges = new HashSet<Edge>();
        for(ArrayList<Edge> edgeList : fromEdges.values()){
            edges.addAll(edgeList);
        }
        for(ArrayList<Edge> edgeList : toEdges.values()){
            edges.addAll(edgeList);
        }
        return edges;
    }

    public Collection<Vertex> getVertices(){
        return fromEdges.keySet();
    }

    public Collection<Edge> getEdgesFrom(Vertex fromVertex){
        return fromEdges.get(fromVertex);
    }

    public Collection<Edge> getEdgesTo(Vertex toVertex){
        return toEdges.get(toVertex);
    }

    public Vertex getVertex(String vertexValue){
        for(Vertex vertex : getVertices()){
            if (vertex.value.equals(vertexValue)) {
                return vertex;
            }
        }
        return null;
    }

    public Vertex addVertex(String newVertexVal){
        Vertex newVertex = new Vertex(newVertexVal);

        fromEdges.put(newVertex, new ArrayList<Edge>());
        toEdges.put(newVertex, new ArrayList<Edge>());

        return newVertex;
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
        if (hasEdge(fromVertex, toVertex)) {
            return null;
        }

        Edge newEdge = new Edge(fromVertex, toVertex, weight);

        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);

        return newEdge;
    }

    public Edge[] addUndirectedEdge(Vertex vertexA, Vertex vertexB, double weight) {
        Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
        Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
        Edge[] result = { edge1, edge2 };
        return result;
    }

    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        if (!fromEdges.containsKey(fromVertex)) {
            return false;
        }

        ArrayList<Edge> edges = fromEdges.get(fromVertex);
        for (Edge edge : edges) {
            if (edge.toVertex == toVertex) {
                return true;
            }
        }

        return false;
    }









}

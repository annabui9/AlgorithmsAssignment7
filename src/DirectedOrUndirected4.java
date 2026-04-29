import java.util.LinkedList;
import java.util.Queue;

public class DirectedOrUndirected4 {

    // Weakly connected graph is if all vertices are "reachable" if you ignore direction
    // We need to check [i][j] and [j][i] in adjacency matrix (if it is 1)

    public static boolean isWeaklyConnected(int[][] matrix, int n){
        if(n <= 1){ // if the graph is just a point, it is connected (both weakly and strongly - trivial)
            return true;
        }

        // BFS algorithm
        boolean[] visited = new boolean[n];
        Queue<Integer> toCheck = new LinkedList<>();
        int visitCount = 1;

        visited[0] = true; // starting node
        toCheck.add(0);

        while(!toCheck.isEmpty()){
            int i = toCheck.poll();

            for(int j = 0; j < n; j++){ // j would be the neighbor to the current node
                // for unvisited neighbor and if there is edge between them (either direction = 1)
                if(!visited[j] && (matrix[i][j] == 1 || matrix[j][i] == 1)){
                    visited[j] = true;
                    toCheck.add(j);
                    visitCount++;
                }
            }
        }
        return visitCount == n; // means that all nodes were able to be visited
    }


    public static void main(String[] args){
        // Weakly Connected
        int[][] weak = {
                {0,1,0},
                {0,0,0},
                {0,1,0}

        };
        int weakN = 3;
        if(isWeaklyConnected(weak,weakN)){
            System.out.println("The graph is weakly connected WOOHOO!");
        }else{
            System.out.println("The graph is not weakly connected BOOO!");
        }

        // Strongly Connected (is also be weakly connected)
        int[][] strong = {
                {0,1,1},
                {1,0,1},
                {1,1,0}

        };
        int strongN = 3;
        if(isWeaklyConnected(strong,strongN)){
            System.out.println("The graph is weakly connected WOOHOO!");
        }else{
            System.out.println("The graph is not weakly connected BOOO!");
        }

    }

}

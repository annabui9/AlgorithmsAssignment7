import java.lang.reflect.Array;
import java.util.ArrayList;

public class DrawGraph6 {

    public static int[][] returnAdjMatrix(String s){

        String[] arrayS = s.split(" "); // adding elements into array, separated by spaces
        int n = arrayS.length;

        int[][] adjMatrix = new int[n][n]; // creating adjacency matrix

        if(s.equals(" ") || s.equals("")){ // handling empty input
            System.out.println("Empty String!");
        }

        for(int i = 0; i < n; i++){ // for each element in the array (each vertex)
            // looking at example as reference, x mod n is what gets correct index of adjacent vertex
            int right = (2*i + 1) % n;
            int left = (2*i + 2) % n;

            //updating matrix value for each row
            adjMatrix[i][right] = 1;
            adjMatrix[i][left] = 1;
        }
        return adjMatrix;
    }

    public static void printMatrix(int[][] adjMatrix){

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){

        String s = "ANT CUN BOG AMA DC TOL SAN";
        System.out.println("Adjacency Matrix: ");
        printMatrix(returnAdjMatrix(s));


    }





}

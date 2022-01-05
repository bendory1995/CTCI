import java.util.*;

public class ZeroMatrix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int [][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = (int)(Math.random() * 50);
            }
        }
        printMatrix(matrix);
        zeroMatrix(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(int [][] matrix){
        for(int i = 0; i < matrix.length; i++ ){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print( "  |  " + matrix[i][j] + "  |  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public static void zeroMatrix(int [][]matrix){ 
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();


        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

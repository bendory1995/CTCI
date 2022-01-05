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
        zeroMatrixEfficient(matrix);
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
    public static void zeroMatrixEfficient(int [][] matrix){
        boolean firstRow = false;
        boolean firstCol = false;

        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0]. length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }        
        }

        if(firstRow == true){
            for(int i = 0; i < matrix.length; i++){
                matrix[0][i] = 0;
            }
        }

        if(firstCol == true){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[i][0]= 0;
            }
        }



    }
}

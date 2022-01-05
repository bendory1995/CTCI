import java.util.*;
public class RotateMatrix {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [][] square = new int[n][n];
        int indexNum = 0;
        for(int i = 0; i <square.length; i++){
            for(int j = 0; j < square[0].length; j++){
                square[i][j] = indexNum;
                indexNum++;
            }
        }

        int [][] rotated = new int [n][n];
        printSquare(square);
        System.out.println();
        //rotated = rotate90(square, n);
        rotated = rotate90Efficient(square);
        printSquare(rotated);
        rotated = rotate90(rotated, n);
        printSquare(rotated);
        rotated = rotate90(rotated, n);
        printSquare(rotated);
        rotated = rotate90(rotated, n);
        printSquare(rotated);
    }

    public static void printSquare(int [][] square){
        for(int i = 0; i <square.length; i++){
            for(int j = 0; j < square[0].length; j++){
                System.out.print(" | " + square[i][j] + " | ");
            }
            System.out.println();
            
        }
        System.out.println();

    }

    public static int[][] rotate90(int [][] square, int n){
        int [][] rotated = new int [n][n];
        int location = 0;
        int k = 0;
        for(int i = square[0].length-1; i >= 0; i--){
            int l = 0;
            for(int j = 0; j < square.length; j++){
                rotated[j][i] = square[k][l];
                location++;
                l++;
            }
            k = k + 1;
        }
        return rotated;
    }
    //Better in space complexity because we change in place. 
    public static int[][] rotate90Efficient(int [][] square){
        int n = square.length; 
        //transpose 
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = square[i][j];
                square[i][j] = square[j][i];
                square[j][i] = temp;
            }
        }
        //swap
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = square[i][j];
                square[i][j] = square[i][n-1-j];
                square[i][n-1-j] = temp;
            }
        }
        return square;
    }
}

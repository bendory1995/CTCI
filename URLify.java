import java.util.Scanner;
import java.util.*;
public class URLify {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        int input = scanner.nextInt();

        System.out.println(urlify(s1, input));
    }
    public static String urlify(String s1, int input){
        char[] arr = new char[input];
        

        int i = input-1;
        while(s1.charAt(i) == ' '){
            i--;
        }
        int index = input-1;
        while(i >= 0){
            if(s1.charAt(i) == ' '){
                arr[index] = '0';
                arr[--index] = '2';
                arr[--index] = '%';
            }
            else{
                arr[index] = s1.charAt(i);
            }
            i--;
            index--;
        }
        return new String(arr);
    } 
    // public static void printChar(char [] arr){
    //     for(int i = 0; i < arr.length; i++){
    //         System.out.print(arr[i]);
    //     }
    //     System.out.println();
    // }
}

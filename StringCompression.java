import java.util.*;
public class StringCompression{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String compressed = compress(string);

        System.out.println((string.length() <= compressed.length() ? string : compressed)); 
        
    }
    //compress function
    public static String compress(String string){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int count = 1;
        char prev = string.charAt(0);
        
        while(i < string.length()){
            if(string.charAt(i) == prev){
                count++;
            }else{
                sb.append(prev);
                sb.append(count);
                prev = string.charAt(i);
                count = 1;
            }
            if(sb.length() > string.length()){
                return sb.toString();
            } 
            i++;
        }
        sb.append(prev);
        sb.append(count);
        return sb.toString();
    }
}
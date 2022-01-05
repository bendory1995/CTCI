import java.util.*;

public class PalindromePermutation{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        System.out.println(isPalPerm(s));
    }

    public static boolean isPalPerm(String s){
        s = s.toLowerCase();
        s = s.replaceAll("\\s", "");

        int [] charArr = new int[128];

        for(int i = 0; i < s.length(); i++){
                charArr[s.charAt(i)]++;
        }
        int limit = 0;
        for(int i = 0; i < 128; i++){
            if(charArr[i]%2 != 0){
                limit++;
                if(limit > 1) return false;
            }
        }
        return true;
    }

}
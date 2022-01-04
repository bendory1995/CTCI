import java.util.Arrays;
public class CheckPermutation{
    public static void main(String args[]){
        String s1 = args[0];
        String s2 = args[1];

        System.out.println(checkPermutation(s1, s2));
    }
    
    public static boolean checkPermutation(String s1, String s2){
        //hashmap could be used. 
        //could use array ?
        //could also order the string then compare nlogn

        //initialized to all 0;
        //will increment one character by character
        //then compare the arrays. 


        //Solution 1
        // if(s1.length() != s2.length()) return false;

        // int s1Arr[] = new int[128];
        // int s2Arr[] = new int[128];

        // //s1 loop
        // for(int i = 0; i < s1.length(); i++){
        //     s1Arr[s1.charAt(i)]++;
        // }

        // for(int i = 0; i < s2.length(); i++){
        //     s2Arr[s2.charAt(i)]++;
        // }

        // for(int i = 0; i < s1Arr.length; i++){
        //     if(s1Arr[i]!= s2Arr[i]) return false;
        // }
        // return true;



        //Solution 2 - Less Efficient but clean
        if(s1.length() != s2.length()) return false;
        return (sort(s1).equals(sort(s2)));
    }
    public static String sort(String s){
        char [] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
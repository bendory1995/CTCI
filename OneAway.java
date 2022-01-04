import java.util.*;
public class OneAway{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(oneaway(s1, s2));
    }

    public static boolean oneaway(String s1, String s2){
        return (oneAdded(s1, s2) || oneAdded(s2, s1) || isReplaced(s1,s2));

    }
    //inserting a character and deleting a character is 
    //essentially the same if we know which is shorter string 
    public static boolean oneAdded(String s1, String s2){
        //we just need to make sure that s1 is the shorter one
        if(s1.length() > s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }


        if(s2.length() - s1.length() > 1) return false;
        int shortIndex = 0;
        int longIndex = 0;

        int difference = 0;
        while(longIndex < s2.length() && shortIndex < s1.length()){
            if(s1.charAt(shortIndex) != s2.charAt(longIndex)){
                longIndex++;
                difference++;
            }
            shortIndex++;
            longIndex++;
        }
        
        if(difference > 1){
            return false;
        }
        return true;


    }

    public static boolean isReplaced(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        
        int count = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
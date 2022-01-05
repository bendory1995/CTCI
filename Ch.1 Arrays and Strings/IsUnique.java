public class IsUnique{
    public static void main(String args[]){
        String s = args[0];
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String s){
        boolean [] charArr = new boolean [128];

        for(int i = 0; i < s.length(); i++){
            if(charArr[s.charAt(i)]){
                return false;
            }
            else{
                charArr[s.charAt(i)] = true;
            }
        }
        return true;
    }
}
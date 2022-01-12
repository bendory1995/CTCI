import java.util.Stack;
public class SortStack {
    public static void main(String[] args){

    }    

    public static void sort(Stack<Integer> s){
        Stack<Integer> r = new Stack<Integer>();
        
        //as long as there are elements to sort, keep looping through. 
        while(!s.isEmpty()){
            int tmp = s.pop();
            //as long as stack is not empty and the top is greater than temp val, 
            //keep popping and pushing to the other stack
            while(!r.isEmpty() && r.peek() > tmp){
                s.push(r.pop());
            }
            //push the temp value to the sorted Stack
            r.push(tmp);
        }

        while(!r.isEmpty()){
            s.push(r.pop());
        }
    }
}

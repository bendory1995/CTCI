import java.util.*; 
public class MinStack {
    public static void main(String[] args){
        MinimumStack minStack = new MinimumStack();

        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());

        minStack.push(5);
        System.out.println(minStack.getMin());

        minStack.push(1);
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());


        
    }   

    
}

class MinimumStack{


    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    void push(int x){
        if(minStack.isEmpty() || x < minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }
    void pop(){
        if(!stack.isEmpty() && stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    int top(){
        return stack.peek();
    }
    int getMin(){
        return minStack.peek();
    }


}
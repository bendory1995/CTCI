public class StackOfPlates {
    public static void main(String[] args){
        
    }

}

class PlatesStack{
    ArrayList<Stack> stacks = new ArrayList<Stack>();


    void push(int x){
        Stack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(x);
        }else{
            Stack stack = new Stack(capacity);
            stack.push(x);
            stacks.add(stack);
        }
    }

    int pop(){
        Stack last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int v = last.pop();
        if(last.size == 0) stacks.remove(stacks.size()-1);
        return v;
    }
}

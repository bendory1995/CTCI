import javax.sound.sampled.BooleanControl;

public class DeleteMiddleNode {
    public static void main(String[] args){

    }

    public static boolean deleteMiddleNode(Node node){
        if(node == null || node.next == null) return false;

        //save next node
        //then change current node value 
        //then point current node to nextNode's next node.
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        return true;
    }
}

class Node{
    Node next = null;
    int data;

    Node(int d){
        data = d;
    }
    void appendToLast(int d){
        Node endNode = new Node(d);
        Node head = this;

        while(head.next!= null){
            head = head.next;
        }
        head.next= endNode;
    }
}

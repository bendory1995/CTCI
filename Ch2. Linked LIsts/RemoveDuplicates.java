import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Node node = new Node(5);
        node.appendToTail(10);
        node.appendToTail(1);
        node.appendToTail(3);
        node.appendToTail(8);
        printNode(node);
    }

    public static void printNode(Node head){
        if(head == null) return;

        while(head.next != null){
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.print(head.data);
    }
}
class Node{
    Node next = null;
    int data;

    public Node(int d){
        data = d;
    }

    void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next  != null){
            n = n.next;
        }
        n.next = end;
    }
}
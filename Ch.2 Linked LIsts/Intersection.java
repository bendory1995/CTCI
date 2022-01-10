import java.util.*;

public class Intersection {
    public static void main(String[] args){
        // Scanner scanner = new Scanner(System.in);
        // int num1 = scanner.nextInt();
        // int num2 = scanner.nextInt();
    
        Node firstNode = new Node(0);
        Node secondNode = new Node(0);
        Node temp = firstNode;


    }

    public static void printNode(Node node){
        while(node.next != null){
            System.out.print(" --> " + node.data);
            node = node.next;
        }
        System.out.print(node.data);
        System.out.println();
        System.out.println();
    }
}
class Node{
    int data; 
    Node next = null;

    Node(int x){
        this.data = x;
    }

    void appendToLast(int x){
        Node endNode = new Node(x);
        Node head = this;

        while(head.next != null){
            head = head.next;
        }
        head.next = endNode;
    }


}
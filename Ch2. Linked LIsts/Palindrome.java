import java.util.*;
public class Palindrome {
    public static void main(String[] args){
        Node head = new Node(0);
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();

        for(int i = 0; i < numNodes; i++){
            head.appendToLast(scanner.nextInt());
        }

        System.out.println(isPalindrome(head.next));

        
    }

    public static boolean isPalindrome(Node node){
        Node reversed = reversedNode(node);
        return isEqual(node, reversed);
        

    }
    public static Node reversedNode(Node node){
        Node head = null;

        while(node != null){
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(Node node, Node reversed){
        while(node!= null && reversed!= null){
            if(node.data != reversed.data) return false;
            node = node.next;
            reversed = reversed.next;
        }
        return (node == null && reversed == null);
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
        Node node = this;

        while(node.next!= null){
            node = node.next;
        }
        node.next = endNode;
    }
}

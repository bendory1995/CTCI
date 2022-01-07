import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args){

        Node node = new Node(5);
        node.appendToTail(10);
        node.appendToTail(1);
        node.appendToTail(3);
        node.appendToTail(8);
        node.appendToTail(1);
        node.appendToTail(7);
        node.appendToTail(8);
        node.appendToTail(15);
        node.appendToTail(0);
        node.appendToTail(90);
        node.appendToTail(10);

        printNode(node);
        removeDuplicates(node);
        //removeDuplicatesTradeOff(node);
        printNode(node);
    }

    //This would take O(n) but would require extra space O(n)
    public static Node removeDuplicates(Node head){
        Node prev = null;
        Set<Integer> hs = new HashSet<Integer>();
        
        while(head!= null){
            if(hs.contains(head.data)){
                prev.next = head.next;
            }
            else{
                hs.add(head.data);
                //why is prev = head here instead of out of the else statement? 
                prev = head;
            }
            head = head.next;
        }
        return head;
    }

    //This would take O(n^2) but no extra space is required.
    public static Node removeDuplicatesTradeOff(Node head){
        //pointer 1 and pointer 2.
        Node p1 = head;

        while(p1.next != null){
            Node p2 = p1;
            while(p2.next != null){
                if(p1.data == p2.next.data){
                    p2.next = p2.next.next;
                }
                else{
                    //why is p2 = p2.next here instead of out of the else statement? 
                    p2 = p2.next;
                }  
            }
            p1 = p1.next;
        }

        return head;
    }


    public static void printNode(Node head){
        if(head == null) return;

        while(head.next != null){
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.println();
        System.out.println();
    }
}
class Node{
    Node next = null;
    int data;

    public Node(int d){
        data = d;
    }

    void appendToTail(int d){
        Node endNode = new Node(d);
        Node n = this;
        while(n != null){
            n = n.next;
        }
        n.next = endNode;
    }
}
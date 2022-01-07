import java.util.*;
public class ReturnKthToLast {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        Node node = new Node(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.append(5);
        node.append(6);
        node.append(7);
        node.append(8);
        node.append(9);
        node.append(10);
        printNode(node);
        //System.out.println(k + "th item to last is " + returnKthToLast(node, k));
        System.out.println(k + "th item to last is " + returnKthToLastRecursive(node, k));
    }
    public static void printNode(Node head){
        while(head.next!= null){
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.println();
        
    }
    public static int returnKthToLast(Node head, int k){
        Node p1 =  head;
        Node p2 = head;

        for(int i = 0; i < k; i++){
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }

    public static int returnKthToLastRecursive(Node head, int k){
        if(head == null) return 0;

        int index = returnKthToLast(head.next, k) + 1;
        if(index == k){
            System.out.println(k + "th to last node is "  + head.data);
        } 
        return index;
    }


}
class Node{
    Node next = null;
    int data;

    public Node(int d){
        data = d;

    }

    void append(int d){
        Node endNode = new Node(d);
        Node n = this;

        while(n.next != null){
            n = n.next;
        }
        n.next = endNode;
    }
}
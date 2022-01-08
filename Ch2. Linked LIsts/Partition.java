import java.util.*;
public class Partition {
    public static void main(String[] args){
        Node head = new Node(1);
        Scanner scanner = new Scanner(System.in);   
        int x = scanner.nextInt();
        int partitionNum = scanner.nextInt();
        for(int i = 0; i < x; i++){
            int randomNum = (int)(Math.random()*100);
            head.appendToLast(randomNum);
        }
        printNode(head);

        System.out.println("-------------------------------------");
        printNode(partition(head,partitionNum));
    }

    public static void printNode(Node head){
        System.out.print("?");
        if(head == null) return;

        while(head.next != null){
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.print(head.data);
        System.out.println();
        System.out.println();
    }
    //Create a head and a tail
    //if it's less than the number, node.next = head. Then change head. head = node;
    //if it's not less than the number, tail.next = node. Then change tail. tail = node;
    //after the loop, tail.next should be null. return head.
    public static Node partition(Node node, int x){
        Node head = node;
        Node tail = node;

        while(node != null){
            Node next = node.next;
            if(node.data < x){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

}

class Node{
    int data;
    Node next = null;

    Node(int d){
        data = d;
    }

    void appendToLast(int d){
        Node endNode = new Node(d);
        Node cur = this;

        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = endNode;
    }

}
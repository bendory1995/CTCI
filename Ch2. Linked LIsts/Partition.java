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

    public static Node partition(Node head, int partitionNum){
        Node early = head;
        Node late = head;

        while(head != null){
            Node nextNode = head.next;

            if(head.data < partitionNum){
                head.next = early;
                early = head;
            }else{
                late.next = head;
                late = head;
            }
            head = nextNode;
        }
        late.next = null;
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
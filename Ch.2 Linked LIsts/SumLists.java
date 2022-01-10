import java.util.*;
public class SumLists {
    public static void main(String [] args){
        Node n1 = new Node((int)(Math.random()*9));
        Node n2 = new Node((int)(Math.random()*9));

        Scanner scanner = new Scanner(System.in);   
        int x = scanner.nextInt();
        for(int i = 1; i < x; i++){
            int randomNum = (int)(Math.random()* 9);
            n1.appendToLast(randomNum);
        }
        printNode(n1);
        for(int i = 1; i < x; i++){
            int randomNum = (int)(Math.random()* 9);
            n2.appendToLast(randomNum);
        }
        printNode(n2);

        printNode(sumLists(n1,n2));


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


    public static Node sumLists(Node n1, Node n2){
        Node l1 = n1;
        Node l2 = n2;
        Node dummyHead = new Node(0);
        Node l3 = dummyHead;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum = sum / 10;

            if(l1 != null){
                sum = sum + l1.data;
                l1= l1.next;
            }
            if(l2 != null){
                sum = sum + l2.data;
                l2 = l2.next;
            }
            l3.next = new Node(sum%10);
            l3 = l3.next;
        }

        if(sum / 10 == 1){
            l3.next = new Node(1);
        }
        return dummyHead.next;
    }

}

class Node{
    Node next = null;
    int data;

    Node(int x){
        data = x;
    }

    void appendToLast(int x){
        Node endNode = new Node(x);
        Node node = this;

        while(node.next != null){
            node = node.next;
        }
        node.next = endNode;
    }
}
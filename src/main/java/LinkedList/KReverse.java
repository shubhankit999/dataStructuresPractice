package LinkedList;

public class KReverse {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.head = new Node(4);
        singleLinkedList.head.next = new Node(5);
        singleLinkedList.head.next.next = new Node(6);
        singleLinkedList.head.next.next.next = new Node(7);
        singleLinkedList.head.next.next.next.next = new Node(8);
        singleLinkedList.head.next.next.next.next.next = new Node(9);

        //Node n = singleLinkedList.kReverseList(singleLinkedList.head, 3);
        Node n = singleLinkedList.reverseList(singleLinkedList.head);
        singleLinkedList.printList(n);
    }
}

package LinkedList;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.head = new Node(2);
        singleLinkedList.head.next = new Node(3);
        singleLinkedList.head.next.next = new Node(4);
        singleLinkedList.head.next.next.next = new Node(9);
        singleLinkedList.head.next.next.next.next = new Node(8);
        singleLinkedList.head.next.next.next.next.next = new Node(27);

        Node n = singleLinkedList.rearrange(singleLinkedList.head);
        //singleLinkedList.printList(singleLinkedList.head);
    }
}

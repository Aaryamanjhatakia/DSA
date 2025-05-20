// Recursive Java program to reverse a linked list

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

class Reverse_LL_recursive {
    // Given the head of a list, reverse the list
    // and return the head of reversed list
    static Node reverseList(Node head) {

        // If we have reached last node or linked
        // list is empty, return head of linked list
        if (head == null || head.next == null)
            return head;

        // reverse the rest of linked list and put
        // the first element at the end
        Node rest = reverseList(head.next);

        // Make the current head as last node of
        // remaining linked list
        head.next.next = head;

        // Update next of current head to NULL
        head.next = null;

        // Return the reversed linked list
        return rest;
    }

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }
}

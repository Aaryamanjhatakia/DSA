
import java.util.HashMap;

// Node class to represent
// elements in the linked list
class Node {
    // Data stored in the node
    int data;
    // Pointer to the next node
    Node next;
    // Pointer to a random node in the list
    Node random;

    // Constructors for Node class
    Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    Node(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }

    Node(int x, Node nextNode, Node randomNode) {
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class Main {
    // Function to clone the linked list
    public static Node cloneLL(Node head) {
        Node temp = head;
        // Create a HashMap to map original nodes
        // to their corresponding copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copies of each
        // node and store them in the map
        while (temp != null) {
            // Create a new node with the
            // same data as the original node
            Node newNode = new Node(temp.data);
            // Map the original node to its
            // corresponding copied node in the map
            map.put(temp, newNode);
            // Move to the next node in the original list
            temp = temp.next;
        }

        temp = head;
        // Step 2: Connect the next and random
        // pointers of the copied nodes using the map
        while (temp != null) {
            // Access the copied node corresponding
            // to the current original node
            Node copyNode = map.get(temp);
            // Set the next pointer of the copied node
            // to the copied node mapped to the
            // next node in the original list
            copyNode.next = map.get(temp.next);
            // Set the random pointer of the copied node
            // to the copied node mapped to the
            // random node in the original list
            copyNode.random = map.get(temp.random);
            // Move to the next node in the original list
            temp = temp.next;
        }

        // Return the head of the
        // deep copied list from the map
        return map.get(head);
    }

    // Function to print the cloned linked list
    public static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: nullptr");
            }
            System.out.println();
            // Move to the next node in the list
            head = head.next;
        }
    }

    // Main function
    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        Node clonedList = cloneLL(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}

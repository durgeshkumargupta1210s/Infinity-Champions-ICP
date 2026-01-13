package Day9_HomeAssigment_Linked_List;

// ---------------------- LIST NODE DEFINITION ----------------------
/**
 * Definition for singly-linked list node
 */
class ListNode {
    int val;          // value stored in the node
    ListNode next;    // reference to the next node

    // Default constructor
    ListNode() {}

    // Constructor with value
    ListNode(int val) { 
        this.val = val; 
    }

    // Constructor with value and next node reference
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

// ---------------------- MAIN CLASS ----------------------
public class LC_83_Remove_Duplicates_from_Sorted_List {

    /**
     * Function to remove duplicates from a sorted linked list
     *
     * Logic:
     * - Traverse the list with a pointer 'current'.
     * - If current.val == current.next.val → skip the duplicate by pointing
     *   current.next to current.next.next
     * - Else → move current forward
     *
     * @param head - head of the sorted linked list
     * @return head of the updated list without duplicates
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null; // empty list

        ListNode current = head;

        // Traverse until the end of the list
        while (current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found → skip the next node
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }

        return head;
    }

    /**
     * Helper method to print the linked list
     * Example output: 1 -> 2 -> 3
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> "); // arrow between nodes
            current = current.next;
        }
        System.out.println(); // new line after printing the list
    }

    // ---------------------- TESTING ----------------------
    public static void main(String[] args) {
        // Example: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1, 
                            new ListNode(1, 
                                new ListNode(2, 
                                    new ListNode(3, 
                                        new ListNode(3)))));
        
        System.out.print("Original List: ");
        printList(head);

        // Remove duplicates
        head = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}

package Day9_HomeAssigment_Linked_List;

// ---------------------- LIST NODE DEFINITION ----------------------
/**
 * Definition for singly-linked list node
 */
class ListNode {
    int val;          // value stored in the node
    ListNode next;    // reference to the next node

    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

// ---------------------- MAIN CLASS ----------------------
public class LC_143_Reorder_List {

    /**
     * Reorder linked list in the following pattern:
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
     *
     * Steps:
     * 1. Find the middle of the list
     * 2. Reverse the second half of the list
     * 3. Merge the two halves alternately
     *
     * @param head - head of the linked list
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return; // empty or single-node list

        // Step 1: Find the middle of the linked list using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;      // moves 1 step
            fast = fast.next.next; // moves 2 steps
        }

        // Step 2: Reverse the second half of the list
        ListNode second = reverseList(slow.next);
        slow.next = null; // split the list into two halves

        // Step 3: Merge the first half and reversed second half
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;  // store next node of first half
            ListNode temp2 = second.next; // store next node of second half

            first.next = second;  // link first node to second node
            second.next = temp1;  // link second node to next node of first half

            first = temp1;        // move first pointer forward
            second = temp2;       // move second pointer forward
        }
    }

    /**
     * Helper method to reverse a linked list
     * @param head - head of list to reverse
     * @return new head of reversed list
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // temporarily store next node
            curr.next = prev;              // reverse current pointer
            prev = curr;                   // move prev forward
            curr = nextTemp;               // move curr forward
        }

        return prev; // new head of reversed list
    }

    /**
     * Helper method to print linked list
     */
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // ------------------- TESTING -------------------
    public static void main(String[] args) {
        // Example linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Original List: ");
        printList(head);

        reorderList(head);

        System.out.print("Reordered List: ");
        printList(head); // Expected output: 1 -> 4 -> 2 -> 3
    }
}

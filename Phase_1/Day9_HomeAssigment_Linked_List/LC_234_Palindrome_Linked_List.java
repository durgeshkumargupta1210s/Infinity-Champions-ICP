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
public class LC_234_Palindrome_Linked_List {

    /**
     * Function to check if a singly-linked list is a palindrome
     *
     * Steps:
     * 1. Find the middle of the list using slow and fast pointers.
     * 2. Reverse the second half of the list.
     * 3. Compare the first half and reversed second half.
     * 4. (Optional) Restore the list to original order.
     *
     * @param head - head of the linked list
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // empty or single node

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;      // move 1 step
            fast = fast.next.next; // move 2 steps
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);

        // Step 3: Compare first half and reversed second half
        ListNode p1 = head;         // pointer to first half
        ListNode p2 = secondHalf;   // pointer to reversed second half
        boolean palindrome = true;

        while (p2 != null) {
            if (p1.val != p2.val) { // mismatch found
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4 (optional): Restore the list to its original form
        slow.next = reverseList(secondHalf);

        return palindrome;
    }

    /**
     * Helper method to reverse a linked list
     * @param head - head of the list to reverse
     * @return new head of reversed list
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

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
        // Example linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.print("Linked List: ");
        printList(head);

        System.out.println("Is Palindrome? " + isPalindrome(head));
    }
}

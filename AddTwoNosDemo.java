// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {} 
    ListNode(int val) { this.val = val; } 
    ListNode(int val, ListNode next) { this.val = val; this.next = next; } 
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify list operations
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;  // Pointer to traverse and build the result list
        int carry = 0;  // Store carry for values greater than 9

        // Traverse both lists while at least one is non-null
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // Get value from l1 (or 0 if null)
            int y = (l2 != null) ? l2.val : 0; // Get value from l2 (or 0 if null)
            int sum = x + y + carry; // Sum of digits

            carry = sum / 10;  // Extract carry
            curr.next = new ListNode(sum % 10); // Store last digit in new node
            curr = curr.next; // Move to next node

            // Advance l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's a remaining carry, add a new node
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;  // Return the sum list, skipping dummy node
    }
}

// Separate class with the main function
class AddTwoNosDemo{
    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next; // Return actual linked list head
    }

    // Helper function to print a linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example: l1 = [2,9,8] (Represents 892), l2 = [8,10,3] (Represents 3108)
        int[] arr1 = {2, 9, 8};
        int[] arr2 = {5, 1, 4};

        ListNode l1 = createLinkedList(arr1);
        ListNode l2 = createLinkedList(arr2);

        System.out.print("l1: ");
        printLinkedList(l1);
        System.out.print("l2: ");
        printLinkedList(l2);

        // Perform addition
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result linked list
        System.out.print("Result: ");
        printLinkedList(result);
    }
}

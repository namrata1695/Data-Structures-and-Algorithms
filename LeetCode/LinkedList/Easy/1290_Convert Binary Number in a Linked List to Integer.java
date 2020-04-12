Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) 
    {
        ListNode current = head;
        int length=0;
        while(current != null)
        {
            length++;
            current = current.next;
        }
        
        int counter = length - 1;
        int decimalValue = 0;
        //reusing the variable
        current = head;
        while(current!=null)
        {
            decimalValue = decimalValue + (current.val * (int)Math.pow(2, counter));
            counter--;
            current = current.next;
        }
        
        return decimalValue;
    }
}
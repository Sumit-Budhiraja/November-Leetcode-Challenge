class Solution {
    public int getDecimalValue(ListNode head) {
        return recursive(head, 0);
    }
    
    private int recursive(ListNode head, int num) {
        return head == null ? num : recursive(head.next, 2 * num + head.val);
    }
}
// Iterative

// class Solution {
//     public int getDecimalValue(ListNode head) {
//         int num = 0;
//         while(head != null) {
//             num = num * 2 + head.val; // num = num << 1 | head.val;
//             head = head.next;
//         }
//         return num;
//     }
// }
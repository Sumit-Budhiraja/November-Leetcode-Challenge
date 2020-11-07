class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = listToStack(l1);
        Stack<Integer> s2 = listToStack(l2);
        
        ListNode head = null;
        int carry = 0;
        while(s1.size() > 0 || s2.size() > 0 || carry != 0) {
            int sum = carry;
            if(s1.size() > 0) sum += s1.pop();
            if(s2.size() > 0) sum += s2.pop();
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
        }
        
        return head;
    }
    
    private Stack<Integer> listToStack(ListNode l) {
        Stack<Integer> stack = new Stack();
        while(l != null) {
            stack.add(l.val);
            l = l.next;
        }
        return stack;
    }
}
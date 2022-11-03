public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Refactor {
    public ListNode deleteMiddle(ListNode head) {
        ListNode middle = findMiddle(head);
        if (middle == head) return null;
        if (middle == head.next && middle.next == null) {
            head.next = null;
            return head;
        }
        deleteNode(middle);
        return head;
    }

    private void deleteNode(ListNode middle) {
        middle.val = middle.next.val;
        middle.next = middle.next.next;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode current = head;
        ListNode middleNode = head.next;
        if (middleNode.next == null) {
            head.next = null;
            return head;
        }
        current = middleNode;
        int size = 2, middleIndex = 1;
        while (current.next != null) {
            size++;
            if (size % 2 == 0) {
                middleIndex++;
                middleNode = middleNode.next;
            }
            current = current.next;
        }
        middleNode.val = middleNode.next.val;
        middleNode.next = middleNode.next.next;
        return head;
    }
}

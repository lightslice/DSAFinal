package July72026;

import java.util.*;

public class RemoveNthNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int length = 0;
        for (ListNode node = head; node != null; node = node.next) length++;

        int indexToRemove = length - n;
        if (indexToRemove <= 0) return head.next;

        ListNode prev = head;
        for (int i = 0; i < indexToRemove - 1 && prev != null; i++) prev = prev.next;

        if (prev != null && prev.next != null) prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sz = sc.nextInt();

        ListNode head = null, tail = null;
        for (int i = 0; i < sz; i++) {
            int v = sc.nextInt();
            ListNode node = new ListNode(v);
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }

        int n = sc.nextInt();
        ListNode res = removeNthFromEnd(head, n);

        StringBuilder sb = new StringBuilder();
        while (res != null) {
            sb.append(res.val).append(' ');
            res = res.next;
        }
        System.out.println(sb.toString().trim());
    }
}
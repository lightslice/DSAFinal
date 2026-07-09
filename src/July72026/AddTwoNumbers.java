package July72026;

import java.util.*;

public class AddTwoNumbers {

    static class Node {
        int data;
        Node next;
        Node(int val) { data = val; }
    }

    static Node add(Node head, Node head1) {
        List<Integer> digits = new ArrayList<>();
        int carry = 0;

        while (head != null || head1 != null || carry != 0) {
            int sum = carry;
            if (head != null) { sum += head.data; head = head.next; }
            if (head1 != null) { sum += head1.data; head1 = head1.next; }
            digits.add(sum % 10);
            carry = sum / 10;
        }

        Node head2 = null, tail = null;
        for (int d : digits) {
            Node node = new Node(d);
            if (head2 == null) head2 = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head2;
    }

    static Node createList(int n, Scanner sc) {
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) head = tail = node;
            else { tail.next = node; tail = node; }
        }
        return head;
    }

    static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.data).append(' '); head = head.next; }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createList(sc.nextInt(), sc);
        Node head1 = createList(sc.nextInt(), sc);
        printList(add(head, head1));
    }
}
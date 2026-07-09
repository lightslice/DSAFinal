package July82026;

import java.util.*;

public class ShortestSubarray {

    static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];

        int minLength = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int j = 0; j <= n; j++) {
            while (!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, j - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(j);
        }

        return minLength <= n ? minLength : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        System.out.println(shortestSubarray(nums, k));
    }
}
package July82026;

import java.util.*;

public class PostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    static void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;

        if (n > 0) {
            Queue<TreeNode> queue = new LinkedList<>();
            root = new TreeNode(sc.nextInt());
            queue.offer(root);

            for (int i = 1; i < n; i++) {
                TreeNode parent = queue.poll();
                if (parent == null) break;

                int leftVal = sc.nextInt();
                if (leftVal != -1) {
                    parent.left = new TreeNode(leftVal);
                    queue.offer(parent.left);
                }
                int rightVal = sc.nextInt();
                if (rightVal != -1) {
                    parent.right = new TreeNode(rightVal);
                    queue.offer(parent.right);
                }
            }
        }

        List<Integer> result = postOrderTraversal(root);
        StringBuilder sb = new StringBuilder();
        for (int v : result) sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }
}
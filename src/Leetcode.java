import Basic.A;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Leetcode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[] ml = new Integer[]{1,2,3,4,5,6};
        ArrayList<Integer> a = new ArrayList<>();
        int n = ml.length;
        for (int i = 0; i < n; ++i) {
            a.add(ml[i]);
        }


        String[] str = new String[]{"0:start:0","1:start:2","1:end:5","0:end:6"};

        ArrayList<String> b = new ArrayList<>();
        for (var s : str) {
            b.add(s);
        }

        sol.waysToChange(10);
    }

    private static ListNode getList(ArrayList<Integer> ml) {
        ListNode head = new ListNode();
        int n = ml.size();
        ListNode cur = head;
        for (Integer i: ml) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head.next;
    }

    private static TreeNode getTree(ArrayList<Integer> ml) {
        int n = ml.size();
        if (n == 0) return null;
        TreeNode root = new TreeNode(ml.get(0));
        Queue<TreeNode> mq = new LinkedList<>();
        mq.offer(root);
        int idx = 1;
        while (!mq.isEmpty()) {
            TreeNode cur = mq.poll();
            if (idx >= n) break;
            cur.left = new TreeNode(ml.get(idx++));
            if (idx >= n) break;
            cur.right = new TreeNode(ml.get(idx++));
            if (cur.left != null) mq.offer(cur.left);
            if (cur.right != null) mq.offer(cur.right);
        }
        return root;
    }
}

class Solution {
    public int waysToChange(int n) {
        final int mod = 1000000007;
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; ++i) {
            long add1 = i - 1 >= 0? dp[i - 1]: 0;
            long add2 = i - 5 >= 0? dp[i - 5]: 0;
            long add3 = i - 10 >= 0? dp[i - 10]: 0;
            long add4 = i - 25 >= 0? dp[i - 25]: 0;
            dp[i] = add1 + add2 + add3 + add4;
        }
        return (int)(dp[n] % mod);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
    TreeNode() {
        this(0);
    }
    TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
        right = r;
    }
}
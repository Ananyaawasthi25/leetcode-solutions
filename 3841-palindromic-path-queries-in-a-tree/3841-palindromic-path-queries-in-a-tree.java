
import java.util.*;

class Solution {

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[LOG][n];
        int[] parent = new int[n];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] size = new int[n];
        int[] order = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS
        int[] stack = new int[n];
        int top = 0;
        int timer = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;
            size[u] = 1;

            for (int v : adj[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    stack[top++] = v;
                }
            }
        }

        // Calculate subtree sizes
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int i = 0; i < n; i++) {
            tout[i] = tin[i] + size[i] - 1;
            up[0][i] = parent[i];
        }

        // Binary lifting table
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        // Fenwick Tree for XOR
        int[] bit = new int[n + 2];
        char[] chars = s.toCharArray();

        // Initial character masks
        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            updateRange(bit, tin[i], tout[i], mask, n);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');

                if (oldMask != newMask) {
                    int diff = oldMask ^ newMask;

                    updateRange(bit, tin[u], tout[u], diff, n);

                    chars[u] = c;
                }

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLCA(
                    u, v, depth, tin, tout, up, LOG
                );

                int maskU = queryBIT(bit, tin[u] + 1);
                int maskV = queryBIT(bit, tin[v] + 1);
                int maskLCA = 1 << (chars[lca] - 'a');

                int pathMask = maskU ^ maskV ^ maskLCA;

                // At most one character may have odd frequency
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    private void updateBIT(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    private int queryBIT(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private void updateRange(
        int[] bit, int left, int right, int value, int n
    ) {
        updateBIT(bit, left + 1, value);

        if (right + 2 <= n + 1) {
            updateBIT(bit, right + 2, value);
        }
    }

    private int getLCA(
        int u, int v, int[] depth,
        int[] tin, int[] tout, int[][] up, int LOG
    ) {

        if (isAncestor(u, v, tin, tout)) {
            return u;
        }

        if (isAncestor(v, u, tin, tout)) {
            return v;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (!isAncestor(up[k][u], v, tin, tout)) {
                u = up[k][u];
            }
        }

        return up[0][u];
    }

    private boolean isAncestor(
        int u, int v, int[] tin, int[] tout
    ) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }
}
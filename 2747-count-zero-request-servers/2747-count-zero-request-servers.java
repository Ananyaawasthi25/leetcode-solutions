import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        Integer[] idx = new Integer[queries.length];

        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);

        int[] ans = new int[queries.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i : idx) {

            int q = queries[i];

            // Add logs within upper limit
            while (right < logs.length && logs[right][1] <= q) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                if (map.get(server) == 1) {
                    active++;
                }

                right++;
            }

            // Remove logs outside lower limit
            while (left < right && logs[left][1] < q - x) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                    active--;
                }

                left++;
            }

            ans[i] = n - active;
        }

        return ans;
    }
}
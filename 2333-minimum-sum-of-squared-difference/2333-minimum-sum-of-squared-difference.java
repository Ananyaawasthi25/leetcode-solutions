class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int mx = 0;
        int[] diff = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            mx = Math.max(mx, diff[i]);
            total += diff[i];
        }

        if (total <= k) return 0;

        long[] cnt = new long[mx + 1];
        for (int d : diff) cnt[d]++;

        for (int v = mx; v > 0 && k > 0; v--) {
            if (cnt[v] == 0) continue;
            if (k >= cnt[v]) {
                k -= cnt[v];
                cnt[v - 1] += cnt[v];
                cnt[v] = 0;
            } else {
                cnt[v] -= k;
                cnt[v - 1] += k;
                k = 0;
            }
        }

        long ans = 0;
        for (int v = 1; v <= mx; v++) {
            ans += cnt[v] * (long) v * v;
        }
        return ans;
    }
}
class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        long sum = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            long cost = (long) nums[right] * (right - left + 1) - sum;

            while (cost > k) {
                sum -= nums[left];
                left++;

                cost = (long) nums[right] * (right - left + 1) - sum;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
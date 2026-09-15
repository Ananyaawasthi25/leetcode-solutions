class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
int mul=1;
            for(int j=i;j<n;j++){
mul=mul*nums[j];
max=Math.max(mul,max);
            }
        }
        return max;  }
}
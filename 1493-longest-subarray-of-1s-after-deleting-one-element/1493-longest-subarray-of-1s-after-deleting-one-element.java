class Solution {
    public int longestSubarray(int[] nums) {
        int l=0;
        int sum=0;
        int max=0;
        for(int r=0;r<nums.length;r++){
           if(nums[r]==0){
            sum++;
           }
           while(sum>1){
            if(nums[l]==0){
                sum--;
            }
            l++;
           }
           max=Math.max(r-l,max);
        }
        return max;
        
    }
}
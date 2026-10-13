class Solution {
    public long maxAlternatingSum(int[] nums) {
       
        for(int i=0;i<nums.length;i++){
            nums[i]*=nums[i];  }
             Arrays.sort(nums);
             long k=0;
             for(int i=0;i<nums.length;i++){
                k+= (long)nums[i]*(i<nums.length/2?-1:1);

             }
             return k;
        
        
    }
}
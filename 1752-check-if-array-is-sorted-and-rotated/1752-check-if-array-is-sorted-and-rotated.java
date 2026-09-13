class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }}
            if(nums[nums.length-1]>nums[0])
            count++;
            if(count==1||count==0){
                return true;
            }else{
                return false;
            }
        }       
    }

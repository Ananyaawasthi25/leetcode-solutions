class Solution {
    public int[] leftRightDifference(int[] nums) {
        int arr[]=new int[nums.length];
        int arr1[]=new int[nums.length];
        int ans[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            arr[i]=arr[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            arr1[i]=arr1[i+1]+nums[i+1];
        }
        for(int i=0;i<ans.length;i++){
        ans[i]=Math.abs(arr[i]-arr1[i]);}
        return ans;
        
    }
}
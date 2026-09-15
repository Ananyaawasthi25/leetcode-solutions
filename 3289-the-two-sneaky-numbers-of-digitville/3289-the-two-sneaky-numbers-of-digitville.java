class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[]=new int[2];
        Arrays.sort(nums);
        int k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                arr[k]=nums[i];
                k++;
            }
        }
        return arr;
        
    }
}
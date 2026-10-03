class Solution {
    public int countPartitions(int[] nums) {
     
    int count=0;
     
     for(int i=0;i<nums.length-1;i++){
        int left=0;
        int right=0;
        for(int j=0;j<=i;j++){
            left+=nums[j];
        }
        for(int k=i+1;k<nums.length;k++){
            right+=nums[k];
        }
    int diff=left-right;
    if(diff%2==0){
        count++;
    }
     }
        
return count;
        
        
    }
}
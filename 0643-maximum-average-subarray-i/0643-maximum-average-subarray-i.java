class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int sum=0;
       int l=0;
       int r=k-1;
       int n=nums.length;
       for(int i=0;i<k;i++){
        sum+=nums[i];
       }
       double maxavg=(double)sum/k;
       while(r<n-1){
        sum-=nums[l];
        l++;
        r++;
        sum+=nums[r];
        double avg=(double)sum/k;
        maxavg=Math.max(avg,maxavg);
       }
       return maxavg; 
        
    }
}
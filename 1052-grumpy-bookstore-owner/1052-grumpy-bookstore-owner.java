class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        int n=customers.length;
        int sum=0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                sum+=customers[i];
            }
        }
         int l=0;
        int r=minutes-1;
        int max=0;
     int wsum=0;
        for(int i=l;i<=r;i++){
            if(grumpy[i]==1){
                wsum+=customers[i];
            }
           
        }
         max=wsum;
         while(r<n-1){
           if(grumpy[l]==1){
                wsum-=customers[l];
            }
            l++;
            r++;
             if(grumpy[r]==1){
                wsum+=customers[r];
            }
            max=Math.max(max,wsum);
        }
        return sum+max;
        
    }
}
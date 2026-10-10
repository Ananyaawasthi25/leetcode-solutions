class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0;
        int r=k-1;
        int n=cardPoints.length;
        int sum=0;
        int max=Integer.MAX_VALUE;
       
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
       max=sum;
        int right=n-1;
        while(r>=0){
            sum-=cardPoints[r];
             r--;
           sum+=cardPoints[right];
           right--;
           max=Math.max(sum,max);
        }
return max;
        
    }
}
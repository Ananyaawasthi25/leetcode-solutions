class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] val=new int[n];
        int[] cnt=new int[n];
        int head=0,tail=0;
        int j=n-1;
        long cost=0,ans=0;

        for(int i=n-1;i>=0;i--){
            int count=1;

            while(tail>head && val[tail-1]<nums[i]){
                int c=cnt[--tail];
                cost+=(long)(nums[i]-val[tail])*c;
                count+=c;
            }

            val[tail]=nums[i];
            cnt[tail]=count;
            tail++;

            while(cost>k){
                cost-=val[head]-nums[j];
                cnt[head]--;

                if(cnt[head]==0){
                    head++;
                }
                j--;
            }

            ans+=j-i+1;
        }

        return ans;
    }
}
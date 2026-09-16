class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
      int ans[]=new int[friends.length];
      int k=0;
      for(int i=0;i<order.length;i++){
        int left=0;
        int right=friends.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(friends[mid]==order[i]){
                ans[k++]=order[i];
                break;
            }else  if(friends[mid]<order[i]){
                left=mid+1;
            }else{
                right=mid-1;
            }}
        }
        return ans;
        
    }
}
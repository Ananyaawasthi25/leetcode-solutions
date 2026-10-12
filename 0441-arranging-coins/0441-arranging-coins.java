class Solution {
    public int arrangeCoins(int n) {
        int l=1;
        int r=n;
        while(l<=r){
            long mid=l+(r-l)/2;
            long coin=mid*(mid+1)/2;
            if(coin>n){
                r=(int)mid-1;
            }else{
                l=(int)mid+1;
            }
        }
       return r;


        
    }
}
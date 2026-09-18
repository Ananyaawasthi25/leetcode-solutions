class Solution {
    public int xorOperation(int n, int start) {
       int rez=0;
       for(int i=0;i<n;i++){
        rez^=start+2*i;
       }
       return rez;
        
    }
}
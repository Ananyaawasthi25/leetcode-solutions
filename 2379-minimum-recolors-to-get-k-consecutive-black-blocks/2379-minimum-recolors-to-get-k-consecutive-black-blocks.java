class Solution {
    public int minimumRecolors(String blocks, int k) {
      int n=blocks.length();
        int l=0;
        int r=k-1;
        int count=0;
        int min=Integer.MAX_VALUE; 
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                count++;
            }

        }
        min=count;
        while(r<n-1){
            if(blocks.charAt(l)=='W'){
                count--;
            }
            l++;
            r++;
            if(blocks.charAt(r)=='W'){
                count++;
            }
            min=Math.min(min,count);
        }
        return min;
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int l=0;
        int r=k-1;
        int count =0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count ++;
            }
            max=count;
        }while(r<n-1){
             if(s.charAt(l)=='a'||s.charAt(l)=='e'||s.charAt(l)=='i'||s.charAt(l)=='o'||s.charAt(l)=='u'){
                count --;
             }
        l++;
        r++;
         if(s.charAt(r)=='a'||s.charAt(r)=='e'||s.charAt(r)=='i'||s.charAt(r)=='o'||s.charAt(r)=='u'){
                count ++;
          }
        
       max=Math.max(max,count);}
       return max;

         
        
    }
}
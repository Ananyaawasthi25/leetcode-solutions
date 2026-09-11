class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int original=x;
        int sum=0;
        while(x!=0){
            int digit=x%10;
            sum=sum*10+digit;
            x/=10; }   
            if(original==sum){
                return true;
            } 
return false;
            
        
    }
}
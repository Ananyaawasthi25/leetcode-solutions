class Solution {
    public int balancedStringSplit(String s) {
       int balance=0;
       int count=0;
       char ch[]=s.toCharArray();
       for(int i=0;i<ch.length;i++){
                if(ch[i]=='R'){
            balance++;
        }else{
            balance--;
        }
        if(balance==0){
            count++;
        }}
       
       return count++;
        
    }
}
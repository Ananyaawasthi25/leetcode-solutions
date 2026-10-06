class Solution {
    public String reversePrefix(String s, int k) {
       char ch[]=s.toCharArray();
            int i=0;
            int j=k-1;
            while(i<j){
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
            return new String(ch);
                
    }
}
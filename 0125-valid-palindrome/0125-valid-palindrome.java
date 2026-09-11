class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(Character.isLetterOrDigit(ch)){
            str=str+Character.toLowerCase(ch);

        }}
String rev="";
for(int i=str.length()-1;i>=0;i--){
    rev+=str.charAt(i);
}
return str.equals(rev);
        
    }
}
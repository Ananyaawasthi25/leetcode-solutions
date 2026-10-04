class Solution {
    public int reverseDegree(String s) {
        char  arr[]=s.toCharArray();
        int sum=0;
        for(int i=0; i<s.length();i++){
            int value='z'-arr[i]+1;
            int mul=value*(i+1);
            sum+=mul;
        }
return sum;

        
    }
}
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a=String.join("",word1);
        String b=String.join("",word2);
        return a.equals(b);}
}
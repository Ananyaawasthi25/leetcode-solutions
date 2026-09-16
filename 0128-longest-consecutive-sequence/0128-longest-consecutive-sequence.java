class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int longest=0;
        for(int x:set){
            if(!set.contains(x-1)){
                int current=x;
                int count=1;
                while(set.contains(current +1)){
                    count++;
                    current++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
        
    }
}
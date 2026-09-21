class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int x:nums){
        map.put(x,map.getOrDefault(0,x)+1);}
        for(int x=0;x<=nums.length;x++){
            if(!map.containsKey(x)){
                return x;
            }
        }
        return -1;
    }
}
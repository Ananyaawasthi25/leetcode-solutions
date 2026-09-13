class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            if(map.get(x)==1){
                return x;
            }
        }  
        return -1;

    }
}
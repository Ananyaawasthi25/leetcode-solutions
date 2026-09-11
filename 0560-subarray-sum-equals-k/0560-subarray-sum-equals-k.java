class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int s=0;
        int c=0;
        HashMap<Integer , Integer> map=new HashMap<>();
        map.put(0,1);

        for(int i=0;i<n;i++){
            s+=nums[i];
        if(map.containsKey(s-k)){
            c+=map.get(s-k);
        }
        map.put(s, map.getOrDefault(s, 0)+1);
        }
        return c;
        
    }
}
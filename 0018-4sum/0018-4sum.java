class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
            continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                for(int k=j+1;k<nums.length-1;k++){
                    if(k>j+1 && nums[k]==nums[k-1]){
                        continue;
                    }
                    for(int l=k+1;l<nums.length;l++){
                        if(l>k+1 && nums[l]==nums[l-1]){
                            continue;
                        }
                        if((long)nums[i]+nums[j]+nums[k]+nums[l]==target){
ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));

                        }
                    }
                }
            }
        }
        return ans;
        
    }
}
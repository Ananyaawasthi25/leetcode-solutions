class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int k=0;
   int[] arr = new int[Math.min(nums1.length, nums2.length)];
         boolean[] used = new boolean[nums2.length];
        for(int i=0;i<nums1.length;i++){
        boolean found = false;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j] && !used[j]){
                    found=true;
                    used[j]=true;
                    break;
                 }
            }
              if(found){
            arr[k]=nums1[i];
            k++;

        }
      
        }
      return  Arrays.copyOf(arr,k);
        
    }
}
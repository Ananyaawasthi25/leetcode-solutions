class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int k=0;
        int arr[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            boolean found=false;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    found=true;
                    break;
                }
            }
           
            if(found){
                 boolean duplicate=false;
                for(int x=0;x<k;x++){
                    if(arr[x]==nums1[i]){
                        duplicate=true;
                        break;
                    }
                }
                if(!duplicate){
                    arr[k]=nums1[i];
                        k++;
                    
                }
            }
        }
        return Arrays.copyOf(arr,k);
        
        
    }
}
class Solution{
    static final int MOD=1000000007;
    long[][] C=new long[1001][1001];

    public int numOfWays(int[] nums){
        for(int i=0;i<=1000;i++){
            C[i][0]=C[i][i]=1;
            for(int j=1;j<i;j++)
                C[i][j]=(C[i-1][j-1]+C[i-1][j])%MOD;
        }
        return (int)((dfs(nums)-1+MOD)%MOD);
    }

    long dfs(int[] a){
        if(a.length<=2)return 1;
        int root=a[0],l=0,r=0;
        for(int i=1;i<a.length;i++)
            if(a[i]<root)l++;
            else r++;
        int[] left=new int[l],right=new int[r];
        l=r=0;
        for(int i=1;i<a.length;i++)
            if(a[i]<root)left[l++]=a[i];
            else right[r++]=a[i];
        return C[a.length-1][left.length]*dfs(left)%MOD*dfs(right)%MOD;
    }
}
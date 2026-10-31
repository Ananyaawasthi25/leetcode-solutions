class Solution{
    public int uniquePaths(int[][] grid){
        int MOD=1000000007;
        int n=grid[0].length;
        int[] dp=new int[n+1];
        dp[1]=1;

        for(int i=0;i<grid.length;i++){
            int left=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp=dp[j+1];
                    dp[j+1]=left;
                    left=temp;
                }else{
                    int ways=(left+dp[j+1])%MOD;
                    left=ways;
                    dp[j+1]=ways;
                }
            }
        }
        return dp[n];
    }
}
//Time Complexity - O(m*n)
//Space Complexity - O(m*n)

class Problem1 {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))
            return 0; 
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        if( m < n)
            return minDistance(word2, word1);
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        for(int  j = 1; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
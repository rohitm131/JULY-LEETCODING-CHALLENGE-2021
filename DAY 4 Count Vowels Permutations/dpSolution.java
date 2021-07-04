class Solution {
    public int countVowelPermutation(int n) {
        
        long count = 0;
        long[][] dp = new long[n+1][5];
        int mod = 1000000007;
        
        for(int i=0; i<5; i++) {
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=n; i++) {
            dp[i][0] = (dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;  //a 0
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%mod;             //e 1
            dp[i][2] = (dp[i-1][1]+dp[i-1][3])%mod;             //i 2
            dp[i][3] = (dp[i-1][2])%mod;                        //o 3
            dp[i][4] = (dp[i-1][3]+dp[i-1][2])%mod;             //u 4
        }
        
        for(long l : dp[n]) {
            count += l;
            count %= mod;
        }
        
        return (int)count;
        
    }
}

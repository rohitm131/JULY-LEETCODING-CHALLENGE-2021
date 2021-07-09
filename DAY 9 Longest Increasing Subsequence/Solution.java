class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        int max = dp[0];
        
        for(int i=1; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j]+1) {
                    dp[i]++;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

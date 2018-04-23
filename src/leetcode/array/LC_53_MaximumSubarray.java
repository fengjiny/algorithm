package leetcode.array;

public class LC_53_MaximumSubarray {

    public int maxSubArray(int[] nums){
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; ++i) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

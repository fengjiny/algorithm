package leetcode.array;

public class LC_643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k){
        int sum = 0, max = 0;
        for (int i = 0; i < k; ++i){
            sum += nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; ++i) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;

    }
}

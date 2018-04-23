package leetcode.array;

public class LC_268_MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for(; i < nums.length; ++i) {
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ i;
    }
}

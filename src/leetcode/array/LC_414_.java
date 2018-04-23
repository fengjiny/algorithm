package leetcode.array;

import java.util.Set;
import java.util.TreeSet;

public class LC_414_ {


    /**
     * my first ac solution
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int n = set.size();
        int[] res = new int[n];
        int i = 0;
        for(int num : set) {
            res[i++] = num;
        }
        if(n < 3) {
            return res[n - 1];
        } else {
            return res[n - 3];
        }
    }

    /**
     * the fastest solution
     * @param nums
     * @return
     */
    public int thirdMax_best(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;
        for(Integer n : nums) {
            if(n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if(max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}

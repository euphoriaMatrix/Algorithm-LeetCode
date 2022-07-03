package sumsubarray;

/**
 * @author xwfstart
 * @create 2021-12-19 16:56
 */
public class Solution {

    /**
     * 单个子数组的最大和
     */
    public static int[] maxSumOfOneSubarray(int[] nums, int k) {
        // 滑动窗口解决, 取长度为k的窗口从头滑到尾
        int[] ans = new int[1];
        int sum = 0, maxSum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                sum -= nums[i-k];
                if (sum > maxSum) {
                    maxSum = sum;
                    ans[0] = i - k + 1;
                }
                sum -= nums[i - k + 1];
            }
        }
        return ans;
    }

    /**
     *  两个无重叠子数组的最大和
     *  我们使用两个大小为 k 的滑动窗口。设 sum1为第一个滑动窗口的元素和，该滑动窗口从[0,k−1] 开始；
     *  sum2为第二个滑动窗口的元素和，该滑动窗口从[k,2k−1] 开始。
     *  我们同时向右滑动这两个窗口，并维护sum1的最大值maxSum1及其对应位置。
     *  每次滑动时，计算当前maxSum1与sum2之和。
     *
     */
    public static int[] maxSumOfTwoSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[2];
        int sum1 = 0, maxSum1 = 0, maxSumIdx = 0;
        int sum2 = 0, maxSum2 = 0;
        for (int i = k; i < n; i++) {
            sum1 += nums[i - k];
            sum2 += nums[i];
            if (i >= 2*k - 1) {
                if (sum1 > maxSum1) {
                    sum1 = maxSum1;
                    maxSumIdx = i - 2*k + 1;
                }
                if (maxSum1 + sum2 > maxSum2) {
                    maxSum2 = sum1 + sum2;
                    ans[0] = maxSumIdx;
                    ans[0] = i - k + 1;
                }
                sum1 -= nums[i - 2*k + 1];
                sum2 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    /**
     * 三个无重叠子数组的最大和
     * 我们使用三个大小为 k 的滑动窗口。设 sum1为第一个滑动窗口的元素和，该滑动窗口从[0,k−1] 开始；
     * sum2为第二个滑动窗口的元素和，该滑动窗口从[k,2k−1] 开始；
     * sum3为第二个滑动窗口的元素和，该滑动窗口从[2k,3k−1] 开始。
     * 我们同时向右滑动这两个窗口，并维护sum1的最大值maxSum1及其对应位置， 以及sum2的最大值maxSum2的最大值。
     * 每次滑动时，计算当前maxSum1与sum2之和。
     *
     */
    public static int[] maxSumOfThreeSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[3];
        int sum1 = 0, maxSum1 = 0, maxSumIdx = 0;
        int sum2 = 0, maxSum2 = 0, maxSumIdx1 = 0, maxSumIdx2 = 0;
        int sum3  = 0, maxSum3 = 0;
        for (int i = 2*k; i < n; i++) {
            sum1 += nums[i - 2*k];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= 3*k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSumIdx = i - 3*k + 1;
                }
                if (maxSum1 + sum2 > maxSum2) {
                    maxSum2 = maxSum1 + sum2;
                    maxSumIdx1 = maxSumIdx;
                    maxSumIdx2 = i - 2*k + 1;
                }
                if (maxSum2 + sum3 > maxSum3) {
                    maxSum3 = maxSum2 + sum3;
                    ans[0] = maxSumIdx1;
                    ans[1] = maxSumIdx2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - 3*k + 1];
                sum2 -= nums[i - 2*k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }
}

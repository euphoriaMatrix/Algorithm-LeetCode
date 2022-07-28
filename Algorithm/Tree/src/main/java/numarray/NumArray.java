package numarray;

/**
 * @author xwfstart
 * @create 2022-07-29 0:01
 */
public class NumArray {
    /**
     * 给你一个数组 nums ，请你完成两类查询。
     *
     * 其中一类查询要求 更新 数组 nums 下标对应的值
     * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
     *
     */
    int[] tree;

    /**
     * lowbit：lowbit(x) 是 x 的二进制表达式中最低位的 1所对应的值。显然，lowbit(x) 是2的整数次（包括0）幂。
     *  例如二进制数 0110  => lowbit: 2
     *              1000  => lowbit: 8
     * @param x
     * @return int
     */
    int lowbit(int x) {
        return x & -x;
    }
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    int[] nums;
    int n;
    public NumArray(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }
}

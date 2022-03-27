# 最长公共子序列(LCS)和最长上升子序列(LIS)

​        如果一个数组元素各不相同，LCS问题可以转化为LIS问题（利用其中一个数组元素各不相同，这时候每一个“公共子序列”都对应一个不重复元素数组的下标数组“上升子序列”）

​		给定两个数组$target$和$arr$，$target$元素各不相同，故$target$元素与下标具有唯一的映射关系。我们再考虑两数组的公共子序列，每一个“公共子序列”就自然对应了一个下标数组的“上升子序列”。反之，我们考虑一个下标数组的子序列（必然是递增的）,也对应一个公共子序列。

​		对于一般的LIS问题，我们需要定义一个f[i]数组代表以$nums[i]$为结尾的最长上升子序列的长度。计算f[i]的时候，我们需要遍历$[0, i-1]$区间内，所有可以将$nums[i]$作为结尾的位置$j$，在所有$f[j]+1$中取最大值更新$f[i]$。此时的算法复杂度为$O(n^2)$。

​		LIS的贪心解法是维护一个额外$g$数组，$g[len]=x$代表长度为$len$的上升序列的最小结尾元素为$x$。需要两个数组：

① $f$动规数组：跟一般的LIS解法的动规数组一致。$f[i]$代表以$nums[i]$为结尾的上升子序列的最大长度；

② $g$贪心数组：$g[len]=x$代表长度为$len$的上升子序列的最小结尾元素为$x$。

​		我们在计算$f[i]$的时候，需要找到满足$nums[j]<nums[i]$，同时取得最大$f[i]$的位置$j$。我们期望通过$g$数组代替线性遍历。

​		如果$g$数组具有单调性（单调递增），我们可以通过二分法找到满足$g[idx]<nums[i]$分割点$idx$（下标最大），利用$O(log n)$复杂度找到最佳转移位置

​		利用反证法证明$g$数组的单调性。对于任意两个位置$i$和$j$，且$i<j$，假设不满足单调递增，则有两种可能：

​		Ⅰ、$g[i]=g[j]=x$: 意味着长度为$i$的上升子序列和长度为$j$的上升子序列都以$x$结尾，由于$j>i$，显然可以删除长度为$j$的上升子序列的后面几项达到长度$i$，同时结尾元素小于$x$，与已知矛盾，所以这种情况不存在；

​		Ⅱ、$g[i]>g[j]$: 意味着长度为$i$的上升子序列的结尾元素大于长度为$j$的上升子序列的结尾元素，由于$j>i$，所以长度为$j$的上升子序列必然可以通过删除后面几项得到长度$i$的上升子序列，此时结尾元素$x$必然小于$g[j]$，当然$x<g[i]$，这与$g$数组的定义矛盾。

​		综上可知，$g[i]<g[j]$恒成立。

例：
$$
target=[6,4,8,1,3,2]															
$$

$$
arr=[4,7,6,2,3,8,6,1]
$$

$target$数组的序
$$
[0,1,2,3,4,5]
$$
$arr$数组中元素在$target$数组中的位置($target$数组中不存在该元素就丢掉，例如7在$target$不存在就丢掉了)
$$
[1,0,5,4,2,0,3]
$$
也就是求这两个数组的最长上升子序列，也就是0，2，3

对应leetcode中的题目：得到子序列的最少操作次数

```java
public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length;
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num)) list.add(map.get(num));
        }
        int m = list.size();
        // g[i] 表示长度为i的上升子序列的最小结尾元素
        int[] g = new int[m+1];
        Arrays.fill(g, Integer.MAX_VALUE);
        int max = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = m;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (g[mid] < list.get(i)) l = mid;
                else r = mid - 1; 
            }
            int len = r + 1;
            g[len] = Math.min(g[len], list.get(i));
            max = Math.max(max, len);
        }
        return n - max;
}
```


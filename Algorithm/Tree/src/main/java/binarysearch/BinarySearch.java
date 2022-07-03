package binarysearch;

/**
 * 常见的二分法查询
 * @author xwfstart
 * @create 2022-01-13 21:49
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,5,5,6,8,12,12,12,13,13,14};
        System.out.println(BinarySearch.search(nums, 9));
        System.out.println(BinarySearch.searchLeft(nums, 12));
        System.out.println(BinarySearch.searchRight(nums, 12));
        System.out.println(BinarySearch.firstLessThanNum(nums, 0));
        System.out.println(BinarySearch.firstMoreThanNum(nums, 15));
    }

    // 基本的二分查询
    public static int search(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > t) r = mid - 1;
            else if (nums[mid] < t) l = mid + 1;
            else return mid;
        }
        return -1;
    }

    // 找到数组中第一个值为t的序号
    public static int searchLeft(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < t) l = mid + 1;
            else r = mid;
        }
        return nums[l] == t ? l : -1;
    }

    // 找到数组中最后一个值为t的序号
    public static int searchRight(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] > t) r = mid - 1;
            else l = mid;
        }
        return nums[r] == t ? r : -1;
    }

    // 找到数组中第一个小于t的数
    public static int firstLessThanNum(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] < t) l = mid;
            else r = mid - 1;
        }
        return nums[l] < t ? l : -1;
    }

    // 找到数组中第一个大于t的数
    public static int firstMoreThanNum(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > t) r = mid;
            else l = mid + 1;
        }
        return nums[l] > t ? l : -1;
    }
}

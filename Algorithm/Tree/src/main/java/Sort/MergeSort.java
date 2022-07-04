package Sort;

import java.util.Random;

/**
 * @author xwfstart
 * @create 2022-07-04 23:44
 */
public class MergeSort {
    public int[] aux;   // 归并所需的辅助数组
    static Random random = new Random();

    public void sort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);  // 将左半边排序[l, mid]
        sort(arr, mid + 1, r);  // 将右半边排序[mid + 1, r]
        merge(arr, l, mid, r);  // 合并两区间
    }

    public void merge(int[] arr, int l, int mid, int r) {
        int i = l, j = mid + 1;
        // 将[l, r]复制到辅助数组aux
        for (int k = l; k <= r; k++) {
            aux[k] = arr[k];
        }
        for (int k = l; k <= r ; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > r) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        MergeSort mergeSort = new MergeSort();
        mergeSort.aux = new int[n];
        mergeSort.sort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

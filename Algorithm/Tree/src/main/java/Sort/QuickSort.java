package Sort;

import java.util.Random;

/**
 * @author xwfstart
 * @create 2022-07-03 9:56
 */
public class QuickSort {

    public void qs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int pivot = arr[r]; // 选最后一个元素为中心点
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(50);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        QuickSort quickSort = new QuickSort();
        quickSort.qs(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

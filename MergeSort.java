import java.util.*;
public class MergeSort {
    static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    static void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= high) temp[k++] = a[j++];
        for (i = low, k = 0; i <= high; i++, k++) a[i] = temp[k];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        long start = System.nanoTime();
        mergeSort(a, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start) / 1000000.0 + " ms");
        System.out.println("Sorted elements:");
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }
}

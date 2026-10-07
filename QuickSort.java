import java.util.*;
public class QuickSort {
    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);

            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }
    static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long start = System.nanoTime();
        quickSort(a, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start) / 1000000.0 + " ms");
        System.out.println("Sorted elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
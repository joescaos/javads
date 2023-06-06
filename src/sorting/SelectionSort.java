package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr = {4, 6, 2, 12, 34, 5, 9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
                if (i != minIdx) {
                    int temp = arr[i];
                    arr[i] = arr[minIdx];
                    arr[minIdx] = temp;
                }
            }
        }
    }
}

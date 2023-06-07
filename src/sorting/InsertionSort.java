package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int [] arr = {4, 6, 2, 12, 34, 5, 9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}

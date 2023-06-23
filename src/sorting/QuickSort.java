package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {4,6,1,7,3,2,5};
        /*int returnedIndex = pivot(array, 0, 6);
        System.out.println("Returned index: " + returnedIndex);
        System.out.println(Arrays.toString(array));*/
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] array, int pivotIndex, int lastIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= lastIndex ; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;

    }


    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

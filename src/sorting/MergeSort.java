package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        /*int[] arr1 = {1, 5, 6, 7};
        int[] arr2 = {2, 3, 4, 8};

        System.out.println(Arrays.toString(merge(arr1, arr2)));*/

        int[] originalArray = {1, 5, 6, 7, 2, 3, 4, 8};

        int[] sortedArray = mergeSort(originalArray);

        System.out.println(Arrays.toString(sortedArray));

    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;
        int midIndex = arr.length / 2 ;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }


    private static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[index] = arr1[i];
                index++;
                i++;
            } else {
                result[index] = arr2[j];
                index++;
                j++;
            }
        }
        while (i < arr1.length) {
            result[index] = arr1[i];
            index++;
            i++;
        }

        while (j < arr2.length) {
            result[index] = arr2[j];
            index++;
            j++;
        }
        return result;
    }
}

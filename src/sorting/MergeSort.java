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
        // border case length equals 1
        if (arr.length == 1) return arr;
        // divide arr by 2
        int midIndex = arr.length / 2;

        // return an array of the recursive call for left array (copyOfRage)
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        // return an array of the recursive call for left array (copyOfRage)
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        // merge left and right arrays
        return merge(left, right);
    }


    private static int[] merge(int[] arr1, int[] arr2) {
        // create a new array of length arr1 + arr2
        int[] result = new int[arr1.length + arr2.length];
        // create index at 0
        int index = 0;
        // create i for iterating left at 0
        int i = 0;
        // create j for iterating right at 0
        int j = 0;

        // iterate over both arrays
        while (i < arr1.length && j < arr2.length) {
            // if arr1 of i is lesser than arr2 of j
            if (arr1[i] < arr2[j]) {
                // add arr of i to the new arr at current index
                result[index] = arr1[i];
                // increment i
                i++;
            } else {
                // add arr of j to the new arr at current index
                result[index] = arr2[j];
                // increment j
                j++;
            }
            // increment index
            index++;
        }
        // loop for remaining elements at arr 1
        while (i < arr1.length) {
            // add them to arr result
            result[index] = arr1[i];
            index++;
            i++;
        }
        // loop for remaining elements at arr 2
        while (j < arr2.length) {
            // add them to arr result
            result[index] = arr2[j];
            index++;
            j++;
        }

        // return the new arr with both left arr and right arr inside it
        return result;

    }
}

package hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static boolean itemInCommon(int[] array1, int [] array2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : array1) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            }
        }
        for (int j : array2) {
            if (map.containsKey(j)) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> duplicatesMap = new HashMap<>();

        for (int num : nums) {
            duplicatesMap.put(num, duplicatesMap.getOrDefault(num, 0) + 1);
        }


        return duplicatesMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /*List<Integer> values = new ArrayList<>();
        for (int key : duplicatesMap.keySet()) {
            if (duplicatesMap.get(key) > 1) {
                values.add(key);
            }
        }

        return values;*/
    }

    private static Character firstNonRepeatingChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character letter: s.toCharArray()) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for (Character letter: s.toCharArray()) {
            if (map.get(letter) == 1) {
                return letter;
            }
        }
        return null;
    }

    private static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> anagramGroups = new HashMap<>();
        for (String word: strings) {
            char [] chars = word.toCharArray();
            Arrays.sort(chars);
            String canonical = Arrays.toString(chars);
            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(word);
            } else {
                List<String> group = new ArrayList<>();
                group.add(word);
                anagramGroups.put(canonical, group);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(num, i);

        }
        return new int[] {};
    }

    public static int[] subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[] {sumIndex.get(currentSum - target) + 1, i};
            } else {
                sumIndex.put(currentSum, i);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 80);

        hashTable.set("bolts", 200);
        hashTable.set("screws", 140);
        hashTable.set("bulbs", 100);
        hashTable.set("scissors", 150);

        hashTable.printTable();
        System.out.println();

        System.out.println(hashTable.get("bolts"));
        System.out.println(hashTable.get("tile"));
        System.out.println(hashTable.get("turners"));
        System.out.println();

        System.out.println(hashTable.keys());
        System.out.println();

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));

        System.out.println();
        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        System.out.println();
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");


    }
}

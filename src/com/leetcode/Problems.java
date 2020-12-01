package com.leetcode;

import java.util.*;

public class Problems {

    Sortings sort = new Sortings();
    private HashMap<String, String> mapStorage = new HashMap<>();


    //-----------------------------------------------------------------------------palindrome number-----------------

    //--------------------------------------------------------Array twoSum------------------easy-----------------------------------------------
    protected int[] twoSumBrute(int[] arr, int target) {
        int[] res = new int[2];
        System.out.println("before " + res[1]);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int maybe = arr[i] + arr[j];
                if (maybe == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
            if (res[1] != 0) {
                break;
            }
        }
//        for (int data:res) {
//            System.out.println(data);
//        }
        return res;
    }

    //------------------------------------------------------------------------------Search in Rotated Sorted Array----------------

    protected int[] twoSumNice(int[] arr, int target) {
        Map<Integer, Integer> table = new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            table.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (table.containsKey(diff)) {
                return new int[]{table.get(diff), i};
            }
        }
        throw new IllegalArgumentException("Achtung!");
    }


//-------------------------------------------------------------------------------------------202 Happy Number------------------------------------------------------

    protected boolean isPalindrome(int x) {
        if (x < 0) return false;
        long palindrome = 0L;
        long reverse = x;
        while (reverse > 0) {
            double end = (reverse % 10) / 10d;
            palindrome = (long) ((palindrome + end) * 10);
            reverse = (reverse / 10);
        }
        return palindrome == x;
    }

    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */

    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        end = arr.length - 1;
        int left = start;
        start = 0;

        if (target >= arr[left] && target <= arr[end]) {
            start = left;
        } else {
            end = left - 1;
        }
        System.out.println("OUT start " + start + " end " + end + " left " + left);

        while (start <= end) {

            int mid = start + (end - start) / 2;
            System.out.println("OUT start " + start + " end " + end + " mid " + mid);
            if (target < arr[mid]) {
                end = mid;
            } else if (target > arr[mid]) {
                start = mid;
            } else if ((start + 1) == end) {
                if (arr[end] == target) return end;
                break;
            }

        }

//        System.out.println("OUT start "+start+" end "+end+" mid "+mid);
        return arr[start] == target ? start : -1;
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            if (!map.containsKey(number)) {
                map.put(number, number);
            } else {
                map.remove(number);
            }
        }
        Object[] integers = map.keySet().toArray();
        return (int) integers[0];

    }

    //--------------------------------------------------------------------------------217    Contains Duplicate------------------------------------------------
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------242 valid anagram--------------------------------------------------
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        if (c2.length > c1.length || c1.length > c2.length) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : c1) {
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (char ch : c2) {
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) - 1);
                int temp = map.get(ch);
                if (temp == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return true;
    }

//-----------------------------------------------------------------------------------349 Intersection of Two Arrays----------------------------------------

    //----------------------------------------------------------------------------------find difference-------------------------------------------
    public char findTheDifference(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : c1) {
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (char ch : c2) {
            if (map.containsKey(ch)) {
                map.replace(ch, map.get(ch) - 1);
                int temp = map.get(ch);
                if (temp == 0) {
                    map.remove(ch);
                }
            } else {
                return ch;
            }
        }
        return '0';
    }

    //------------------------------------------------------------------------------------535  Encode and Decode TinyURL-----------------------------------------------------------------

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int pointer = 0;
        for (int i : nums1) {
            if (map.containsKey(i)) continue;
            map.put(i, 0);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) < 1) {
                map.replace(i, 1);
                arr[pointer] = i;
                pointer++;
            }
        }
        return arr;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String gen = getRandomHexString(6); // or use .hashCode() - int
        mapStorage.put(gen, longUrl);
        return "http://tinyurl.com/" + gen;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String get = shortUrl.substring(19);
        return mapStorage.get(get);
    }

    protected String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        System.out.println(sb.substring(2));
        return sb.toString();
    }


    //-----------------------------------------------------------------------------------------------------1331--------
    public int[] arrayRankTransform(int[] inpArr) {
        int[] res = new int[inpArr.length];
        int[] arr = sort.mergeSort(inpArr);
        HashMap<Integer, Integer> store = new HashMap<>(inpArr.length);

        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                if (arr[i] > arr[i - 1]) {
                    rank++;
                }
            }
            store.put(arr[i], rank);
        }
        for (int i = 0; i < inpArr.length; i++) {
            res[i] = store.get(inpArr[i]);
        }
        return res;
    }

    //--------------------------------------------------------------------------------------------------------------344------------------
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //--------------------------------------------------------------------------------------------------------------14. Longest Common Prefix------------------

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        String firstEle = strs[0];
        String result = "";
        for (int i = 0; i < firstEle.length(); i++) {
            try {
                char prefix = firstEle.charAt(i);
                for (int j = 0; j < strs.length; j++) {
                    char temp = strs[j].charAt(i);
                    if (prefix != temp) {
                        return result;
                    }
                }
                result += prefix;
            } catch (StringIndexOutOfBoundsException e) {
                return result;
            }

        }
        return result;
    }

    //----------------------------------------------------------------------------5. Longest Palindromic Substring--------------------------------------------
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        Set<String> substr = new HashSet<>();
        StringBuilder temp = new StringBuilder();

        //add all possible substrings to the Set
        for (int i = 0; i < s.length() - 1; i++) {
            temp.append(s.charAt(i));
            substr.add(temp.toString());
            for (int j = i + 1; j < s.length(); j++) {
                temp.append(s.charAt(j));
                substr.add(temp.toString());
            }
            temp.setLength(0);
        }

        //run through the set and delete all now palindromic strings
        Iterator<String> iterator = substr.iterator();
        while (iterator.hasNext()) {
            String iterS = iterator.next();
            int left = 0;
            int right = iterS.length() - 1;
            while (left < right) {
                if (iterS.charAt(left) != iterS.charAt(right)) {
                    iterator.remove();
                    break;
                }
                left++;
                right--;
            }
        }
        //find the max value string
        String max = Collections.max(substr, Comparator.comparing(String::length));
        System.out.println(max);

        return max;
    }
//-------------------------------------------------------------------------90. Subsets II-----------------------------------------//not finished

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Set<ArrayList<Integer>> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
            System.out.println(arr);
            if (!map.contains(arr)) {
                map.add(new ArrayList<>(arr));
            }
            try {
                for (int j = i + 1; j < nums.length; j++) {
                    arr.add(nums[j]);
                    System.out.println("Sub"+arr);
                    if (!map.contains(arr)) {
                        map.add(new ArrayList<>(arr));
                    }
                    try {
                        for (int n = j + 1; n < nums.length; n++) {
                            arr.add(nums[n]);
                            System.out.println("Subsub"+arr);
                            if (!map.contains(arr)) {
                                map.add(new ArrayList<>(arr));
                            }
                        }
                        arr.clear();
                        arr.add(nums[i]);
                        
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            arr.clear();
        }
        map.add(arr);
        System.out.println(map);
        System.out.println(map.size());
        return new ArrayList<>(map);
    }

}































































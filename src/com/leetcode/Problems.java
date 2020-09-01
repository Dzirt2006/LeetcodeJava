package com.leetcode;

import java.util.*;

public class Problems {

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

    //-----------------------------------------------------------------------------palindrome number-----------------

    protected boolean isPalindrome(int x) {
        if (x < 0) return false;
        long palindrome = 0L;
        long reverse = x;
        while (reverse > 0) {
            double end = (reverse % 10) / 10d;
            palindrome = (long) ((palindrome + end) * 10);
            reverse = (reverse / 10);
        }
        System.out.println("final palindrome " + palindrome);
        return palindrome == x;
    }

    //------------------------------------------------------------------------------Search in Rotated Sorted Array----------------

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


//-------------------------------------------------------------------------------------------202 Happy Number------------------------------------------------------

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

    //---------------------------------------------------------------------------------Longest Palindrome------?????????????------------------------------------
    public int longestPalindrome(String s) {

        return 0;
    }

//-----------------------------------------------------------------------------------349 Intersection of Two Arrays----------------------------------------

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

    //------------------------------------------------------------------------------------535  Encode and Decode TinyURL-----------------------------------------------------------------

    private HashMap<String,String> mapStorage=new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String gen=getRandomHexString(6);
        mapStorage.put(gen,longUrl);
        return "http://tinyurl.com/"+gen;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String get=shortUrl.substring(19);
        return mapStorage.get(get);
    }

    protected String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        System.out.println(sb.substring(2));
        return sb.toString();
    }

    //-----------------------------------------------------------------------------------------------------------------
}






























































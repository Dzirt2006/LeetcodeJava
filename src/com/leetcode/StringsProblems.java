package src.com.leetcode;

import java.util.*;

public class StringsProblems {


    //   "AAAAAAAAAAAAABBCCCCDD" ->"9A4A2B4C2D"
    //aAaAaaaaaAaaaAAAABbbbBBBB -> "1a1A1a1A5a1A3a4A1B3b4B"
    public static String runLengthEncoding(String string) {
        StringBuilder result = new StringBuilder();
        int len = 1;
        char temp = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            char key = string.charAt(i);
            if (key != temp) {
                encoder(len, temp, result);
                len = 1;
                temp = key;
            } else {
                len++;
            }
            System.out.println(result);
        }
        encoder(len, temp, result);
        return result.toString();
    }

    private static void encoder(int i, char some, StringBuilder result) {
        while (i > 0) {
            if (i > 9) {
                result.append("9" + some);
                i -= 9;
            } else {
                result.append(i + "" + some);
                i = 0;
            }
        }
    }


//    public static String runLengthEncoding(String string) {
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        fillUpMap(string,map);
//        StringBuilder result= new StringBuilder();
//        System.out.println(map);
//        for(Map.Entry<Character,Integer> entry: map.entrySet()){
//            encoder(entry.getValue(), entry.getKey(), result);
//        }
//        return result.toString();
//    }


    private static void fillUpMap(String phrase, Map<Character, Integer> map) {
        for (int i = 0; i < phrase.length(); i++) {
            char key = phrase.charAt(i);
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }
    }
//-----------------------------------------------------------------------------------------------------------

}

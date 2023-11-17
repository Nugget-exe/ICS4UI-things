package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* Day 34 - String version of the Radix sort. same one used previously, 
Thursday last week, Tuesday this week and today.
Full Code is here so we can walk through it.

See INSTRUCTIONS.md ( click on the eye thing to see a readable version.)
    */

public class RadixSortStr {
    public static void main (String[] args) {
        List<String> Strings = new ArrayList<String>(Arrays.asList("thinger", "monkey","apple"));
        stringRadixSort(Strings, 26);
        System.out.println(Strings);

        


    }
    /*
     * 
     * public static void radixSort(String[] arr) {
     * int maxLen = getMaxStringLength(arr);
     * for (int digitPlace = maxLen - 1; digitPlace >= 0; digitPlace--) {
     * countingSort(arr, digitPlace);
     * }
     * }
     * 
     * public static int getMaxStringLength(String[] arr) {
     * int maxLen = 0;
     * for (String str : arr) {
     * maxLen = Math.max(maxLen, str.length());
     * }
     * return maxLen;
     * }
     * 
     * public static void countingSort(String[] arr, int digitPlace) {
     * int n = arr.length;
     * final int RANGE = 256; // Assuming ASCII characters
     * String[] output = new String[n];
     * int[] count = new int[RANGE];
     * 
     * for (String str : arr) {
     * int index = (digitPlace < str.length()) ? str.charAt(str.length() -
     * digitPlace - 1) : 0;
     * count[index]++;
     * }
     * 
     * for (int i = 1; i < RANGE; i++) {
     * count[i] += count[i - 1];
     * }
     * 
     * for (int i = n - 1; i >= 0; i--) {
     * int index = (digitPlace < arr[i].length()) ? arr[i].charAt(arr[i].length() -
     * digitPlace - 1) : 0;
     * output[count[index] - 1] = arr[i];
     * count[index]--;
     * }
     * 
     * System.arraycopy(output, 0, arr, 0, n);
     * }
     * 
     * public static void main(String[] args) {
     * String[] strings = {"apple", "banana", "grape", "date", "cherry"};
     * radixSort(strings);
     * System.out.println("Sorted Strings:");
     * for (String str : strings) {
     * System.out.println(str);
     * }
     * }
     */
    // taken from stack overflow because couldnt figure out in class one(its kinda
    // hard to understand compared to other sorts)
    public static void stringRadixSort(List<String> list, int letters) {
        if (list.size() <= 1) {//https://stackoverflow.com/questions/36476183/string-radix-sort-stringindexoutofboundseception
            return;
        }
        List<String>[] buckets = new List[256];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        int longestlen = -1;
        int secondlonglen = 0;
        

        for (String s : list) {
            int len = s.length();
            if (len >= longestlen) {
                secondlonglen = longestlen;
                longestlen = len;

            } else if (secondlonglen < len){
                secondlonglen = len;

            }




        }
        if (longestlen>letters) {
            throw new IllegalArgumentException("String too long");

        }
        for (int i=secondlonglen==longestlen?secondlonglen-1:secondlonglen;i>=0;i--){
            for (String word: list) {
                int index = (word.length()<=i)?0:word.charAt(i)-('a'-1);
                buckets[index].add(word);

            }
            list.clear();

            for (List<String> lst : buckets) {
                if (lst != null) {
                    list.addAll(lst);
                    lst.clear();
                }

            }


        } 

    }
/* from stack overflow again
    public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
    List<T> r = new ArrayList<T>(c.size());
    for(Object o: c)
      r.add(clazz.cast(o));
    return r;

    
}
*/
}

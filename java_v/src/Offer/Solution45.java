package Offer;

import java.util.*;
import java.util.stream.Collectors;

public class Solution45 {
    public String minNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            ss[i] = String.valueOf(nums[i]);
        Arrays.sort(ss, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : ss)
            res.append(s);
        return res.toString();
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        list.sort((Comparator.comparingInt(o -> o)));

        return list.subList(0, k).stream().mapToInt(Integer::intValue).toArray();
    }
}

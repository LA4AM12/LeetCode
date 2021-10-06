package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution53 {
    public int search(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (list.contains(target))
            return list.lastIndexOf(target)- list.indexOf(target) + 1 ;
        return 0;
    }
}

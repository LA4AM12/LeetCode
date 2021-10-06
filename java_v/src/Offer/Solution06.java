package Offer;

import Offer.struct.ListNode;

import java.util.*;

public class Solution06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pt = head;
        while (pt != null) {
            list.add(pt.val);
            pt = pt.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return ' ';
    }

}


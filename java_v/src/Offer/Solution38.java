package Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution38 {
    private char[] chars;
    private int len;
    private List<String> ans;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        len = chars.length;
        ans = new ArrayList<>();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }

    public void dfs(int pos){
        if (pos == len - 1) {
            ans.add(String.valueOf(chars));
            return;
        }
        //对于每个位置pos  重复的就跳过
        Set<Character> set = new HashSet<>();
        for (int i = pos; i < len; i++) {
            if (set.contains(chars[i]))
                continue;
            //此时要确定pos位置上的一个字符 选了的字符都放在前面
            set.add(chars[i]);
            swap(pos,i);
            dfs(pos+1);
            //回溯  再换回来 继续选择下一个
            swap(pos,i);
        }
    }

    private void swap(int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

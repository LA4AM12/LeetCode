package Offer;

public class Solution58 {
    public String reverseWords(String s) {
        String[] arr = s.stripLeading().split("[ ]+");
        int len = arr.length;
        StringBuilder builder = new StringBuilder(arr[len-1]);

        for (int i = len-2;i>=0;i--){
            builder.append(" ");
            builder.append(arr[i]);
        }

        return builder.toString();
    }
}

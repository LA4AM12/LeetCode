package Offer;

public class Solution46 {
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int n = s.length();

        int p = 1,q = 1;

        for (int i = 1; i < n; i++) {
            int t = q;
            if (s.charAt(i-1) == '1'|| s.charAt(i-1) == '2' && s.charAt(i) <= '5')
                t += p;
            p = q;
            q = t;
        }

        return q;
    }
}

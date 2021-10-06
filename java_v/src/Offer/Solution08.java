package Offer;

public class Solution08 {
    public int strToInt(String str) {
        char[] c = str.stripLeading().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1;
        boolean positive = true;
        if(c[0] == '-') positive = false;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return positive ? res : res * -1;
    }
}

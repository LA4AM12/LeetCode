package Offer;

public class Solution43 {
    public int countDigitOne(int n) {
        //digit为1表示个位
        int digit = 1, res = 0;

        //维护当前位 及其高位和低位
        int high = n / 10, cur = n % 10, low = 0;

        while(high != 0 || cur != 0) {
            //只和高位有关
            if(cur == 0) res += high * digit;
            //和高位、低位有关
            else if(cur == 1) res += high * digit + low + 1;
            //只和高位有关
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}

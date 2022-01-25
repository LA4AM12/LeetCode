package math;

/**
 * @author : LA4AM12
 * @create : 2022-01-24 18:06:07
 * @description : Monotone Increasing Digits
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        char[] digit = String.valueOf(n).toCharArray();
        int flag = digit.length;

        // in reverse order
        for (int i = digit.length - 2; i >= 0; i--) {
            if (digit[i + 1] < digit[i]) {
                digit[i] = (char) (digit[i] - 1);
                //  [flag:] will be set to '9'
                flag = i + 1;
            }
        }

        for (int i = flag; i < digit.length; i++) {
            digit[i] = '9';
        }

        return Integer.parseInt(new String(digit));
    }
}

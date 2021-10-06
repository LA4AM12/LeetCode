package Offer;

public class Solution44 {
    public int findNthDigit(int n) {
        if (n == 0) return 0;
        int scale = 1;  //表示一个数字是几位数
        int range = 9;    //对于scale位的所有数字的字符串长度

        while (n > range){
            n -= range;
            scale++;
            range = (int) (9*scale*Math.pow(10,scale-1));
        }
        //此时可知num为scale位
        long num = (long) (Math.pow(10,scale-1)) + (n-1)/scale; //n所属的数字
//        System.out.println(num);

        return Long.toString(num).charAt((n-1)%scale) - '0';
    }
}

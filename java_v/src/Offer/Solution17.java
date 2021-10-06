package Offer;


//大数版本
public class Solution17 {
    StringBuilder res;
    char[] chars = {'0','1','2','3','4','5','6','7','8','9'};
    //start为起始位，用于去除首部的0
    //nine 表示数字中有几个9
    int n,start,nine;
    char[] temp;

    //n == 3 :  "1,2,3,...,999"
    public String printNumbers(int n) {
        start = (this.n = n) - 1;
        temp = new char[n];
        res = new StringBuilder();
        dfs(0);

        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    private void dfs(int x){
        if(x == n){
            res.append(new String(temp).substring(start)).append(",");
            if (nine == n - start){
                --start;
//                nine = 0;
            }
            return;
        }
        for (char c : chars){
            //固定第 X 位
            temp[x] = c;
            if (c == '9')
                ++nine;
            dfs(x+1);
        }
        --nine;
    }
}

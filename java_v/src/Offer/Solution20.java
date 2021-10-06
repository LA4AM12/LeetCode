package Offer;

public class Solution20 {
    public boolean isNumber(String s) {
        boolean flag = true;
        s = s.strip();
        //找一下是否有 e/E
        int id_e = s.indexOf('e');
        int id_E = s.indexOf('E');
        if (id_e != -1) {
            flag = (isDecimal(s.substring(0, id_e)) || isInteger(s.substring(0, id_e))) & isInteger(s.substring(id_e + 1));
        } else if (id_E != -1) {
            flag = (isDecimal(s.substring(0, id_E)) || isInteger(s.substring(0, id_E))) & isInteger(s.substring(id_E + 1));
        } else {
            flag = (isDecimal(s) || isInteger(s));
        }
        return flag;
    }

    public boolean isInteger(String s) {
        if (s.length() == 0) return false;
        return s.charAt(0) == '+' || s.charAt(0) == '-' ? isDigital(s.substring(1)) : isDigital(s);
    }

    public boolean isDecimal(String s) {
        if (s.length() == 0) return false;
        int idx;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);

        if ((idx = s.indexOf('.')) == -1) return false;


        if (idx == 0){
            return isDigital(s.substring(1));
        } else if (idx == s.length()-1){
            return isDigital(s.substring(0,s.length()-1));
        } else {
            return isDigital(s.substring(0,idx)) && isDigital(s.substring(idx+1));
        }
    }

    public boolean isDigital(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' > 9 || s.charAt(i) - '0' < 0)
                return false;
        }
        return true;
    }
}

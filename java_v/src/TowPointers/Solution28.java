package TowPointers;

/**
 * @author : LA4AM12
 * @create : 2021-11-18 15:26:07
 * @description : Implement strStr()
 */
public class Solution28 {
	public int strStr(String haystack, String needle) {

		int i1 = 0, i2 = 0;
		while (i1 < haystack.length() && i2 < needle.length()) {
			if (haystack.charAt(i1) == needle.charAt(i2)) {
				++i2;
			} else {
				i1 = i1 - i2;
				i2 = 0;
			}
			++i1;
		}

		if (i2 != needle.length())
			return -1;
		else return i1 - i2;
	}
}

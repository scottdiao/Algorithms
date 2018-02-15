package leetcode;
/**
*
* @author Scott
*/
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
	int len = words.length;
	int[] value = new int[len];
	for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
        //    value[i] store words[i] by using 26 bit 
//                The reason use 1<< is that let the value of 'a' to be 1?
//                Yes, otherwise, 'a' will be missed since 'a' - 'a' = 0.
            }
	}
	int maxProduct = 0;
	for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 )
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
            }
	return maxProduct;
    }
}

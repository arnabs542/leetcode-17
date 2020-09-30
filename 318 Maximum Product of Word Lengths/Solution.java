class Solution {
    // Bit Manipulation
    // In Java, int takes 32 bits, as in English, we only have 26 characters
    // so that we can use int to store bit information of each character
    // Ref: https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!
    public int maxProduct(String[] words) {
        // special cases handling
        if (words == null || words.length == 0) return 0;

        // create & init char mapping info
        int wordsNumber = words.length;
        int[] charMapValue = new int[wordsNumber];
        for (int i = 0; i < wordsNumber; i++) {
            charMapValue[i] = 0;
            String curWord = words[i];
            for (int j = 0; j < curWord.length(); j ++) {
                // use bits to store char information
                charMapValue[i] |= 1 << (curWord.charAt(j) - 'a');
            }
        }

        // find a pair with no duplicate char info
        int maxProduct = 0;
        for (int i = 0; i < wordsNumber; i++) {
            for (int j = i + 1; j < wordsNumber; j++) {
                // there is no duplicate char between the word pair
                if ((charMapValue[i] & charMapValue[j]) == 0) {
                    int wordPairProduct = words[i].length() * words[j].length();
                    if (wordPairProduct > maxProduct) maxProduct = wordPairProduct;
                }
            }
        }

        return maxProduct;
    }
}
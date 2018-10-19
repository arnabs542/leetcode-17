class Solution {
    public String getHint(String secret, String guess) {
        // as the length of secret and guess is always the same
        // thus we can compare digits from left to right
        // otherwise it makes more sense to compare from right to left
        int len = secret.length();
        int a = 0;
        int c = 0; // number of digits that matches

        Map<Character, Integer> secretCharMap = new HashMap<>();
        Map<Character, Integer> guessCharMap = new HashMap<>();

        // calculate a and b
        for(int i = 0; i < len; i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            // update a
            if(secretChar == guessChar) {
                a++;
            }

            // update char map
            if(secretCharMap.get(secretChar) == null) {
                secretCharMap.put(secretChar, 1);
            } else {
                secretCharMap.put(secretChar, secretCharMap.get(secretChar) + 1);
            }

            // update char map
            if(guessCharMap.get(guessChar) == null) {
                guessCharMap.put(guessChar, 1);
            } else {
                guessCharMap.put(guessChar, guessCharMap.get(guessChar) + 1);
            }
        }

        // update c
        for(char secretChar: secretCharMap.keySet()) {
            if(guessCharMap.get(secretChar) != null) {
                c += Math.min(secretCharMap.get(secretChar), guessCharMap.get(secretChar));
            }
        }

        // calculate b
        int b = c - a;

        return a + "A" + b + "B";
    }
}
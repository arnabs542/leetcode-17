class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if(words.length == 0) return result;

        int concatLen = words.length * words[0].length(); // assume all words are of same length
        for(int i = 0; i < s.length() - concatLen + 1; i++) {
            if(isWordsConcat(s, i, words)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isWordsConcat(String s, int start, String[] words) {
        int wordLen = words[0].length();
        int len = words.length * wordLen; // assume all words are of same length
        Map<String, Integer> wordInfoMap = buildWordInfo(words); // hash map of word and count
        for(int i = start; i < start + len; i += wordLen) {
            String tempStr = s.substring(i, i + wordLen);
            if(wordInfoMap.get(tempStr) == null) {
                // word not in the word list
                return false;
            } else {
                int curWordCount = wordInfoMap.get(tempStr);
                if(curWordCount >= 1) {
                    // the word has occured once, update the count info
                    wordInfoMap.put(tempStr, curWordCount - 1);
                } else {
                    // the word shows too many times
                    return false;
                }
            }
        }
        return true;
    }

    private Map<String, Integer> buildWordInfo(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for(String word: words) {
            if(result.get(word) == null) {
                result.put(word, 1);
            } else {
                result.put(word, result.get(word) + 1);
            }
        }
        return result;
    }
}
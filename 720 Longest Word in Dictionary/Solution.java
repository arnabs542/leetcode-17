// reference: http://www.cnblogs.com/jimmycheng/p/7849104.html
// The key method is sorting!!!
class Solution {
    public String longestWord(String[] words) {
        String result = "";

        // sort String array
        Arrays.sort(words);

        // find the longest word
        Set<String> strSet = new HashSet<>();
        for(String word: words) {
            if (word.length() == 1 || strSet.contains(word.substring(0, word.length() - 1))) {
                if (word.length() > result.length()) result = word;
                strSet.add(word);
            }
        }

        return result;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramStringMap = new HashMap<>();
        for (String s: strs) {
            String anagramsString = this.constructAnagramsString(s);
            List<String> anagramStringList;
            if (anagramStringMap.get(anagramsString) == null) {
                anagramStringList = new ArrayList<>();
                anagramStringMap.put(anagramsString, anagramStringList);
            } else {
                anagramStringList = anagramStringMap.get(anagramsString);
            }
            anagramStringList.add(s);
        }
        List<List<String>> result = new ArrayList<List<String>>(anagramStringMap.values());
        return result;
    }

    private String constructAnagramsString(String s) {
        int len = 26; // from a to z
        String anagramsString = "";
        for (int i = 0; i < len; i++) {
            anagramsString += '0';
        }
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            int position = c - 'a';
            int currentCount = anagramsString.charAt(position) - '0';
            char newCount = (char)('0' + currentCount + 1);
            anagramsString = anagramsString.substring(0, position) + newCount + anagramsString.substring(position + 1);
        }
        return anagramsString;
    }
}
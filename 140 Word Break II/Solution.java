class Solution {
    // Approaches to solve the problem:
    // 1. Trie + DFS/Backtracking
    // 2. Trie + Recursion
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak_Recursion_Final(s, wordDict);
    }

    private List<String> wordBreak_DFS(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        String currentResult = "";
        dfs(s, wordDict, currentResult, result);
        return result;
    }

    // use DFS/Backtracking to go through all possible cases
    // record final results during DFS/Backtracking
    private void dfs(String s, List<String> wordDict, String currentResult, List<String> result) {
        // special case handling
        if (s.length() == 0) {
            if (currentResult.length() > 0)
                result.add(currentResult);
            return;
        }

        // recursively run dfs
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                String newS = s.substring(word.length());
                String newResult = currentResult.equals("") ? word : currentResult + " " + word;
                dfs(newS, wordDict, newResult, result);
            }
        }
    }

    private List<String> wordBreak_Recursion_Final(String s, List<String> wordDict) {
        Map<String, List<String>> resultMap = new HashMap<>();
        return wordBreak_Recursion(s, wordDict, resultMap);
    }

    // use Recursion - Will Time Limit Exceeded
    // easy to write and understand, trade-off on performance
    // use memorization to optimize performance to avoid duplicate computation *
    private List<String> wordBreak_Recursion(String s, List<String> wordDict, Map<String, List<String>> resultMap) {
        // use memorization to avoid duplicate computation
        if (resultMap != null && resultMap.containsKey(s))
            return resultMap.get(s);

        List<String> result = new ArrayList<>();

        // special case handling
        if (s == null || s.length() == 0 || wordDict.size() == 0)
            return result;

        // recursively build the result
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                // build new string for sub-problems
                String newS = s.substring(word.length());

                // special case handling
                if (newS.length() == 0) {
                    result.add(word);
                    continue;
                }

                // recursively build sub-results
                List<String> subResult = wordBreak_Recursion(newS, wordDict, resultMap);

                // update current result
                for (String tempSubResult: subResult) {
                    result.add(word + " " + tempSubResult);
                }
            }
        }

        // update memorization
        if (resultMap != null)
            resultMap.put(s, result);

        return result;
    }
}
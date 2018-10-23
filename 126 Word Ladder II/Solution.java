class Solution {
    private Map<String, List<String>> possibleEdits;
    private Map<String, Integer> wordDistance;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.possibleEdits = new HashMap<>();
        this.wordDistance = new HashMap<>();

        // use BFS to find the min path and min distance for each word
        bfs(beginWord, endWord, wordList);

        // use DFS to find the path with the result from BFS to reduce the search space
        this.possibleEdits = new HashMap<>();
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();

        List<String> newWordList = new ArrayList<>(wordList);
        newWordList.add(beginWord);
        dfs(endWord, beginWord, newWordList, path, result);

        return result;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, List<String> path, List<List<String>> result) {
        // find the path
        if(beginWord.equals(endWord)) {
            path.add(beginWord);
            Collections.reverse(path);
            result.add(path);
            return;
        }

        // wrong path
        if(this.wordDistance.get(beginWord) == null) return;

        path.add(beginWord);
        List<String> nextWords = getPossibleEdits(beginWord, wordList);
        for(String tempWord: nextWords) {
            if(this.wordDistance.get(tempWord) != null && this.wordDistance.get(tempWord) == (this.wordDistance.get(beginWord) - 1)) {
                List<String> newPath = new ArrayList<String>(path);
                dfs(tempWord, endWord, wordList, newPath, result);
            }
        }
    }

    // find min distance from beginWord to each word needed to the endWord
    private void bfs(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        this.wordDistance.put(beginWord, 0);

        while(!queue.isEmpty()) {
            String curWord = queue.poll();
            int curLevel = this.wordDistance.get(curWord);

            // find the path
            if(curWord.equals(endWord)) continue;

            List<String> nextWords = getPossibleEdits(curWord, wordList);
            for(String tempWord: nextWords) {
                if(wordDistance.get(tempWord) == null) {
                    queue.add(tempWord);
                    this.wordDistance.put(tempWord, curLevel + 1);
                }
            }
        }
    }

    // O(word.length * 26) - complexity
    private List<String> getPossibleEdits(String word, List<String> wordList) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if(this.possibleEdits.get(word) != null) return possibleEdits.get(word);

        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for(char tempChar = 'a'; tempChar <= 'z'; tempChar++) {
                if(tempChar != originalChar) {
                    chars[i] = tempChar;
                    String tempWord = new String(chars);
                    if(wordSet.contains(tempWord)) result.add(tempWord);
                }
            }
            chars[i] = originalChar;
        }

        this.possibleEdits.put(word, result);

        return result;
    }
}
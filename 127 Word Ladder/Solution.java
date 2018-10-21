class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return getMinPath(beginWord, endWord, wordList);
    }

    // BFS
    private int getMinPath(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levelqueue = new LinkedList<>();
        queue.add(beginWord);
        levelqueue.add(1);
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            String curWord = queue.poll();
            int curLevel = levelqueue.poll();

            List<String> nextWords = getPossibleEdits(curWord, wordList);
            for(String tempWord: nextWords) {
                // find the path
                if(tempWord.equals(endWord)) {
                    return curLevel + 1;
                }

                if(!visited.contains(tempWord)) {
                    queue.add(tempWord);
                    levelqueue.add(curLevel + 1);
                    visited.add(tempWord);
                }
            }
        }

        return 0;
    }

    private List<String> getPossibleEdits(String word, List<String> wordList) {
        List<String> result = new ArrayList<>();
        for(String curWord: wordList) {
            if(editable(word, curWord)) result.add(curWord);
        }
        return result;
    }

    private boolean editable(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            if(aChar != bChar) {
                diff++;
                if(diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
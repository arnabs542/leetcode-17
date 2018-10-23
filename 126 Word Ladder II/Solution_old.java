class Solution {
    // for this problem, I can think of two ways to solve the issue:
    // 1. as it needs to list all possible solutions, we can try to solve the issue using recursion,
    // 2. as this recursion may contain duplicate computation, we could use DP to avoid the duplication and help improve the performance
    // 3. as word list is given, we know all the possible edit with the current word, thus, we could also use BFS or DFS to find all the path

    private Set<List<String>> result;
    private int shortestPath;
    private Map<String, List<String>> editsMap;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return this.findLadders_DFS_main(beginWord, endWord, wordList);
    }

    // Time Limit Exceeded solution
    private List<List<String>> findLadders_DFS_main(String beginWord, String endWord, List<String> wordList) {
        this.result = new HashSet<>();
        this.shortestPath = Integer.MAX_VALUE;
        this.editsMap = new HashMap<>();

        if(wordList.contains(endWord)) {
            Map<String, Boolean> visitedWord = new HashMap<>();
            List<String> curPath = new ArrayList<>();
            this.findLadders_DFS(beginWord, endWord, wordList, visitedWord, curPath);
        } else {
            this.result.add(new ArrayList<>());
        }

        // filter not non-shortest results
        List<List<String>> finalResult = new ArrayList<>();
        for(List<String> path: this.result) {
            if(path.size() == this.shortestPath) finalResult.add(path);
        }
        return finalResult;
    }

    private void findLadders_DFS(String beginWord, String endWord, List<String> wordList, Map<String, Boolean> visitedWord, List<String> curPath) {
        // not the shortest path
        if(curPath.size() > this.shortestPath) {
            return;
        }

        if(visitedWord.get(beginWord) != null && visitedWord.get(beginWord)) {
            // has visited the string
            return;
        }

        curPath.add(beginWord);
        visitedWord.put(beginWord, true);

        // get to the end result
        if(beginWord.equals(endWord)) {
            // update shortestPath
            if(curPath.size() < this.shortestPath) this.shortestPath = curPath.size();

            List<String> subResult = new ArrayList<>(curPath);
            this.result.add(subResult);
            curPath.remove(beginWord);
            visitedWord.put(beginWord, false);
            return;
        }

        // search by depth frist
        List<String> nextEdits = this.possibleEdits(beginWord, wordList);
        for(String nextEdit: nextEdits) {
            this.findLadders_DFS(nextEdit, endWord, wordList, visitedWord, curPath);
        }

        curPath.remove(beginWord);
        visitedWord.put(beginWord, false);
    }

    // public void findLadders_BFS(String beginWord, String endWord, List<String> wordList) {
    // }

    // public List<List<String>> findLadders_recursion(String beginWord, String endWord, List<String> wordList) {
    // }

    private List<String> possibleEdits(String word, List<String> wordList) {
        // get from map if possible to save some time
        if(this.editsMap.get(word) != null) {
            return this.editsMap.get(word);
        }

        List<String> result = new ArrayList<>();

        for(String curWord: wordList) {
            if(this.editable(word, curWord)) result.add(curWord);
        }

        // updata editsMap
        this.editsMap.put(word, result);

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
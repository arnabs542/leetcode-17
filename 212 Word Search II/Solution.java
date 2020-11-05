class Solution {
    // We can use the following approaches for this problem
    // - DFS/Backtracking
    // - Map
    public List<String> findWords(char[][] board, String[] words) {
        return findWords_Map(board, words);
    }

    class Position {
        public int row;
        public int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position p = (Position) o;
            return this.row == p.row && this.col == p.col;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 17;
            hash = hash * prime + this.row;
            hash = hash * prime + this.col;
            return hash;
        }
    }

    private List<String> findWords_Map(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // special case handling
        if (board == null || words == null)
            return result;

        int rows = board.length;
        int cols = board[0].length;

        // build a map of chars and postions
        Map<Character, Set<Position>> charPosMap = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char curChar = board[i][j];
                Position curPos = new Position(i, j);
                if (charPosMap.containsKey(curChar)) {
                    charPosMap.get(curChar).add(curPos);
                } else {
                    Set<Position> posSet = new HashSet<>();
                    posSet.add(curPos);
                    charPosMap.put(curChar, posSet);
                }
            }
        }

        // for each word, check if we can build it using char and position map
        Set<Position> usedPos = new HashSet<>();
        // TODO: optimize this part
        Map<Position, Set<String>> posWordsMap = null; // new HashMap<>();
        for (String word: words) {
            if (canBuildWord(word, charPosMap, usedPos, posWordsMap, null))
                result.add(word);
        }

        return result;
    }

    // recursilve check if we can build a word using the char and position map
    private boolean canBuildWord(String word, Map<Character, Set<Position>> charPosMap, Set<Position> usedPos, Map<Position, Set<String>> posWordsMap, Position startPos) {
        int len = word.length();

        // special case handling
        if (len == 0) return true;
        if (charPosMap == null) return false;

        // check if we can build the word
        if (startPos == null) {
            // check if first char exists
            char firstChar = word.charAt(0);
            Set<Position> positions = charPosMap.get(firstChar);
            if (positions != null) {
                for (Position tempPos: positions) {
                    if (!usedPos.contains(tempPos) &&
                        canBuildWord(word, charPosMap, usedPos, posWordsMap, tempPos)) {
                            return true;
                        }
                }
            }
        } else {
            // we found the first char, check the next char
            if (len == 1)
                return true;

            // check cache to avoid duplicate computation
            if (posWordsMap != null) {
                Set<String> canBuildWords = posWordsMap.get(startPos);
                if (canBuildWords != null && canBuildWords.contains(word))
                    return true;
            }

            char nextChar = word.charAt(1);
            Set<Position> positions = charPosMap.get(nextChar);
            if (positions != null) {
                for (Position tempPos: positions) {
                    if (!usedPos.contains(tempPos) && isAdjacentPosition(tempPos, startPos)) {
                        usedPos.add(startPos);
                        if (canBuildWord(word.substring(1), charPosMap, usedPos, posWordsMap, tempPos)) {
                            usedPos.remove(startPos);
                            addPositionWordMapping(posWordsMap, startPos, word);
                            return true;
                        } else {
                            usedPos.remove(startPos);
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean isAdjacentPosition(Position p1, Position p2) {
        int rowDiff = Math.abs(p1.row - p2.row);
        int colDiff = Math.abs(p1.col - p2.col);
        return ((rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1));
    }

    private void addPositionWordMapping(Map<Position, Set<String>> posWordsMap, Position p, String word) {
        if (posWordsMap != null) {
            if (posWordsMap.get(p) != null) {
                posWordsMap.get(p).add(word);
            } else {
                Set<String> wordSet = new HashSet<>();
                wordSet.add(word);
                posWordsMap.put(p, wordSet);
            }
        }
    }
}
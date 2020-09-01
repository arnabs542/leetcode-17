class Trie {
    class TrieNode {
        public boolean isWord;
        public char val;
        public Map<Character, TrieNode> children;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.children = null;
        }
    }

    private TrieNode rootTrieNode;

    /** Initialize your data structure here. */
    public Trie() {
        this.rootTrieNode = new TrieNode('#');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = this.rootTrieNode;
        // create node for each character
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);

            // init children if needed
            if (curNode.children == null) {
                curNode.children = new HashMap<>();
            }

            // create child node if needed
            if (curNode.children.get(curChar) != null) {
                curNode = curNode.children.get(curChar);
            } else {
                TrieNode newNode = new TrieNode(curChar);
                curNode.children.put(curChar, newNode);
                curNode = newNode;
            }

            // set isWord if needed
            if (i == (word.length() - 1)) {
                curNode.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = this.rootTrieNode;

        // search Trie nodes by levels from root node
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);

            if (curNode.children != null && curNode.children.get(curChar) != null) {
                curNode = curNode.children.get(curChar);
            } else {
                return false;
            }

            // check if it is a word
            if (i == (word.length() - 1) && curNode.isWord) {
                return true;
            }
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = this.rootTrieNode;

        // search Trie nodes by levels from root node
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);

            if (curNode.children != null && curNode.children.get(curChar) != null) {
                curNode = curNode.children.get(curChar);
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
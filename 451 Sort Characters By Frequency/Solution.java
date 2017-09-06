class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequencyMap.get(c) != null) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }

        return this._buildStringFrequencyDes(frequencyMap);
    }

    private class CharFrequencyMap {
        private char c;
        private int frequency;

        CharFrequencyMap(char c, int frequency) {
          this.c = c;
          this.frequency = frequency;
        }

        public char getC() {
            return this.c;
        }

        public int getFrequency() {
            return this.frequency;
        }
    }

    private String _buildStringFrequencyDes(Map<Character, Integer> frequencyMap) {
        StringBuffer sb = new StringBuffer();
        List<CharFrequencyMap> listCharFrequencyMap = new ArrayList<CharFrequencyMap>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            CharFrequencyMap charFrequencyMap = new CharFrequencyMap(entry.getKey(), entry.getValue());
            listCharFrequencyMap.add(charFrequencyMap);
        }

        // Implement a reverse-order Comparator by lambda function
        Comparator<CharFrequencyMap> comp = (CharFrequencyMap a, CharFrequencyMap b) -> {
            return b.getFrequency() - a.getFrequency();
        };

        Collections.sort(listCharFrequencyMap, comp);

        for (CharFrequencyMap charFrequencyMap: listCharFrequencyMap) {
            char curChar = charFrequencyMap.getC();
            int frequency = charFrequencyMap.getFrequency();
            for (int i = 0; i < frequency; i++) {
                sb.append(curChar);
            }
        }

        return sb.toString();
    }
}

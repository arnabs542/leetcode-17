public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteCharacterNumberMap = this.constructCharacterNumberMapFromString(ransomNote);
        Map<Character, Integer> magazineCharacterNumberMap = this.constructCharacterNumberMapFromString(magazine);

        Set<Character> ransomNoteCharacterSet = ransomNoteCharacterNumberMap.keySet();
        for (char curCharacter: ransomNoteCharacterSet) {
            int ransomNoteCharacterNum = ransomNoteCharacterNumberMap.get(curCharacter);
            if (magazineCharacterNumberMap.get(curCharacter) == null || magazineCharacterNumberMap.get(curCharacter) < ransomNoteCharacterNum) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> constructCharacterNumberMapFromString(String s) {
        Map<Character, Integer> CharacterNumberMap = new HashMap<Character, Integer>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i ++) {
            char curCharacter = s.charAt(i);
            if (CharacterNumberMap.get(curCharacter) != null) {
              CharacterNumberMap.put(curCharacter, CharacterNumberMap.get(curCharacter) + 1);
            } else {
              CharacterNumberMap.put(curCharacter, 1);
            }
        }
        return CharacterNumberMap;
    }
}

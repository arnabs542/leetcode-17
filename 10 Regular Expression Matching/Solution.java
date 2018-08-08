class Solution {
    // use recursion
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        if (lenS == 0) {
            if (lenP == 0) {
                return true;
            } else if (p.charAt(lenP - 1) == '*') {
                return isMatch(s, p.substring(0, lenP - 2));
            }
            return false;
        }

        if (lenP == 0) {
            return lenS == 0;
        } else if (lenP == 1) {
            if (lenS == 1) {
                return s.equals(p) || p.equals(".");
            } else {
                return false;
            }
        } else {
            char lastP = p.charAt(lenP - 1);
            if (lastP == '*') {
                char lastlastP = p.charAt(lenP - 2);
                if (lastlastP == '.') {
                    for (int i = lenS; i >= 0; i--) {
                        if (isMatch(s.substring(0, i), p.substring(0, lenP - 2))){
                            return true;
                        }
                    }
                    return false;
                } else {
                    for (int i = lenS; i >= 0; i--) {
                        if (i != lenS && s.charAt(i) != lastlastP) {
                            break;
                        }
                        if (isMatch(s.substring(0, i), p.substring(0, lenP - 2))){
                            return true;
                        }
                    }
                    return false;
                }
            } else if (lastP == '.') {
                return isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
            } else {
                char lastS = s.charAt(lenS - 1);
                if (lastS != lastP) {
                    return false;
                } else {
                    return isMatch(s.substring(0, lenS - 1), p.substring(0, lenP - 1));
                }
            }
        }
    }

    // public boolean isMatch_old2(String s, String p) {
    //     // construct letter count
    //     List<LetterCount> letterCountS = getLetterCount(s);
    //     List<LetterCountRange> letterCountP = getLetterCountRange(p);

    //     System.out.println(letterCountS);
    //     System.out.println(letterCountP);

    //     int lenS = letterCountS.size();
    //     int lenP = letterCountP.size();

    //     if (lenP < lenS) {
    //         return false;
    //     }

    //     // compare letters one by one
    //     int curS = 0;
    //     int curP = 0;

    //     while (curS < lenS && curP < lenP) {
    //         LetterCount tempLetterCountS = letterCountS.get(curS);
    //         LetterCountRange tempLetterCountP = letterCountP.get(curP);

    //         if (tempLetterCountS.getLetter() == tempLetterCountP.getLetter() ||
    //             isDot(tempLetterCountP.getLetter())) {
    //             if (tempLetterCountS.getCount() >= tempLetterCountP.getMinRange() &&
    //                 tempLetterCountS.getCount() <= tempLetterCountP.getMaxRange()) {
    //                     curS++;
    //                     curP++;
    //             } else {
    //                 return false;
    //             }
    //         } else if (tempLetterCountP.getMinRange() == 0) {
    //             curP++;
    //         } else {
    //             return false;
    //         }
    //     }

    //     if (curS == lenS && curP <= lenP) {
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // private List<LetterCount> getLetterCount(String s) {
    //     int lenS = s.length();
    //     List<LetterCount> result = new ArrayList<LetterCount>();
    //     int curS = 0;
    //     while (curS < lenS) {
    //         char curLetter = s.charAt(curS);
    //         int countLetter = 1;
    //         curS++;
    //         while(curS < lenS && s.charAt(curS) == curLetter) {
    //             countLetter++;
    //             curS++;
    //         }
    //         LetterCount tempLetterCountS = new LetterCount(curLetter, countLetter);
    //         result.add(tempLetterCountS);
    //     }
    //     return result;
    // }

    // private List<LetterCountRange> getLetterCountRange(String p) {
    //     int lenP = p.length();
    //     List<LetterCountRange> result = new ArrayList<LetterCountRange>();
    //     int curP = 0;
    //     while (curP < lenP) {
    //         char curLetter = p.charAt(curP);
    //         int countLetter = 1;
    //         int minRange;
    //         int maxRange;
    //         curP++;
    //         if (curP < lenP && isStar(p.charAt(curP))) {
    //             minRange = 0;
    //             maxRange = Integer.MAX_VALUE;
    //             curP++;
    //         } else {
    //             while(curP < lenP && p.charAt(curP) == curLetter && !isDot(p.charAt(curP))) {
    //                 countLetter++;
    //                 curP++;
    //             }
    //             minRange = countLetter;
    //             maxRange = countLetter;
    //         }
    //         LetterCountRange tempLetterCountP = new LetterCountRange(curLetter, minRange, maxRange);
    //         result.add(tempLetterCountP);
    //     }
    //     return result;
    // }

    // private class LetterCount {
    //     private char letter;
    //     private int count;

    //     public LetterCount(char letter, int count) {
    //         this.letter = letter;
    //         this.count = count;
    //     }

    //     public char getLetter() {
    //         return this.letter;
    //     }

    //     public int getCount() {
    //         return this.count;
    //     }

    //     public String toString() {
    //         return "[letter: " + this.letter + ", count: " + this.count + "]";
    //     }
    // }

    // private class LetterCountRange {
    //     private char letter;
    //     private int minRange;
    //     private int maxRange;

    //     public LetterCountRange(char letter, int minRange, int maxRange) {
    //         this.letter = letter;
    //         this.minRange = minRange;
    //         this.maxRange = maxRange;
    //     }

    //     public char getLetter() {
    //         return this.letter;
    //     }

    //     public int getMinRange() {
    //         return this.minRange;
    //     }

    //     public int getMaxRange() {
    //         return this.maxRange;
    //     }

    //     public String toString() {
    //         return "[letter: " + this.letter + ", minRange: " + this.minRange + ", maxRange: " + this.maxRange + "]";
    //     }
    // }

    // private boolean isDot(char c) {
    //     return c == '.';
    // }

    // private boolean isStar(char c) {
    //     return c == '*';
    // }

    // public boolean isMatch_old1(String s, String p) {
    //     int cursorS = 0;
    //     int cursorP = 0;
    //     int lenS = s.length();
    //     int lenP = p.length();

    //     while (cursorP < lenP && cursorS < lenS) {
    //         char curP = p.charAt(cursorP);

    //         // letter cases
    //         if (this.isLetter(curP)) {
    //             if (curP + 1 >= lenP ||
    //                 !this.isStar(p.charAt(cursorP + 1))) {
    //                 // sinlge letter case
    //                 char curS = s.charAt(cursorS);
    //                 if (curP != curS) {
    //                     return false;
    //                 } else {
    //                     cursorP++;
    //                     cursorS++;
    //                 }
    //             } else {
    //                 // letter with star case

    //             }
    //         } else if (this.isDot(curP)) {
    //             // dot cases
    //             if (curP + 1 >= lenP ||
    //                 !this.isStar(p.charAt(cursorP + 1))) {
    //                 // single dot case
    //                 char curS = s.charAt(cursorS);
    //                 if (this.isLetter(curS)) {
    //                     cursorP++;
    //                     cursorS++;
    //                 } else {
    //                     return false;
    //                 }
    //             } else {
    //                 // dot with star case

    //             }
    //         }
    //     }

    //     if (cursorP < lenP || cursorS < lenS) {
    //         return false;
    //     }

    //     return true;
    // }
}
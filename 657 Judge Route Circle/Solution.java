class Solution {
    public boolean judgeCircle(String moves) {
        int uCount = 0;
        int dCount = 0;
        int lCount = 0;
        int rCount = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') uCount++;
            else if (c == 'D') dCount++;
            else if (c == 'L') lCount++;
            else if (c == 'R') rCount++;
        }

        return uCount == dCount && lCount == rCount;
    }
}

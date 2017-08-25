// reference: http://blog.csdn.net/mebiuw/article/details/52575028

public class Solution {
    public int findNthDigit(int n) {
        int digitType = 1;
        long digitNum = 9;

        while(n > digitNum*digitType){
            n -= (int) digitNum*digitType ;
            digitType++;
            digitNum*=10;
        }

        int indexInSubRange = (n -1) / digitType;
        int indexInNum = (n -1) % digitType;

        int num = (int) Math.pow(10,digitType - 1) + indexInSubRange;
        int result = Integer.parseInt((""+num).charAt(indexInNum)+"");
        return result;
    }
}

import java.util.ArrayList;

class Solution {
    private Map<Integer, Integer> facotryMap = new HashMap<>();

    public String getPermutation(int n, int k) {
        // assume n and k are valid
        // generate a list of nums avaliable to generate strings
        List<Integer> nums = getNums(n);

        StringBuilder sb = new StringBuilder();
        int target = k; // target kth element for the current nums
        for(int i = 0; i < n; i++) {
            // update target kth element for the current nums
            // and append digit by digit to the result
            target = appendDigit(nums, target, sb);
        }

        return sb.toString();
    }

    /**
     * return a list of [1..n] in ascending order
     * @param n a positive integer greater than 0
     * @return a list of [1..n] in ascending order
     */
    private List<Integer> getNums(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * append the first digit to result string and update nums and new target
     * appended number will be removed from nums input and new target will be returned
     * @param nums a list of available numbers in asending order
     * @param target target kth element
     * @param sb result string builder
     * @return new target
     */
    private int appendDigit(List<Integer> nums, int target, StringBuilder sb) {
        int len = nums.size();
        int possiblePermutationsPerDigit = getFactory(len - 1);

        int curPos;
        int newTarget;
        if(target <= possiblePermutationsPerDigit) {
            curPos = 0;
            newTarget = target;
        } else if(target % possiblePermutationsPerDigit == 0){
            curPos = target / possiblePermutationsPerDigit - 1;
            newTarget = possiblePermutationsPerDigit;
        } else {
            curPos = target / possiblePermutationsPerDigit;
            newTarget = target % possiblePermutationsPerDigit;
        }

        int curDigit = nums.get(curPos);
        sb.append(Integer.toString(curDigit));
        nums.remove(curPos);

        return newTarget;
    }

    private int getFactory(int n) {
        if(this.facotryMap != null && this.facotryMap.get(n) != null) {
            return this.facotryMap.get(n);
        }

        int result = 1;
        for(int i = 2; i <= n; i++) {
            result *= i;
        }
        this.facotryMap.put(n, result);
        return result;
    }
}
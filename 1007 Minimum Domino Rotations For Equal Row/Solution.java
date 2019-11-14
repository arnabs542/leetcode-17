class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> numStat = new HashMap<>();
        Map<Integer, Integer> numStatA = new HashMap<>();
        Map<Integer, Integer> numStatB = new HashMap<>();

        int num = A.length;
        if(num == 0) return -1;
        if(num == 1) return 0;

        for(int a: A) {
            if(numStat.containsKey(a)) numStat.put(a, numStat.get(a) + 1);
            else numStat.put(a, 1);
            if(numStatA.containsKey(a)) numStatA.put(a, numStatA.get(a) + 1);
            else numStatA.put(a, 1);
        }

        for(int b: B) {
            if(numStat.containsKey(b)) numStat.put(b, numStat.get(b) + 1);
            else numStat.put(b, 1);
            if(numStatB.containsKey(b)) numStatB.put(b, numStatB.get(b) + 1);
            else numStatB.put(b, 1);
        }

        boolean hasResult = false;
        int targetSet = 0;
        for(int key: numStat.keySet()) {
            if(numStat.get(key) >= num) {
                hasResult = true;
                targetSet = key;
                break;
            }
        }

        if(!hasResult) return -1;

        for(int i = 0; i < num; i++) {
            if(A[i] != targetSet && B[i] != targetSet) return -1;
        }

        return num - Math.max(numStatA.get(targetSet), numStatB.get(targetSet));
    }

    public int minDominoRotations_Greedy(int[] A, int[] B) {
        Map<Integer, Integer> numStatA = new HashMap<>();
        Map<Integer, Integer> numStatB = new HashMap<>();

        int num = A.length;
        if(num == 0) return -1;
        if(num == 1) return 0;

        Set<Integer> targetSet = new HashSet<>();
        targetSet.add(A[0]);
        targetSet.add(B[0]);
        for(int i = 0; i < num; i++) {
            int a = A[i];
            int b = B[i];

            if(numStatA.containsKey(a)) numStatA.put(a, numStatA.get(a) + 1);
            else numStatA.put(a, 1);
            if(numStatB.containsKey(b)) numStatB.put(b, numStatB.get(b) + 1);
            else numStatB.put(b, 1);

            if((i + 1) < num) {
                Set<Integer> curSet = new HashSet<>();
                Set<Integer> nextSet = new HashSet<>();
                curSet.add(A[i]);
                curSet.add(B[i]);
                nextSet.add(A[i + 1]);
                nextSet.add(B[i + 1]);
                curSet.retainAll(nextSet);
                targetSet.retainAll(curSet);
            }
        }

        if(targetSet.size() != 1) return -1;
        int target = 0;
        for(int temp: targetSet) {
        	target = temp;
        }

        return num - Math.max(numStatA.get(target), numStatB.get(target));
    }
}
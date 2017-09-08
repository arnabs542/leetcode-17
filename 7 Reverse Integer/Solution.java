class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int temp = Math.abs(x);

        List<Integer> digits = new ArrayList<Integer>();
        while (temp != 0) {
            digits.add(temp % 10);
            temp = temp / 10;
        }

        long reverse = 0;
        long scale = 1;
        for (int i = digits.size() - 1; i >= 0; i--) {
            reverse += scale * digits.get(i);
            scale = scale * 10;

            // handle overflow or underflow
            if (reverse >= Integer.MAX_VALUE) {
                return 0;
            }
        }

        if (x < 0) {
            reverse = reverse * (-1);
        }

        return (int)reverse;
    }
}

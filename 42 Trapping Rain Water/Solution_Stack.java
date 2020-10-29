class Solution {
    class Bar {
        public int height;
        public int position;

        public Bar(int height, int position) {
            this.height = height;
            this.position = position;
        }
    }

    public int trap(int[] height) {
        // special case handling
        if (height == null || height.length == 0) return 0;

        int len = height.length;
        int area = 0;
        Stack<Bar> stack = new Stack<>(); // use Stack to record water heights

        // scan bars from left to right to simulate water acculation process
        for (int i = 0; i < len; i++) {
            Bar currentBar = new Bar(height[i], i);
            if (stack.empty()) {
                // new water area starts from here
                stack.push(currentBar);
            } else {
                // there are some bars in the left can form new water area
                int prevHeight = stack.peek().height;
                if (currentBar.height < prevHeight) {
                    // cannot form a new water area yet
                    stack.push(currentBar);
                } else if (currentBar.height == prevHeight) {
                    // update previous bar
                    stack.pop();
                    stack.push(currentBar);
                } else if (currentBar.height > prevHeight) {
                    // can form a new water area for previous bars lower than or equals to current one
                    while (!stack.empty() && stack.peek().height <= currentBar.height) {
                        Bar prevBar = stack.pop();
                        if (!stack.empty()) {
                            area += (Math.min(currentBar.height, stack.peek().height) - prevBar.height) * (i - stack.peek().position - 1);
                        }
                    }
                    stack.push(currentBar);
                }
            }
        }

        return area;
    }
}
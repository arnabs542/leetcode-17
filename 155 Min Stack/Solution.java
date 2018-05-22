class MinStack {
    private int curPos;
    private List<Integer> elements;
    private int minNum;

    /** initialize your data structure here. */
    public MinStack() {
        this.curPos = -1;
        this.elements = new ArrayList<>();
        this.minNum = Integer.MAX_VALUE;
    }

    public void push(int x) {
        this.curPos++;
        this.elements.add(this.curPos, x);
        if (x < this.minNum) {
            this.minNum = x;
        }
    }

    public void pop() {
        int numToRemove = this.elements.get(this.curPos);
        if (numToRemove == this.minNum) {
            this.minNum = this.getMinNum(this.elements.subList(0, this.curPos));
        }
        this.curPos--;
    }

    public int top() {
        return this.elements.get(this.curPos);
    }

    public int getMin() {
        return this.minNum;
    }

    private int getMinNum(List<Integer> list) {
        int minNum = Integer.MAX_VALUE;
        for (int num: list) {
            if (num < minNum) {
                minNum = num;
            }
        }
        return minNum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
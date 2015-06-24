/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
*/

class MyStack {
	//the main queue
	private Queue<Integer> q1 = new LinkedList<Integer>();
	//the helper queue
	private Queue<Integer> q2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
    	//the main queue is empty, directly add the element
        if (q1.peek() == null) {
        	q1.add(x);
        }
        //use the helper queue, add the element to the head of the main queue
        else {
        	while (q1.peek() != null) {
        		int temp = q1.remove();
        		q2.add(temp);
        	}
        	q1.add(x);
        	while (q2.peek() != null) {
        		int temp = q2.remove();
        		q1.add(temp);
        	}
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
    	q1.remove();
    }

    // Get the top element.
    public int top() {
        int head = q1.peek();
        return head;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (q1.peek() == null) {
        	return true;
        }
        return false;
    }
}
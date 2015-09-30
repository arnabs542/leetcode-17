public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int overallArea = getArea(A, B, C, D) + getArea(E, F, G, H);
    	int overlapArea = overlapLength(A, C, E, G) * overlapLength(B, D, F, H);
        return (overallArea - overlapArea);
    }

    // caclulate the overlap of two line segments
    private int overlapLength (int x11, int x12, int x21, int x22) {
    	// no overlap
    	if (x12 < x21 || x11 > x22) {
    		return 0;
    	}
    	// one contains another
    	else if (x11 >= x21 && x12 <= x22) {
    		return x12 - x11;
    	}
    	// one contains another
    	else if (x11 <= x21 && x12 >= x22) {
    		return x22 - x21;
    	}
    	// with overlap
    	else {
    		if (x11 < x21) {
    			return x12 - x21;
    		}
    		else {
    			return x22 - x11;
    		}
    	}
    }

    // get the area of an rectangle
    private int getArea (int A, int B, int C, int D) {
    	return (C - A) * (D - B);
    }
}
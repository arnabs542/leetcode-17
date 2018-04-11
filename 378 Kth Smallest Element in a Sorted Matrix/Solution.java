import java.util.List;
import java.util.Set;

/**
 * this solution takes the advantage of the original data structure
 * that the m[x][y] > m[x-1][y] && m[x][y] > m[x][y-1]
 * so that we do not need to scan the whole matrix, just need to
 * traverse the whole matrix in the way that increase
 */
class Solution {
    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public int hashCode() {
            return this.x * this.y * 17;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            final Point b = (Point) obj;
            return (this.x == b.getX() && this.y == b.getY());
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Point> pointsToCompare = new HashSet<>();
        Set<Point> comparedPoints = new HashSet<>();
        pointsToCompare.add(new Point(0, 0));
        
        int result = 0;
        for (int i = 0; i < k; i++) {
            Point pointToRemove = removeSamllestPoint(pointsToCompare, matrix);
            comparedPoints.add(pointToRemove);
            if (pointToRemove.getX() + 1 < row && !comparedPoints.contains(new Point(pointToRemove.getX() + 1, pointToRemove.getY()))) {
                pointsToCompare.add(new Point(pointToRemove.getX() + 1, pointToRemove.getY()));
            }
            if (pointToRemove.getY() + 1 < col && !comparedPoints.contains(new Point(pointToRemove.getX(), pointToRemove.getY() + 1))) {
                pointsToCompare.add(new Point(pointToRemove.getX(), pointToRemove.getY() + 1));
            }
            result = matrix[pointToRemove.getX()][pointToRemove.getY()];
        }
        
        return result;
    }

    private Point removeSamllestPoint(Set<Point> pointsToCompare, int[][] matrix) {
        int min = Integer.MAX_VALUE;
        Point pointToRemove = null;
        for (Point currentPoint: pointsToCompare) {
            int currentVal = matrix[currentPoint.getX()][currentPoint.getY()];
            if (currentVal < min) {
                min = currentVal;
                pointToRemove = currentPoint;
            }
        }
        pointsToCompare.remove(pointToRemove);
        return pointToRemove;
    }
}

/**
 * this is a passed solution, this solution is just to sort the array
 * taking advantage of the sort function of the array, thus
 * the complexity of the algorithm is nlog(n)
 */
class Solution_sortArray {
    public int kthSmallest(int[][] matrix, int k) {
        int[] sortedArray = getSortedArray(matrix);
        return sortedArray[k - 1];
    }

    private int[] getSortedArray(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int len = -1;
        int[] sortedArray = new int[row * col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                len++;
                sortedArray[len] = matrix[i][j];
            }
        }

        Arrays.sort(sortedArray);
        
        return sortedArray;
    }
}
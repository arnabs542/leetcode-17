class Solution {
    class Point {
        private int x;
        private int y;
        private int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int rowNum = forest.size();
        int colNum = forest.get(0).size();

        if(forest.get(0).get(0) == 0) return -1;

        // queue to store points that have tree in asending order
        Queue<Point> pointQueue = new PriorityQueue<>(2500, new Comparator<Point>() {
            @Override
    		public int compare(Point p1, Point p2) {
                return p1.getValue() - p2.getValue();
            }
        });

        // init the queue
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                int tempVal = forest.get(i).get(j);
                if(tempVal > 1) {
                    Point p = new Point(i, j, tempVal);
                    pointQueue.offer(p);
                }
            }
        }

        // calculate steps between points having trees
        int step = 0;
        Point startP = new Point(0, 0, forest.get(0).get(0));
        while(pointQueue.peek() != null) {
            Point nextP = pointQueue.poll();
            Map<String, Integer> resultMap = new HashMap<>();
            int tempStep = getMinStepBetween(startP.getX(), startP.getY(), nextP.getX(), nextP.getY(), forest, nextP.getValue(), resultMap);
            if(tempStep == -1) {
                return -1;
            } else {
                step += tempStep;
            }
            startP = nextP;
        }

        return step;
    }

    // BFS - DFS will have stack overflow problem
    private int getMinStepBetween(int startPX, int startPY, int nextPX, int nextPY, List<List<Integer>> forest, int maxValue, Map<String, Integer> resultMap) {
        int rowNum = forest.size();
        int colNum = forest.get(0).size();

        // init dist array
        int[][] dist = new int[rowNum][colNum];
        int[][] visited = new int[rowNum][colNum];
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                visited[i][j] = 0;
            }
        }

        Queue<int[]> pointQueue = new LinkedList<>();
        int[] start = {startPX, startPY};
        pointQueue.offer(start);
        dist[startPX][startPY] = 0;
        visited[startPX][startPY] = 1;

        int[][] directs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while(pointQueue.peek() != null) {
            int[] curP = pointQueue.poll();
            int curPX = curP[0];
            int curPY = curP[1];

            for(int[] direct: directs) {
                int[] tempP = {curPX + direct[0], curPY + direct[1]};
                if(tempP[0] >= 0 && tempP[0] < rowNum &&
                    tempP[1] >=0 && tempP[1] < colNum &&
                    // forest.get(tempP[0]).get(tempP[1]) <= maxValue &&
                    forest.get(tempP[0]).get(tempP[1]) > 0 &&
                    visited[tempP[0]][tempP[1]] == 0) {
                    pointQueue.offer(tempP);
                    dist[tempP[0]][tempP[1]] = dist[curPX][curPY] + 1;
                    visited[tempP[0]][tempP[1]] = 1;

                    // return result quicker to avid unnecessary computation
                    if(tempP[0] == nextPX && tempP[1] == nextPY) return dist[nextPX][nextPY];
                }
            }
        }

        return dist[nextPX][nextPY] == Integer.MAX_VALUE ? -1 : dist[nextPX][nextPY];
    }

    private int  (int startPX, int startPY, int nextPX, int nextPY, List<List<Integer>> forest, int maxValue, Map<String, Integer> resultMap) {
        int rowNum = forest.size();
        int colNum = forest.get(0).size();

        if(startPX == nextPX && startPY == nextPY) {
            return 0;
        }

        int goUpStep = Integer.MAX_VALUE;
        int goDownStep = Integer.MAX_VALUE;
        int goLeftStep = Integer.MAX_VALUE;
        int goRightStep = Integer.MAX_VALUE;

        // up point
        if(nextPY - 1 >= 0 && forest.get(nextPX).get(nextPY - 1) < maxValue && forest.get(nextPX).get(nextPY - 1) > 0) {
            String s = getStrFromPoints(startPX, startPY, nextPX, nextPY - 1);
            if(resultMap.get(s) != null) {
                goUpStep = resultMap.get(s);
            } else {
                goUpStep = getMinStepBetween(startPX, startPY, nextPX, nextPY - 1, forest, maxValue, resultMap);
                if(goUpStep == -1) goUpStep = Integer.MAX_VALUE;
                resultMap.put(s, goUpStep);
            }
        }

        // down point
        if(nextPY + 1 < colNum && forest.get(nextPX).get(nextPY + 1) < maxValue && forest.get(nextPX).get(nextPY + 1) > 0) {
            String s = getStrFromPoints(startPX, startPY, nextPX, nextPY + 1);
            if(resultMap.get(s) != null) {
                goUpStep = resultMap.get(s);
            } else {
                goDownStep = getMinStepBetween(startPX, startPY, nextPX, nextPY + 1, forest, maxValue, resultMap);
                if(goDownStep == -1) goDownStep = Integer.MAX_VALUE;
                resultMap.put(s, goDownStep);
            }
        }

        // left point
        if(nextPX - 1 >= 0 && forest.get(nextPX - 1).get(nextPY) < maxValue && forest.get(nextPX - 1).get(nextPY) > 0) {
            String s = getStrFromPoints(startPX, startPY, nextPX - 1, nextPY);
            if(resultMap.get(s) != null) {
                goUpStep = resultMap.get(s);
            } else {
                goLeftStep = getMinStepBetween(startPX, startPY, nextPX - 1, nextPY, forest, maxValue, resultMap);
                if(goLeftStep == -1) goLeftStep = Integer.MAX_VALUE;
                resultMap.put(s, goLeftStep);
            }
        }

        // right point
        if(nextPX + 1 < rowNum && forest.get(nextPX + 1).get(nextPY) < maxValue && forest.get(nextPX + 1).get(nextPY) > 0) {
            String s = getStrFromPoints(startPX, startPY, nextPX + 1, nextPY);
            if(resultMap.get(s) != null) {
                goUpStep = resultMap.get(s);
            } else {
                goRightStep = getMinStepBetween(startPX, startPY, nextPX + 1, nextPY, forest, maxValue, resultMap);
                if(goRightStep == -1) goRightStep = Integer.MAX_VALUE;
                resultMap.put(s, goRightStep);
            }
        }

        int minStep = Math.min(Math.min(Math.min(goUpStep, goDownStep), goLeftStep), goRightStep);

        return (minStep == Integer.MAX_VALUE) ? -1 : minStep + 1;
    }

    private String getStrFromPoints(int x1, int y1, int x2, int y2) {
        return "(" + Integer.toString(x1) + "," + Integer.toString(y1) + "," + Integer.toString(x2) + "," + Integer.toString(y2) + ")";
    }
}
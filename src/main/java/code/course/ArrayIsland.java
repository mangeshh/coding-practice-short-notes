package code.course;

import java.util.*;

@SuppressWarnings("unused")
public class ArrayIsland {

    Map<Point, Boolean> visited = new HashMap<>();
    static int a[][] = new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}};

    public int calculateArea(Point p, int cnt) {
        if (!visited.containsKey(p) && a[p.r][p.c] == 1) {
            visited.put(p, true);
            cnt++;
            List<Point> neighbours = findNeighbors(p);
            for (Point neighbour : neighbours) {
                cnt = Math.max(cnt, calculateArea(neighbour, cnt));
            }
        }
        return cnt;
    }

    public boolean isIndexValid(Point p) {
        int r = p.r;
        int c = p.c;
        if (r < 0 || r > (a.length - 1) || c < 0 || c > (a.length - 1)) {
            return false;
        }
        return true;
    }

    public List<Point> findNeighbors(Point p) {
        List<Point> list = new ArrayList<>();
        Point pr = new Point(p.r, p.c + 1);
        if (isIndexValid(pr)) {
            list.add(pr);
        }
        Point pl = new Point(p.r, p.c - 1);
        if (isIndexValid(pl)) {
            list.add(pl);
        }
        Point pu = new Point(p.r - 1, p.c);
        if (isIndexValid(pu)) {
            list.add(pu);
        }
        Point pd = new Point(p.r + 1, p.c);
        if (isIndexValid(pd)) {
            list.add(pd);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayIsland is = new ArrayIsland();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                Point startPoint = new Point(i, j);
                max = Math.max(max, is.calculateArea(startPoint, 0));
            }
        }
        System.out.println(max);
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r &&
                    c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}

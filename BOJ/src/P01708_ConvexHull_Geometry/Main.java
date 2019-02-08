package P01708_ConvexHull_Geometry;

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int ccw(Point p1, Point p2, Point p3) {
        long temp = (long)(p2.x-p1.x)*(long)(p3.y-p1.y)-(long)(p3.x-p1.x)*(long)(p2.y-p1.y);
        if (temp > 0) {
            return 1;
        } else if (temp < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    public static long dist (Point p1, Point p2) {
        long d1 = (long)(p1.x - p2.x);
        long d2 = (long)(p1.y - p2.y);
        return d1*d1 + d2*d2;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] a = new Point[n];
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Point(x, y);
        }
        Point p = a[0];
        for (int i=1; i<n; i++) {
            if (a[i].y < p.y || (a[i].y == p.y && a[i].x < p.x)) {
                p = a[i];
            }
        }
        final Point pp = p;
        Arrays.sort(a, new Comparator<Point>() {
            public int compare(Point u, Point v) {
                int temp = ccw(pp, u, v);
                if (temp == 0) {
                    long d1 = dist(pp, u);
                    long d2 = dist(pp, v);
                    if (d1 < d2) {
                        return -1;
                    } else if (d1 == d2) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    if (temp == 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });
        ArrayList<Point> stack = new ArrayList<Point>();
        for (int i=0; i<n; i++) {
            int size = stack.size();
            while (size >= 2 && ccw(stack.get(size-2), stack.get(size-1), a[i]) <= 0) {
                stack.remove(size-1);
                size -= 1;
            }
            stack.add(a[i]);
        }
        System.out.println(stack.size());
    }
}



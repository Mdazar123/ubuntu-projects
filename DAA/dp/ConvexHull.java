

import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size: ");
        int n = sc.nextInt();

        Point[] p = new Point[n];
        System.out.println("Enter the points:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p[i] = new Point(x, y);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = p[j].y - p[i].y;
                int b = p[i].x - p[j].x;
                int c = p[i].x * p[j].y - p[i].y * p[j].x;
                int noofpospoints = 0;
                int noofnegpoints = 0;

                for (int k = 0; k < n; k++) {
                    int val = (a * p[k].x) + (b * p[k].y) - c;
                    if (val > 0) {
                        noofpospoints++;
                    } else if (val < 0) {
                        noofnegpoints++;
                    }
                }

                if (noofpospoints == 0 || noofnegpoints == 0) {
                    System.out.printf("(%d,%d)(%d,%d) are edge p\n", p[i].x, p[i].y, p[j].x, p[j].y);
                }
            }
        }

        sc.close();
    }
}


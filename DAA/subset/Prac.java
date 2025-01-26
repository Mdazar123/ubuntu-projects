import java.util.Scanner;

class Pt {
    int x, y;

    public Pt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static void swp(Pt[] p, int i, int j) {
        Pt temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    static void qsort(Pt[] p, int low, int high, boolean sortByX) {
        if (low < high) {
            int pivotIdx = part(p, low, high, sortByX);
            qsort(p, low, pivotIdx - 1, sortByX);
            qsort(p, pivotIdx + 1, high, sortByX);
        }
    }

    static int part(Pt[] p, int low, int high, boolean sortByX) {
        int pivot = sortByX ? p[low].x : p[low].y;
        int i = low, j = high;
        while (i < j) {
            while (i < high && (sortByX ? p[i].x : p[i].y) <= pivot)
                i++;
            while (j > low && (sortByX ? p[j].x : p[j].y) > pivot)
                j--;
            if (i < j)
                swp(p, i, j);
        }
        swp(p, low, j);
        return j;
    }

    static double dist(Pt a, Pt b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static double brute(Pt[] p, int start, int end) {
        double min = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double d = dist(p[i], p[j]);
                if (d < min)
                    min = d;
            }
        }
        return min;
    }

    static double cp(Pt[] p, int start, int end) {
        if (end - start <= 2) {
            return brute(p, start, end);
        }
        int mid = (start + end) / 2;
        double left = cp(p, start, mid);
        double right = cp(p, mid + 1, end);
        return Math.min(left, right);
    }
}

public class Prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        int n = sc.nextInt();
        Pt[] pts = new Pt[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter point " + (i + 1) + " coordinates: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            pts[i] = new Pt(x, y);
        }
        Pt.qsort(pts, 0, n - 1, true);
        double minDist = Pt.cp(pts, 0, n - 1);
        System.out.println("Minimum distance: " + minDist);
        sc.close();
    }
}

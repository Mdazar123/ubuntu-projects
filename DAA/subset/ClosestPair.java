import java.util.Scanner;

class Point {
    int x, y;
}

public class ClosestPair {

    private static void swap(Point[] p, int i, int j){
        Point temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }

    private static void quickSort(Point[] p, int low, int high, boolean sortByX) {
        if (low < high) {
            int i = low, j = high;
            int pivot = sortByX ? p[low].x : p[low].y;
            while (i < j) {
                while (i < high && (sortByX ? p[i].x : p[i].y) <= pivot) i++;
                while (j > low && (sortByX ? p[j].x : p[j].y) > pivot) j--;
                if (i < j) swap(p, i, j);
            }
            swap(p, low, j);
            quickSort(p, low, j - 1, sortByX);
            quickSort(p, j + 1, high, sortByX);
        }
    }

    private static double bruteForce(Point[] p, int start, int end) {
        double min = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                double d = Math.sqrt(Math.pow(p[j].x - p[i].x, 2) + Math.pow(p[j].y - p[i].y, 2));
                if (d < min) min = d;
            }
        }
        return min;
    }

    private static double closestPair(Point[] p, int start, int end) {
        if (end - start <= 2) {
            return bruteForce(p, start, end);
        } else {
            int mid = (start + end) / 2;
            double leftDist = closestPair(p, start, mid);
            double rightDist = closestPair(p, mid + 1, end);
            double minDist = Math.min(leftDist, rightDist);

            Point[] strip = new Point[end - start + 1];
            int stripCount = 0;
            for (int i = start; i <= end; i++) {
                if (Math.abs(p[i].x - p[mid].x) < minDist) {
                    strip[stripCount++] = p[i];
                }
            }

            quickSort(strip, 0, stripCount - 1, false);

            for (int i = 0; i < stripCount - 1; i++) {
                for (int j = i + 1; j < stripCount && (strip[j].y - strip[i].y) < minDist; j++) {
                    double dist = Math.sqrt(Math.pow(strip[j].x - strip[i].x, 2) + Math.pow(strip[j].y - strip[i].y, 2));
                    if (dist < minDist) minDist = dist;
                }
            }
            return minDist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point();
            System.out.print("Enter point " + (i + 1) + " coordinates: ");
            points[i].x = scanner.nextInt();
            points[i].y = scanner.nextInt();
        }
        quickSort(points, 0, n - 1, true);
        double minDistance = closestPair(points, 0, n - 1);
        System.out.println("Minimum distance: " + minDistance);
        scanner.close();
    }
}

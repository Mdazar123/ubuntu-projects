import java.util.Arrays;

public class PrimAlgorithm {
    private static final int V = 5;
    int minKey(int key[], int visited[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (visited[v] == -1 && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to print the constructed MST
    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Function to construct and print the MST for a graph represented using adjacency matrix representation
    void primMST(int graph[][]) {
        int[] key = new int[V];  // Key values used to pick minimum weight edge in cut
        int[] parent = new int[V];  // Array to store the constructed MST
        int[] visited = new int[V];  // To represent set of vertices not yet included in MST

        // Initialize all keys as INFINITE and visited as -1
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(visited, -1);

        // Always include the first vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is picked as first vertex
        parent[0] = -1; // First node is always the root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, visited);

            // Add the picked vertex to the MST Set
            visited[u] = 1;

            // Update key value and parent index of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && visited[v] == -1 && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        PrimAlgorithm prim = new PrimAlgorithm();
        int graph[][] = new int[][] {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        // Print the solution
        prim.primMST(graph);
    }
}

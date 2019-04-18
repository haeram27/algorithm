import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* directional graph class using adjacency list */
class Graph {
    private int V; // number of vertexes
    private List<List<Integer>> adj; // adjacency list

    /** Constructor*/
    Graph(int v) {
        // initialize number of vertexes
        V = v;

        // initialize adjacency list
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<Integer>());
        }
    }

    /** 
     * connect links s->n 
     *  s - start node
     *  n - adjacent node
     */
    void addEdge(int s, int n) {
        adj.get(s).add(n);
    }

    /** print searched node using BFS start from s node */
    void BFS(int s) {
        // whether visited node (init value: false)
        boolean visited[] = new boolean[V];

        // Queue for BFS traversal
        Queue<Integer> queue = new ArrayDeque<Integer>();

        // check visited node and enqueue
        visited[s] = true;
        queue.offer(s);

        // loop until queue is empty
        while (!queue.isEmpty()) {
            // dequeue visited node and print it
            s = queue.poll();
            System.out.print(s + " ");

            // get adjacent all node of visited node
            for (int n : adj.get(s)) {
             // if it's not visited node then check it as visited and enqueue
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }   
            }
        }
    }
}

public class BFSExam {
    /** Driver */
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.BFS(0); /* BFS searching start from given node */
    }
}
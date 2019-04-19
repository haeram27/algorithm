import java.util.ArrayList;
import java.util.List;

/* ���� ����Ʈ�� �̿��� ���⼺ �ִ� �׷��� Ŭ���� */
class Graph {
    private int V; // ����� ����
    private List<List<Integer>> adj; // ���� ����Ʈ

    /** ������ */
    Graph(int v) {
        V = v;
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<Integer>());
        }
    }

    /** ��带 ���� s->n */
    void addEdge(int s, int n) {
        adj.get(s).add(n);
    }

    /** DFS�� ���� ���Ǵ� �Լ� */
    void DFSUtil(int s, boolean[] visited) {
        // ���� ��带 �湮�� ������ ǥ���ϰ� ���� ���
        visited[s] = true;
        System.out.print(s + " ");

        // �湮�� ���� ������ ��� ��带 �����´�.
        for (int n : adj.get(s)) {
            // �湮���� ���� ���� �ش� ��带 ���� ���� �ٽ� DFSUtil ȣ��
            if (!visited[n])
                DFSUtil(n, visited); // ��ȯ ȣ��
        }
    }

    /** �־��� ��带 ���� ���� DFS Ž�� */
    void DFS(int v) {
        // ����� �湮 ���� �Ǵ� (�ʱ갪: false)
        boolean[] visited = new boolean[V];

        // v�� ���� ���� DFSUtil ��ȯ ȣ��
        DFSUtil(v, visited);
    }

    /** DFS Ž�� */
    void DFS() {
        // ����� �湮 ���� �Ǵ� (�ʱ갪: false)
        boolean[] visited = new boolean[V];

        // �񿬰��� �׷����� ���, ��� ������ �ϳ��� �湮
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false)
                DFSUtil(i, visited);
        }
    }
}

public class DFSExam {

    /** ��� ��� */
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

        
        g.DFS(2); /* �־��� ��带 ���� ���� DFS Ž�� */
        System.out.println();
        g.DFS(); /* �񿬰��� �׷����� ��� */
    }
}
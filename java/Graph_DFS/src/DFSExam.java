import java.util.ArrayList;
import java.util.List;

/* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
class Graph {
    private int V; // 노드의 개수
    private List<List<Integer>> adj; // 인접 리스트

    /** 생성자 */
    Graph(int v) {
        V = v;
        adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<Integer>());
        }
    }

    /** 노드를 연결 s->n */
    void addEdge(int s, int n) {
        adj.get(s).add(n);
    }

    /** DFS에 의해 사용되는 함수 */
    void DFSUtil(int s, boolean[] visited) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[s] = true;
        System.out.print(s + " ");

        // 방문한 노드와 인접한 모든 노드를 가져온다.
        for (int n : adj.get(s)) {
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                DFSUtil(n, visited); // 순환 호출
        }
    }

    /** 주어진 노드를 시작 노드로 DFS 탐색 */
    void DFS(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean[] visited = new boolean[V];

        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }

    /** DFS 탐색 */
    void DFS() {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean[] visited = new boolean[V];

        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false)
                DFSUtil(i, visited);
        }
    }
}

public class DFSExam {

    /** 사용 방법 */
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

        
        g.DFS(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        System.out.println();
        g.DFS(); /* 비연결형 그래프의 경우 */
    }
}
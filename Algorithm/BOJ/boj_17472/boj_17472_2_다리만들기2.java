package BJ;

import java.io.*;
import java.util.*;

// Solution - Kruskal
// 섬들을 정점으로 만든다 -> DFS
// 간선(두 정점, 연결 비용) 구성
// 가로 ---> 섬들을 연결하는 간선
// 세로 ---> 섬들을 연결하는 간선
// 위 과정에서 파악되는 간선을 자료구조에 담는다. PriorityQueue(최소비용의 간선을 뽑기 위해 이용)
// 최소 비용의 간선부터 선택해가면서 정점 수 - 1개를 완성(단, 사이클이 생기지 않도록 <= 서로소 findset, union . . .)

public class boj_17472_2_다리만들기2 {
    static int N, M, min;
    static int[][] map;

    // 정점, 간선
    static int V; // 정점의 수
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost); // 간선

    // dfs
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // Kruskal
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * (-1); // 육지를 -1로 <- 정점 번호를 1부터..
            }
        }

        // 풀이
        // 1. DFS로 번호 붙이기
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1 && !visit[i][j]) {
                    dfs(i, j, num); // num 번호를 i, j와 연결된 모든 곳에 저장
                    num++;
                }
            }
        }
        // 2. 서로소 관련 작업
        // 정점의 수
        V = num - 1;
        parent = new int[V+1];
        makeSet(V);

        // 3. Kruskal 알고리즘 적용
        hr(); // 옆으로
        vr(); // 밑으로
        // 위 작업이 끝나면 pqueue에 간선이 들어간다.
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.v1, e.v2)) {
                min += e.cost;
                cnt++;
            }
            if (cnt == V - 1) break; // 선택된 간선의 수가 완성
        }
        if (cnt != V - 1) min = -1;
        System.out.println(min == 0 ? -1 : min);
    }
    static void addEdge(int v1, int v2, int cost) {
        boolean same = false;

        for (Edge edge : pq) {
            if (edge.v1 == v1 && edge.v2 == v2) {
                same = true;
                edge.cost = Math.min(edge.cost, cost);
                break;
            }
        }

        if (!same) pq.offer(new Edge(v1, v2, cost));
    }

    static void hr() {
        for (int i = 0; i < N; i++) {
            int prev = 0, curr = 0, v1 = 0, v2 = 0, cost = 0;

            for (int j = 0; j < M; j++) {
                curr = map[i][j];
                if (prev == 0 && curr != 0) { // 0 (바다, 시작 경계선) -> 0 아님 (섬)
                    if (v1 == 0) v1 = curr; // 시작 경계선
                    else {
                        // edge 발생
                        v2 = curr;
                        if (cost > 1) {
                            addEdge(v1, v2, cost); // 간선 확정
                        }

                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                } else if (v1 != 0 && curr == 0) {
                    cost++;
                }
                prev = curr;
            }
        }
    }

    static void vr() {
        for (int i = 0; i < M; i++) {
            int prev = 0, curr = 0, v1 = 0, v2 = 0, cost = 0;

            for (int j = 0; j < N; j++) {
                curr = map[j][i];
                if (prev == 0 && curr != 0) { // 0 (바다, 시작 경계선) -> 0 아님 (섬)
                    if (v1 == 0) v1 = curr; // 시작 경계선
                    else {
                        // edge 발생
                        v2 = curr;
                        if (cost > 1) {
                            addEdge(v1, v2, cost); // 간선 확정
                        }

                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                } else if (v1 != 0 && curr == 0) {
                    cost++;
                }
                prev = curr;
            }
        }
    }
    static void dfs(int y, int x, int num) {
        visit[y][x] = true;
        map[y][x] = num;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
            if (map[ny][nx] == -1) dfs(ny, nx, num);
        }
    }
    static void makeSet(int num) {
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
        }
    }
    static int findSet(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findSet(parent[x]);
    }
    static boolean union(int x, int y) { // Kruskal 알고리즘에서 간선 선택과정에서 사이클이 생기는 부분에 대한 코드 효율 증가(void -> boolean)
        int px = findSet(x);
        int py = findSet(y);

        if (py == px) return false;

        if (px < py) parent[py] = px;
        else parent[px] = py;

        return true;
    }

    // 간선
    static class Edge {
        int v1, v2, cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}
}

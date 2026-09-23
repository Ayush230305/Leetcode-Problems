import java.util.*;
public class Kruskal {
    static class Edge {
        int u, v, wt;Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static int[] parent;
    static int[] rank;
    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        Collections.sort(edges, (a, b) -> a.wt - b.wt);
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int mstWeight = 0;
        int count = 0;
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                System.out.println(e.u + " - " + e.v + " : " + e.wt);
                mstWeight += e.wt;
                count++;
                if (count == n - 1)break;
            }
        }
        System.out.println("Minimum Cost = " + mstWeight);
    }
}
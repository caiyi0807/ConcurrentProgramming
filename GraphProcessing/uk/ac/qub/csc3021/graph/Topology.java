package uk.ac.qub.csc3021.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Topology {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List
        Topology(int v) {
            this.V = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                this.adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void topologicalSortUtil(int v, boolean visited[], Stack stack) {
            visited[v] = true;
            Integer i;
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }
            stack.push(new Integer(v));
        }

    void topologicalSort()
    {
        Stack stack = new Stack();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

}

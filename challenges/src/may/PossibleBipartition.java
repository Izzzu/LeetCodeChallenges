package may;

import java.util.Iterator;
import java.util.LinkedList;



public class PossibleBipartition {

    class Graph
    {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; //Adjacency Lists

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function which adds an edge from v -> w
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }

        // Function which prints BFS traversal from a given source 's'
        void BFS(int s)
        {
            // mark all vertices as false, (i.e. they are not visited yet)
            boolean visited[] = new boolean[V];

            // Create a new queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() > 0)
            {
                // pop a vertex from queue and print it
                s = queue.poll();
                System.out.print(s+" ");

                //Traverse all the adjacent vertices of current vertex,
                //check if they are not visited yet, mark them visited and push them into the queue.
                Iterator<Integer> it = adj[s].listIterator();
                while (it.hasNext() == true)
                {
                    int n = it.next();
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
        Boolean isCyclicUtil(int v, Boolean visited[], int parent)
        {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext())
            {
                i = it.next();

                // If an adjacent is not visited, then recur for that
                // adjacent
                if (!visited[i])
                {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }

                // If an adjacent is visited and not parent of current
                // vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        Boolean isCyclic()
        {
            // Mark all the vertices as not visited and not part of
            // recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in
            // different DFS trees
            for (int u = 0; u < V; u++)
                if (!visited[u]) // Don't recur for u if already visited
                    if (isCyclicUtil(u, visited, -1))
                        return true;

            return false;
        }


    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Graph graph = new Graph(N);
        for (int[] edge : dislikes) {
            graph.addEdge(edge[0]-1, edge[1]-1);
        }


        return graph.isCyclic();


    }

}

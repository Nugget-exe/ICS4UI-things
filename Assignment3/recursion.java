package Assignment3;
import java.util.*;

public class recursion {

    public static ArrayList<Integer> nodestraversed = new ArrayList<Integer>();
    public static ArrayList<String> cycledetected = new ArrayList<>();

    public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> adj_list, boolean[] vis, int[] dist) {
        for (int neigh : adj_list.get(node)) {
            System.out.print(node + " ");
            nodestraversed.add(node);

            if (!vis[neigh]) {
                vis[neigh] = true;
                dist[neigh] = dist[node] + 1;
                dfs(neigh, adj_list, vis, dist);
            }
        }
    }

    public static boolean findcycle(int node, boolean visited[], int parent, HashMap<Integer, ArrayList<Integer>> adj_list) {
        visited[node] = true;
        for (int i : adj_list.get(node)) {
            if (!visited[i]) {
                if (findcycle(i, visited, node, adj_list))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Scanner Input = new Scanner(System.in);

        System.out.println("Enter start node");
        int start = Input.nextInt();
        int times = Input.nextInt();

        for (int i = 0; i < times; i++) {
            System.out.println("Enter a node");
            int a = Input.nextInt();
            System.out.println("Enter a node connected to previous");
            int b = Input.nextInt();
            adj.putIfAbsent(a, new ArrayList<>());
            adj.get(a).add(b);
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(b).add(a);
        }
        System.out.println(adj);

        boolean[] Visited = new boolean[adj.size() + 1];
        int[] distance = new int[adj.size() + 1];

        Arrays.fill(Visited, false);
        Arrays.fill(distance, -1);

        System.out.println(Arrays.toString(distance));

        Visited[start] = true;

        dfs(start, adj, Visited, distance);

        boolean[] vis = new boolean[adj.size() + 1];

        for (int node = 1; node < adj.size() + 1; node++) {
            if (!vis[node] && findcycle(node, vis, -1, adj)) {
                cycledetected.add("Cycle detected at node: " + node);
            }
        }

        System.out.println("DIstance array: " + Arrays.toString(distance));
        System.out.println(distance[1]);
        System.out.println(cycledetected);

        Input.close();
    }
}

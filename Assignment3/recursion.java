package Assignment3;
import java.util.*;

public class recursion {

    public static ArrayList<Integer> nodestraversed = new ArrayList<Integer>();//public arrays so i can access them in main program file
    public static ArrayList<String> cycledetected = new ArrayList<>();


    //dfs logic

    public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> adj_list, boolean[] vis, int[] dist) {
        for (int neigh : adj_list.get(node)) {//for each neighbour in the hashmap
            System.out.print(node + " ");//print the node
            nodestraversed.add(node);// add node to nodes traversed

            if (!vis[neigh]) {// if node is not visited(false)
                vis[neigh] = true;// mark it as visited
                dist[neigh] = dist[node] + 1;// distance of neigh is equal to distnode plus 1
                dfs(neigh, adj_list, vis, dist);//recursively call dfs
            }
        }
    }

    public static boolean findcycle(int node, boolean visited[], int parent, HashMap<Integer, ArrayList<Integer>> adj_list) {
        visited[node] = true;//mark node as visited
        for (int i : adj_list.get(node)) {// iterating over adj_list
            if (!visited[i]) {// if the node i is not visited
                if (findcycle(i, visited, node, adj_list))// if findcycle is true
                    return true;//return true
            } else if (i != parent)//if i is not equal to parent
                return true;//return true
        }
        return false;//base case false
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

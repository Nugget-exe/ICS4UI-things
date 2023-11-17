package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class recursion {// will be doing dfs tibg, so similar to cs club

    public static ArrayList<Integer> nodestraversed = new ArrayList<Integer>();

    public static ArrayList<String> cycledetected = new ArrayList<>();
    public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> adj_list, boolean[] vis, int[] dist) {// https://stackoverflow.com/questions/14783831/java-implementation-of-adjacency-list

        for (int neigh : adj_list.get(node)) {// similar to python "for neigh in adj_list[node]:"
            System.out.print(node + " ");//prints nodes traveled
            nodestraversed.add(node);


        
            if (!vis[neigh]) {// if node is not true

                // here we're setting part of the visited list to true, as we just visited this
                // node
                vis[neigh]=true;// https://stackoverflow.com/questions/39909475/change-values-in-an-arraylist
                


                dist[neigh]=dist[node]+1;// calculate distance

                dfs(neigh, adj_list, vis, dist);// recursively call dfs until vis is set to true for all values
                
            
            }




        }
        

    }

    public static void findcycle(int node, int parentNode, HashMap<Integer, ArrayList<Integer>> adj_list,  boolean[] vis) {
        vis[node] = true;
        

        for (int neigh : adj_list.get(node)) {
            
            if (!vis[neigh]) {
                vis[neigh] = true;
                findcycle(neigh, parentNode, adj_list, vis);

            } else if (node != parentNode){
                System.out.println("Cycle detected at node: "+neigh);
            
            } 

        }


    }

    public static void main(String[] args) {
       

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();//create a hasmap that we'll traverse in


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

        boolean[] Visited = new boolean[adj.size()+1];
        int[] distance = new int[adj.size()+1];

        for (int o = 0; o <Visited.length;o++) {
            Visited[o] = false;



        }

        for (int l=0; l <distance.length;l++) {//init distance array with -1 for all nodes
            
            distance[l]= -1;
            

        }
        System.out.println(Arrays.toString(distance));

        Visited[start]=true;

        dfs(start, adj, Visited, distance);//run the dfs algo

        boolean[] vis = new boolean[adj.size()+1];

        for (int node = 1;node < adj.size()+1 ;node++) {// check every node for a cycle
             if (vis[node] == false) {
                    findcycle(node, -1, adj, vis);

                }
            
            /*
            if (adj.containsKey(node)) {
                if (Visited[node] == false) {
                    findcycle(node, -1, adj, Visited);

                }
                
            }else {
                System.out.println("node " +node+ " does not exist");
            }
*/

            


        }
        
        
        System.out.println("DIstance array: " + Arrays.toString(distance));//print distance array
        System.out.println(distance[1]);

        Input.close();

    }

}

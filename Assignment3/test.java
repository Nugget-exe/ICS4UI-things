package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import Assignment3.recursion;

public class test {
    public static void main(String[] args) {
        System.out.println("hi");
        cacc thign = new cacc(4.0);
        System.out.println(thign.getinterest(1));
        thign.addmoney(1);
        thign.addmoney(1);
        thign.addmoney(1);
        thign.addmoney(1);
        System.out.println(thign.getinterest(1));
        System.out.println(thign.gethist());

        System.out.println("bye");
        savings thing = new savings(4.0);
        System.out.println(thing.getinterest(1));
        thing.addmoney(1);
        thing.addmoney(1);
        thing.addmoney(1);
        thing.addmoney(1);
        System.out.println(thing.getinterest(1));
        System.out.println(thing.gethist());

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
            
            distance[l]=-1;
            

        }
        System.out.println(Arrays.toString(distance));

        Visited[start]=true;

        recursion.dfs(start, adj, Visited, distance);//run the dfs algo

        boolean[] vis = new boolean[adj.size()+1];

        for (int node = 1;node < adj.size()+1 ;node++) {// check every node for a cycle
             if (vis[node] == false) {
                    recursion.findcycle(node, -1, adj, vis);

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
        System.out.println(distance[8]);

        Input.close();
    }
}

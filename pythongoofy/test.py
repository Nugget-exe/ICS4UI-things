adj = {0:[1,2], 1:[0,2], 2:[1,0],3:[4],4:[3,5],5:[4]}
vis = [False for _ in range(5)]
dist = [-1 for _ in range(5)]
start = 0

'''
# recursive DFS
def dfs(node):
    for neigh in adj[node]:
        
        if not vis[neigh]:
            vis[neigh] = True

            dist[neigh]=dist[node]+1
            
            
            dfs(neigh)
           
vis[start] = True
dfs(start)

print(dist)
'''


#cycle detection
vis = [0 for _ in range(6)]
# visited state can either be 0 - not visited, 1 - exploring, 2 - visited


def dfs(node, parent):
    vis[node] = 1
    for neigh in adj[node]:
        if neigh == parent: 
            continue # traversing back on an undirected edge is not a cycle
        if vis[neigh] == 0:
            
            dfs(neigh, node)
        elif vis[neigh] == 1:
            print("Cycle detected at node " + str(neigh))


# we start from every possible node, since the graph might not be connected


for node in range(0, 5):
    if vis[node] == 0:
        dfs(node, -1)
'''
Enter a node connected to previous
{0=[1, 2], 1=[0, 2], 2=[1, 0], 3=[4], 4=[3, 5], 5=[4]}
[-1, -1, -1, -1, -1, -1, -1]
0 1 1 2 2 0 Cycle detected at node: 3
Cycle detected at node: 4
DIstance array: [-1, 0, 1, -1, -1, -1, -1]
-1


'''
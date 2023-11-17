# breadth first search - queue


from collections import deque






grap = {"A": ["D", "G", "B"], "B": ["A", "C", "E"], "C": ["B"], "D": ["A", "H"], "E": ["B", "H"], "H": ["E", "F"], "F": ["H"]}


#ABCDEFGH


graph = {1: [4, 7, 2], 2: [1, 3, 5], 3: [2], 4: [1, 8], 5: [2, 8], 8: [5, 6], 6: [8], 7: [1]}


vis = [False for _ in range(10)]
dist = [-1 for _ in range(10)]


start = 3
q = deque()
q.append(start)
vis[start] = True
dist[start] = 0


while q:
  node = q.popleft()
  print(node, dist[node])
  for neigh in graph[node]:
    if not vis[neigh]:
      q.append(neigh)
      vis[neigh] = True
      dist[neigh] = dist[node] + 1
     
print(dist)

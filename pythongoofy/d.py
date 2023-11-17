w = input()
r, c = int(input()), int(input())
grid = []
h = 0

for i in range(r):
    grid.append(input().split())

directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

def perpendicular(direct):
    if direct == directions[0] or direct == directions[7]: return [directions[2], directions[5]]
    elif direct == directions[1] or direct == directions[6]: return [directions[3], directions[4]]
    elif direct == directions[2] or direct == directions[5]: return [directions[0], directions[7]]
    elif direct == directions[3] or direct == directions[4]: return [directions[1], directions[6]]

def search(row, col, word, direct=None, turn=False):
    if word == w:
        global h
        h += 1
        return
   
    if direct is None:
        for d in directions:
            newr, newc = row+d[0], col+d[1]
            if newr >= r or newr < 0 or newc >= c or newc < 0:
                continue
            elif grid[newr][newc] == w[len(word)]:
                search(newr, newc, word + w[len(word)], d)
    else:
        newr, newc = row+direct[0], col+direct[1]
        if newr >= r or newr < 0 or newc >= c or newc < 0:
            pass
        elif grid[newr][newc] == w[len(word)]:
            search(newr, newc, word + w[len(word)], direct, turn)
           
        if turn is False:
            for d in perpendicular(direct):
                newr, newc = row+d[0], col+d[1]
                if newr >= r or newr < 0 or newc >= c or newc < 0:
                    continue
                elif grid[newr][newc] == w[len(word)]:
                    search(newr, newc, word + w[len(word)], d, True)
   
    return False

for row in range(r):
    for col in range(c):
        if grid[row][col] == w[0]:
            search(row, col, w[0])

print(h)

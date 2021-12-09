def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = list(entry)
    entry = [int(str) for str in entry]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = list(entry)
        entry = [int(str) for str in entry]
    f.close()
    return matrix

def checkPoint(n,i,j):
    if j > 0:
        if n[i][j] >= n[i][j-1]:
            return False
    if j < len(n[0])-1:
        if n[i][j] >= n[i][j+1]:
            return False
    if i > 0:
        if n[i][j] >= n[i-1][j]:
            return False
    if i < len(n)-1:
        if n[i][j] >= n[i+1][j]:
            return False
    return True

def findBasin(n,pts,a):
    basin = []
    basin.append(pts[a])
    i = 0
    while i < len(basin):
        z = basin[i][0]
        x,y = basin[i][2],basin[i][1]
        if x > 0:
            if n[y][x-1] >= z+1 and n[y][x-1] != 9:
                basin.append([n[y][x-1],y,x-1])
        if x < len(n[0])-1:
            if n[y][x+1] >= z+1 and n[y][x+1] != 9:
                basin.append([n[y][x+1],y,x+1])
        if y > 0:
            if n[y-1][x] >= z+1 and n[y-1][x] != 9:
                basin.append([n[y-1][x],y-1,x])
        if y < len(n)-1:
            if n[y+1][x] >= z+1 and n[y+1][x] != 9:
                basin.append([n[y+1][x],y+1,x])
        i += 1
    res = []
    for j in basin:
        if j not in res:
            res.append(j)
    return len(res)

def printBoard(b):
    for i in range(len(b)):
        for j in range(len(b[i])):
            if b[i][j] != 9:
                print(b[i][j],end="")
            else:
                print(" ",end="")
        print()

def main():
    n = parseFile("in2.txt")
    pts = []
    for i in range(len(n)):
        for j in range(len(n[0])):
            if checkPoint(n,i,j):
                pts.append([int(n[i][j]),i,j])
    basin = []
    for i in range(len(pts)):
        basin.append(findBasin(n,pts,i))
    basin.sort(reverse=True)
    #print(basin[0]*basin[1]*basin[2])
    res = []
    for i in basin:
        if i not in res:
            res.append(i)
    print(res[0]*res[1]*res[2])
    
main()

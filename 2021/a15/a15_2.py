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
    entry = [int(x) for x in entry]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = list(entry)
        entry = [int(x) for x in entry]
    f.close()
    return matrix

def dijkstra(b,c,k,r,q,m,s,n):
    nb = b[n]
    nc = c[n]
    m.pop(q.index(n))
    q.remove(n)
    if n < len(b)-s:
        v = nc + b[n+s]
        if (c[n+s] == -1 or v < c[n+s]):
            c[n+s] = v
            q.append(n+s)
            m.append(v)
    if (n+1) % s != 0:
        v = nc + b[n+1]
        if (c[n+1] == -1 or v < c[n+1]):
            c[n+1] = v
            q.append(n+1)
            m.append(v)
    if n > s:
        v = nc + b[n-s]
        if (c[n-s] == -1 or v < c[n-s]):
            c[n-s] = v
            q.append(n-s)
            m.append(v)
    if n % s != 0:
        v = nc + b[n-1]
        if (c[n-1] == -1 or v < c[n-1]):
            c[n-1] = v
            q.append(n-1)
            m.append(v)

def printBoard(b,s):
    for i in range(len(b)):
        if b[i] < 10:
            print(" ",end="")
        if b[i] < 100:
            print(" ",end="")
        if b[i] < 1000:
            print(" ",end="")
        print(b[i],end=",")
        if (i+1) % s == 0:
            print()
    print()

def printBoard2D(b,):
    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print()

def main():
    n = parseFile("in2.txt")
    n[0][0] = 1
    b,c,k,r,q,m,t = [],[],[],[],[],[],[]
    size = len(n)
    for i in range(5):
        for j in range(size):
            t2 = []
            for x in range(5):
                for y in range(size):
                    v = n[j][y]+i+x
                    if v > 9:
                        v -= 9
                    t2.append(v)
            t.append(t2)
    size *= 5
    for i in range(size):
        for j in range(size):
            b.append(t[i][j])
            c.append(-1)
            k.append(False)
            r.append(-1)
    c[0] = 0
    q.append(0)
    m.append(0)
    while True:
        i = q[m.index(min(m))]
        dijkstra(b,c,k,r,q,m,size,i)
        if i == len(b)-1:
            break
    print(c[len(c)-1])
    
main()

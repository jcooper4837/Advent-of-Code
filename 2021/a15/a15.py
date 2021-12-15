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

def path(b,c,s,n):
    nb = b[n]
    nc = c[n]
    if n < len(b)-s:
        v = nc + b[n+s]
        if v < c[n+s] and v < c[len(b)-1]:
            c[n+s] = v
            path(b,c,s,n+s)
    if (n+1) % s != 0:
        v = nc + b[n+1]
        if v < c[n+1] and v < c[len(b)-1]:
            c[n+1] = v
            path(b,c,s,n+1)
    if n > s:
        v = nc + b[n-s]
        if v < c[n-s] and v < c[len(b)-1]:
            c[n-s] = v
            path(b,c,s,n-s)
    if n % s != 0:
        v = nc + b[n-1]
        if v < c[n-1] and v < c[len(b)-1]:
            c[n-1] = v
            path(b,c,s,n-1)

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

def main():
    n = parseFile("in2.txt")
    b,c = [],[]
    size = len(n)
    for i in range(size):
        for j in range(size):
            b.append(n[i][j])
            c.append(9999)
    c[0] = 0
    path(b,c,size,0)
    print(c[len(c)-1])
    
main()

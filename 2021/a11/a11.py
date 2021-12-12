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

def printBoard(b):
    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print()
    print()

def increment(n,q,i,j):
    if n != 9:
        return n+1
    else:
        q.append([i,j])
        return 0

def main():
    n = parseFile("in2.txt")
    f = 0
    size = 10
    steps = 100
    for i in range(steps):
        q = []
        for j in range(size):
            for k in range(size):
                if n[j][k] != 9:
                    n[j][k] += 1
                else:
                    n[j][k] = 0
                    q.append([j,k])
        while len(q) > 0:
            i2,j2 = q[0][0],q[0][1]
            if i2 > 0 and j2 > 0:
                if n[i2-1][j2-1] != 0:
                    n[i2-1][j2-1] = increment(n[i2-1][j2-1],q,i2-1,j2-1)
            if j2 > 0:
                if n[i2][j2-1] != 0:
                    n[i2][j2-1] = increment(n[i2][j2-1],q,i2,j2-1)
            if i2 < size-1 and j2 > 0:
                if n[i2+1][j2-1] != 0:
                    n[i2+1][j2-1] = increment(n[i2+1][j2-1],q,i2+1,j2-1)
            if i2 < size-1:
                if n[i2+1][j2] != 0:
                    n[i2+1][j2] = increment(n[i2+1][j2],q,i2+1,j2)
            if i2 < size-1 and j2 < size-1:
                if n[i2+1][j2+1] != 0:
                    n[i2+1][j2+1] = increment(n[i2+1][j2+1],q,i2+1,j2+1)
            if j2 < size-1:
                if n[i2][j2+1] != 0:
                    n[i2][j2+1] = increment(n[i2][j2+1],q,i2,j2+1)
            if i2 > 0 and j2 < size-1:
                if n[i2-1][j2+1] != 0:
                    n[i2-1][j2+1] = increment(n[i2-1][j2+1],q,i2-1,j2+1)
            if i2 > 0:
                if n[i2-1][j2] != 0:
                    n[i2-1][j2] = increment(n[i2-1][j2],q,i2-1,j2)
            q.remove(q[0])
            f += 1
    print(f)
    
main()

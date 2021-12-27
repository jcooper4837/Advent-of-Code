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
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = list(entry)
    matrix.pop(1)
    f.close()
    return matrix

def createBoard(s):
    m = []
    for i in range(s*3):
        t = []
        for j in range(s*3):
            t.append('.')
        m.append(t)
    return m

def copyBoard(b,t,s):
    for i in range(s*3):
        for j in range(s*3):
            b[i][j] = t[i][j]

def printBoard(b):
    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print()
    print()

def main():
    n = parseFile("in2.txt")
    a = n.pop(0)
    s = len(n[0])
    steps = 0
    b = createBoard(s)
    for i in range(s):
        for j in range(s):
            b[i+s][j+s] = n[i][j]
    while steps < 2:
        t = createBoard(s)
        for i in range(1,s*3-1):
            for j in range(1,s*3-1):
                d = ""
                for x in range(i-1,i+2):
                    for y in range(j-1,j+2):
                        if b[x][y] == '.':
                            d += '0'
                        elif b[x][y] == '#':
                            d += '1'
                t[i][j] = a[int(d,2)]
        copyBoard(b,t,s)
        steps += 1
    total = 0
    for i in range(s+2*steps):
        for j in range(s+2*steps):
            if b[i+s-2*int(steps/2)][j+s-2*int(steps/2)] == '#':
                total += 1
    print(total)
    
main()

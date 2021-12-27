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

def createBoard(s,e):
    m = []
    for i in range(s*e):
        t = []
        for j in range(s*e):
            t.append('.')
        m.append(t)
    return m

def copyBoard(b,t,s,e):
    for i in range(s*e):
        for j in range(s*e):
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
    e = 3
    o = s*int((e-1)/2)
    b = createBoard(s,e)
    for i in range(s):
        for j in range(s):
            b[i+o][j+o] = n[i][j]
    while steps < 50:
        t = createBoard(s,e)
        for i in range(1,s*e-1):
            for j in range(1,s*e-1):
                d = ""
                for x in range(i-1,i+2):
                    for y in range(j-1,j+2):
                        if b[x][y] == '.':
                            d += '0'
                        elif b[x][y] == '#':
                            d += '1'
                t[i][j] = a[int(d,2)]
        copyBoard(b,t,s,e)
        steps += 1
    total = 0
    for i in range(o-steps,o+steps+s):
        for j in range(o-steps,o+steps+s):
            if b[i][j] == '#':
                total += 1
    print(total)
    
main()

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split(",")
    entry = [int(str) for str in entry]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if len(entry) == 1:
            matrix.append(0)
            break
        entry = entry[:len(entry)-1]
        entry = entry.split(",")
        entry = [int(str) for str in entry]
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split("=")
    entry[0] = entry[0][len(entry[0])-1:]
    entry[1] = int(entry[1])
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split("=")
        entry[0] = entry[0][len(entry[0])-1:]
        entry[1] = int(entry[1])
    f.close()
    return matrix

def printBoard(b):
    for i in range(len(b)):
        for j in range(len(b[i])):
            if b[i][j] == 0:
                print(".",end="")
            else:
                print("#",end="")
        print()
    print()

def main():
    n = parseFile("in2.txt")
    size = n.index(0)
    pts = n[:size]
    folds = n[size+1:]
    maxX,maxY = 0,0
    for i in range(len(folds)):
        if folds[i][0] == "x":
            maxX = folds[i][1]*2
        elif folds[i][0] == "y":
            maxY = folds[i][1]*2
        if maxX != 0 and maxY != 0:
            break
    b = []
    for i in range(maxY+1):
        b.append([])
        for j in range(maxX+1):
            b[i].append(0)
    for i in range(len(pts)):
        b[pts[i][1]][pts[i][0]] = 1
    for i in range(len(folds)):
        axis = folds[i][0]
        ch = folds[i][1]
        if axis == "y":
            for j in range(ch):
                for k in range(len(b[j])):
                    if b[j][k] == 0:
                        b[j][k] = b[len(b)-1-j][k]
            b = b[:ch]
        elif axis == "x":
            for j in range(len(b)):
                for k in range(ch):
                    if b[j][k] == 0:
                        b[j][k] = b[j][len(b[j])-1-k]
            for j in range(len(b)):
                b[j] = b[j][:ch]
    print(sum(x.count(1) for x in b))
    printBoard(b)
    
main()

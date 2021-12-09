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

def main():
    n = parseFile("in2.txt")
    pts = []
    for i in range(len(n)):
        for j in range(len(n[0])):
            if checkPoint(n,i,j):
                pts.append(n[i][j])
    pts = [int(str) for str in pts]
    print(sum(pts)+len(pts))
    
main()

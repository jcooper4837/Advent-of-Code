def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split("-")
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split("-")
    f.close()
    return matrix

def getPaths(n,c,q,t):
    q.append(c)
    for i in range(len(n)):
        if c in n[i]:
            slot = n[i].index(c)
            value = n[i][(slot+1)%2]
            if value == "end":
                t[0] += 1
            elif value.isupper() or value not in q:
                getPaths(n,value,q,t)
    q.pop()
        

def main():
    n = parseFile("in2.txt")
    total = [0]
    getPaths(n,"start",[],total)
    print(total[0])
    
main()

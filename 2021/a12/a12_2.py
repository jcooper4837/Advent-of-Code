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

def getPaths(n,c,q,t,s,d):
    q.append(c)
    for i in range(len(n)):
        if c in n[i]:
            slot = n[i].index(c)
            value = n[i][(slot+1)%2]
            if value == "end":
                t[0] += 1
            elif value != "start" and (value.isupper() or
                not s[0] or value not in q):
                if value in q and value.islower():
                    s[0] = True
                    d[0] = value
                getPaths(n,value,q,t,s,d)
    temp = q.pop()
    if temp == d[0]:
        s[0] = False
        d[0] = ""
        

def main():
    n = parseFile("in2.txt")
    total = [0]
    getPaths(n,"start",[],total,[False],[""])
    print(total[0])
    
main()

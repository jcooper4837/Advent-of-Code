def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
    f.close()
    return matrix

def parsePacket(b,it,vs):
    v = ""
    for i in range(it[0],it[0]+3):
        v += b[it[0]]
        it[0] += 1
    vs[0] += int(v,2)
    t = ""
    for i in range(it[0],it[0]+3):
        t += b[it[0]]
        it[0] += 1
    if int(t,2) == 4:
        d = ""
        c = "1"
        while c != "0":
            c = b[it[0]]
            it[0] += 1
            for i in range(it[0],it[0]+4):
                d += b[it[0]]
                it[0] += 1
    else:
        tid = b[it[0]]
        it[0] += 1
        s = ""
        for i in range(it[0],it[0]+11):
            s += b[it[0]]
            it[0] += 1
        if int(tid) == 0:
            for i in range(it[0],it[0]+4):
                s += b[it[0]]
                it[0] += 1
            cut = it[0]+int(s,2)
            while it[0] < cut:
                parsePacket(b,it,vs)
        else:
            for i in range(int(s,2)):
                parsePacket(b,it,vs)

def main():
    n = parseFile("in2.txt")
    for i in range(len(n)):
        b = (bin(int(n[i],16)))
        b = b[2:]
        while len(b) < len(n[i])*4:
            b = "0"+b
        it,vs = [0],[0]
        parsePacket(b,it,vs)
        print(vs[0])
    
main()

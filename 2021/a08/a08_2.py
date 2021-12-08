def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split(" ")
    entry.remove(entry[10])
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split(" ")
        entry.remove(entry[10])
    f.close()
    return matrix

def translateDigit(c,s):
    if len(c) == 2:
        return 1
    elif len(c) == 3:
        return 7
    elif len(c) == 4:
        return 4
    elif len(c) == 7:
        return 8
    else:
        pool = []
        for j in range(len(c)):
            pool.append(s.index(c[j]))
        if len(c) == 6:
            if sum(pool) == 17:
                return 9
            elif sum(pool) == 18:
                return 0
            elif sum(pool) == 19:
                return 6
        else:
            if 1 in pool:
                return 5
            elif 4 in pool:
                return 2
            else:
                return 3

def checkTwo(d,s,ch,case):
    c1,c2 = 0,0
    for i in range(3,len(d)-1):
        if ch[0] in d[i]:
            c1 += 1
        if ch[1] in d[i]:
            c2 += 1
    if case == 0:
        p1 = 2
        p2 = 5
    elif case == 1:
        p1 = 1
        p2 = 3
    if c1 < c2:
        s[p1] = ch[0]
        s[p2] = ch[1]
    elif c1 > c2:
        s[p1] = ch[1]
        s[p2] = ch[0]

def printDigit(s):
    print(" ",s[0],s[0],s[0],s[0]," ")
    print(s[1],"       ",s[2])
    print(s[1],"       ",s[2])
    print(" ",s[3],s[3],s[3],s[3]," ")
    print(s[4],"       ",s[5])
    print(s[4],"       ",s[5])
    print(" ",s[6],s[6],s[6],s[6]," ")

def main():
    n = parseFile("in2.txt")
    output = []
    for i in range(len(n)):
        sign = ["*","*","*","*","*","*","*",]
        digis = n[i][:10]
        codes = n[i][10:]
        digis.sort(key=len)
        for i in range(len(digis[1])):
            if digis[1][i] not in digis[0]:
                sign[0] = digis[1][i]
                break
        ch = [digis[0][0],digis[0][1]]
        checkTwo(digis,sign,ch,0)
        ch = []
        for i in range(len(digis[2])):
            if digis[2][i] not in sign:
                ch.append(digis[2][i])
        checkTwo(digis,sign,ch,1)
        for i in range(3,len(digis)):
            ch = []
            for j in range(len(digis[i])):
                if digis[i][j] not in sign:
                    ch.append(digis[i][j])
            if len(ch) == 1:
                sign[6] = ch[0]
                break
        for i in range(len(digis[9])):
            if digis[9][i] not in sign:
                sign[4] = digis[9][i]
        o = []
        for i in range(len(codes)):
            d = translateDigit(codes[i],sign)
            o.append(d)
        o = [str(int) for int in o]
        o = "".join(o)
        output.append(int(o))
        #printDigit(sign)
    print(sum(output))
    
main()

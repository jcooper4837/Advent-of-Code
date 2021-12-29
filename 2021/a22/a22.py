import re

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
    entry[1] = re.split(r'(-?\d+)',entry[1])
    for i in range(len(entry[1])):
        entry[1][i] = ''.join([x for x in entry[1][i] if x in '1234567890-'])
    entry[1] = [x for x in entry[1] if x]
    entry[1] = [int(str) for str in entry[1]]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split(" ")
        entry[1] = re.split(r'(-?\d+)',entry[1])
        for i in range(len(entry[1])):
            entry[1][i] = ''.join([x for x in entry[1][i] if x in '1234567890-'])
        entry[1] = [x for x in entry[1] if x]
        entry[1] = [int(str) for str in entry[1]]
    f.close()
    return matrix

def createBoard(lb,hb):
    b = []
    for i in range(lb,hb+1):
        t1 = []
        for j in range(lb,hb+1):
            t2 = []
            for k in range(lb,hb+1):
                t2.append(0)
            t1.append(t2)
        b.append(t1)
    return b

def countOn(b):
    ans = 0
    for i in range(len(b)):
        for j in range(len(b[i])):
            for k in range(len(b[i][j])):
                ans += b[i][j][k]
    return ans

def main():
    n = parseFile("in2.txt")
    lb,hb = -50,50
    b = createBoard(lb,hb)
    for i in range(len(n)):
        st = n[i][0]
        if st == "on":
            v = 1
        elif st == "off":
            v = 0
        rng = n[i][1]
        if max(rng) > hb or min(rng) < lb:
            continue
        for i in range(rng[0]+hb,rng[1]+hb+1):
            for j in range(rng[2]+hb,rng[3]+hb+1):
                for k in range(rng[4]+hb,rng[5]+hb+1):
                    b[i][j][k] = v
    print(countOn(b))
    
main()

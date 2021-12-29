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

def getTotal(b,a):
    ans = 0
    for i in range(len(b)):
        x = b[i][1]-b[i][0]+1
        y = b[i][3]-b[i][2]+1
        z = b[i][5]-b[i][4]+1
        if a[i] == 1:
            ans += x*y*z
        elif a[i] == 0:
            ans -= x*y*z
    return ans

def printBoard(b,a):
    for i in range(len(b)):
        print(b[i],a[i])
    print()

def main():
    n = parseFile("in2.txt")
    b,a = [],[]
    for i in range(len(n)):
        st = n[i][0]
        if st == "on":
            v = 1
        elif st == "off":
            v = 0
        rng = n[i][1]
        rng2,v2 = [],[]
        x1,x2,y1,y2,z1,z2 = rng[0],rng[1],rng[2],rng[3],rng[4],rng[5]
        for j in range(len(b)):
            if ((not (x1 < b[j][0] and x2 < b[j][0]) and
                 not (x1 > b[j][1] and x2 > b[j][1])) and
                 (not (y1 < b[j][2] and y2 < b[j][2]) and
                 not (y1 > b[j][3] and y2 > b[j][3])) and
                  (not (z1 < b[j][4] and z2 < b[j][4]) and
                 not (z1 > b[j][5] and z2 > b[j][5]))):
                t = [max(x1,b[j][0]),min(x2,b[j][1]),
                    max(y1,b[j][2]),min(y2,b[j][3]),
                    max(z1,b[j][4]),min(z2,b[j][5])]
                rng2.append(t)
                v2.append((a[j]+1)%2)
        if v == 1:
            b.append(rng)
            a.append(v)
        for j in range(len(rng2)):
            b.append(rng2[j])
            a.append(v2[j])
    print(getTotal(b,a))
    
main()

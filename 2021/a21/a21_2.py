import re

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    for i in range(2):
        entry = f.readline()
        entry = re.split(r'(-?\d+)',entry)
        entry = ''.join([x for x in entry if x in '1234567890-'])
        entry = [x for x in entry if x]
        entry = [int(str) for str in entry]
        matrix.append(entry[1])
    f.close()
    return matrix

def initArray():
    b = []
    for i in range(21):
        t1 = []
        for j in range(21):
            t2 = []
            for k in range(10):
                t3 = []
                for a in range(10):
                    t3.append(0)
                t2.append(t3)
            t1.append(t2)
        b.append(t1)
    return b

def copyArray(b,t):
    for i in range(21):
        for j in range(21):
            for k in range(10):
                for a in range(10):
                    b[i][j][k][a] = t[i][j][k][a]

def complete(b):
    for i in range(21):
        for j in range(21):
            for k in range(10):
                for a in range(10):
                    if b[i][j][k][a] != 0:
                        return False
    return True

def nonZero(b):
    for i in range(21):
        for j in range(21):
            for k in range(10):
                for a in range(10):
                    if b[i][j][k][a] != 0:
                        print(i,j,k,a,"->",b[i][j][k][a])
    print()

def main():
    n = parseFile("in2.txt")
    it = 0
    w = [0,0]
    s = [1,3,6,7,6,3,1]
    c = initArray()
    c[0][0][n[0]-1][n[1]-1] += 1
    while not complete(c):
        t = initArray()
        for i in range(21):
            for j in range(21):
                for k in range(10):
                    for a in range(10):
                        if c[i][j][k][a] > 0:
                            f = c[i][j][k][a]
                            for x in range(7):
                                if it == 0:
                                    if (k+(x+3))%10+1+i >= 21:
                                        w[it] += s[x]*f
                                    else:
                                        t[(k+(x+3))%10+1+i][j][(k+(x+3))%10][a] += s[x]*f
                                elif it == 1:
                                    if (a+(x+3))%10+1+j >= 21:
                                        w[it] += s[x]*f
                                    else:
                                        t[i][(a+(x+3))%10+1+j][k][(a+(x+3))%10] += s[x]*f
        it = (it+1)%2
        copyArray(c,t)
    print(max(w))
    
main()

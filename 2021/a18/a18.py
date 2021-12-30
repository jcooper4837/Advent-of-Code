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
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
    f.close()
    return matrix

def calcMag(b):
    tr = 4
    while tr > 0:
        cnt = 0
        j = 0
        while j < len(b):
            if b[j] == '[':
                cnt += 1
            elif b[j] == ']':
                cnt -= 1
            elif cnt == tr and ord(b[j])>=48 and ord(b[j])<=57:
                it = j+1
                while b[it] != ']':
                    it += 1
                v = b[j:it].split(",")
                new = int(v[0])*3+int(v[1])*2
                b = b[:j-1]+str(new)+b[it+1:]
                j = -1
                cnt = 0
            j += 1
        tr -= 1
    return int(b)

def main():
    n = parseFile("in2.txt")
    b = n[0]
    for i in range(1,len(n)):
        a = n[i]
        b = '['+b+','+a+']'
        check = 0
        cnt = 1
        j = 1
        while cnt > 0:
            if b[j] == '[':
                cnt += 1
            elif b[j] == ']':
                cnt -= 1
            if cnt == 5:
                it = j
                tup = []
                while b[it] != ']':
                    if ord(b[it])>=48 and ord(b[it])<=57:
                        if ord(b[it+1])>=48 and ord(b[it+1])<=57:
                            tup.append(int(b[it:it+2]))
                            it += 1
                        else:
                            tup.append(int(b[it]))
                    it += 1
                k = j
                e = 0
                ne = True
                while k > 1:
                    if ord(b[k])>=48 and ord(b[k])<=57:
                        if ord(b[k-1])>=48 and ord(b[k-1])<=57:
                            new = int(b[k-1:k+1])+tup[0]
                            e += 1
                            ne = False
                        else:
                            new = int(b[k])+tup[0]
                        if new >= 10 and ne:
                            j += 1
                            it += 1
                        b = b[:k-e]+str(new)+b[k+1:]
                        break
                    k -= 1
                k = it+1
                e = 0
                while k < len(b)-2:
                    if ord(b[k])>=48 and ord(b[k])<=57:
                        if ord(b[k+1])>=48 and ord(b[k+1])<=57:
                            new = int(b[k:k+2])+tup[1]
                            e += 1
                        else:
                            new = int(b[k])+tup[1]
                        b = b[:k]+str(new)+b[k+1+e:]
                        break
                    k += 1
                if b[j] != '[':
                    b = b[:j]+"0"+b[it+1:]
                    print(b)
                    input()
                b = b[:j]+"0"+b[it+1:]
                cnt = 1
                j = 1
                continue
            if ((ord(b[j])>=48 and ord(b[j])<=57)
                and (ord(b[j-1])>=48 and ord(b[j-1])<=57) and check > 0):
                check = 0
                v = int(b[j-1:j+1])
                pr = [v//2,(v//2)+(v%2>0)]
                b = b[:j-1]+"["+str(pr[0])+","+str(pr[1])+"]"+b[j+1:]
                cnt = 1
                j = 1
                continue
            j += 1
            if cnt == 0 and check == 0:
                check += 1
                cnt = 1
                j = 1
    print(calcMag(b))
    
main()

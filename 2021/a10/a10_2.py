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

def main():
    n = parseFile("in2.txt")
    w = []
    for i in range(len(n)):
        q = []
        for j in range(len(n[i])):
            if (n[i][j] == '(' or n[i][j] == '[' or
                n[i][j] == '{' or n[i][j] == '<'):
                q.append(n[i][j])
            else:
                if (n[i][j] == ')' and q[len(q)-1] == '(' or
                    n[i][j] == ']' and q[len(q)-1] == '[' or
                    n[i][j] == '}' and q[len(q)-1] == '{' or
                    n[i][j] == '>' and q[len(q)-1] == '<'):
                    q.pop()
                else:
                    break
            if j == len(n[i])-1:
                q.reverse()
                w.append(q)
    s = []
    for i in range(len(w)):
        pt = []
        if w[i][0] == '(':
            pt.append(1)
        elif w[i][0] == '[':
            pt.append(2)
        elif w[i][0] == '{':
            pt.append(3)
        elif w[i][0] == '<':
            pt.append(4)
        for j in range(1,len(w[i])):
            if w[i][j] == '(':
                pt.append(pt[len(pt)-1]*5+1)
            elif w[i][j] == '[':
                pt.append(pt[len(pt)-1]*5+2)
            elif w[i][j] == '{':
                pt.append(pt[len(pt)-1]*5+3)
            elif w[i][j] == '<':
                pt.append(pt[len(pt)-1]*5+4)
        s.append(pt[len(pt)-1])
    s.sort()
    print(s[int(len(s)/2)])
    
main()

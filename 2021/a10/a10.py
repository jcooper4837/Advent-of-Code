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
                    w.append(n[i][j])
                    break
    s = []
    for i in range(len(w)):
        if w[i] == ')':
            s.append(3)
        elif w[i] == ']':
            s.append(57)
        elif w[i] == '}':
            s.append(1197)
        elif w[i] == '>':
            s.append(25137)
    print(sum(s))
    
main()

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = list(entry)
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = list(entry)
    f.close()
    return matrix

def printBoard(b):
    for i in range(len(b)):
        for j in range(len(b[i])):
            print(b[i][j],end="")
        print()
    print()

def main():
    n = parseFile("in2.txt")
    s = 0
    m = True
    while m:
        m = False
        i = 0
        while i < len(n):
            j = 0
            e = True
            while j < len(n[i])-1:
                if n[i][j] == '>' and n[i][j+1] == '.':
                    m = True
                    n[i][j] = '.'
                    n[i][j+1] = '>'
                    if j == 0 or j == len(n[i])-2:
                        e = False
                    j += 1
                j += 1
            if e and n[i][len(n[i])-1] == '>' and n[i][0] == '.':
                m = True
                n[i][len(n[i])-1] = '.'
                n[i][0] = '>'
            i += 1
        j = 0
        while j < len(n[0]):
            i = 0
            e = True
            while i < len(n)-1:
                if n[i][j] == 'v' and n[i+1][j] == '.':
                    m = True
                    n[i][j] = '.'
                    n[i+1][j] = 'v'
                    if i == 0 or i == len(n)-2:
                        e = False
                    i += 1
                i += 1
            if e and n[len(n)-1][j] == 'v' and n[0][j] == '.':
                m = True
                n[len(n)-1][j] = '.'
                n[0][j] = 'v'
            j += 1
        s += 1
    print(s)
    
main()

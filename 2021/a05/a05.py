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
    entry = re.split(r'\D+',entry)
    entry = [int(i) for i in entry]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = re.split(r'\D+',entry)
        entry = [int(i) for i in entry]
    f.close()
    return matrix

def printBoards(b,bl):
    for i in range(bl):
        s = "["
        for j in range(bl):
            s += str(b[bl*i+j])
            if j != bl-1:
                s += ","
            else:
                s += "]"
        print(s)
    print()

def drawLines(n,c,b,bl):
    if c == -1:
        return
    elif c == 0:
        x = n[0]
        if n[3] > n[1]:
            st = n[1]
        else:
            st = n[3]
        for i in range(st,abs(n[3]-n[1])+1+st):
            b[bl*i+x] += 1
    elif c == 1:
        y = n[1]
        if n[2] > n[0]:
            st = n[0]
        else:
            st = n[2]
        for i in range(st,abs(n[2]-n[0])+1+st):
            b[bl*y+i] += 1

def main():
    n = parseFile("in2.txt")
    maxim = max(map(max,n))
    size = pow(10,len(str(maxim)))
    board = []
    for i in range(size*size):
        board.append(0)
    for i in range(len(n)):
        case = -1
        if n[i][0] == n[i][2]:
            case = 0
        elif n[i][1] == n[i][3]:
            case = 1
        drawLines(n[i],case,board,size)
    check = max(board)
    total = 0
    for i in range(2,check+1):
        total += board.count(i)
    #printBoards(board,size)
    print(total)
    
main()

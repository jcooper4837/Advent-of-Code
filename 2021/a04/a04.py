def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split(",")
    entry = [int(i) for i in entry]
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        if len(entry) == 0:
            continue
        entry = entry.split(" ")
        entry = [i for i in entry if i.isdigit()]
        entry = [int(i) for i in entry]
    i = 0
    while True:
        if len(matrix[i]) == 0:
            matrix.remove(matrix[i])
            i -= 1
        i += 1
        if i >= len(matrix)-1:
            break
    f.close()
    return matrix

def printBoards(b,bl):
    for i in range(len(b)):
        for j in range(bl):
            s = "["
            for k in range(bl):
                s += str(b[i][bl*j+k])
                if k != bl-1:
                    s += ","
                else:
                    s += "]"
            print(s)
        print()

def checkWin(b,bl):
    for i in range(bl):
        row = []
        for j in range(bl):
            row.append(b[bl*i+j])
        if 0 not in row:
            return True
    for i in range(bl):
        it = i
        col = []
        while it < bl*bl:
            col.append(b[it])
            it += bl
        if 0 not in col:
            return True
    return False

def main():
    n = parseFile("in2.txt")
    nums = n[0]
    bl = 5
    boards,pool = [],[]
    for i in range(1,int((len(n)-1)/bl)+1):
        m,p = [],[]
        for j in range(bl):
            for k in range(bl):
                m.append(n[j+(bl*(i-1))+1][k])
                p.append(0)
        boards.append(m)
        pool.append(p)
    winner = -1
    for i in range(len(nums)):
        pick = nums[i]
        for j in range(len(boards)):
            try:
                slot = boards[j].index(pick)
            except ValueError:
                slot = -1
            if slot != -1:
                pool[j][slot] = 1
            if checkWin(pool[j],bl):
                winner = j
        if winner != -1:
            break
    un = 0
    for i in range(len(boards[winner])):
        if pool[winner][i] == 0:
            un += boards[winner][i]
    #printBoards(boards,bl)
    #printBoards(pool,bl)
    print(winner,pick,un)
    print(pick*un)
main()

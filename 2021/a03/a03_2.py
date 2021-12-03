def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    data = list(entry)
    for i in range(len(data)):
        data[i] = eval(data[i])
    #print(data)
    while True:
        matrix.append(data)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        data = list(entry)
        for i in range(len(data)):
            data[i] = eval(data[i])
    #print(matrix)
    f.close()
    return matrix

def greater(a,b):
    return a > b

def lessThanEqual(a,b):
    return a <= b

def main():
    n = parseFile("in2.txt")
    for k in range(2):
        pool = []
        for i in range(len(n)):
            pool.append(1)
        for i in range(len(n[0])):
            a,b = 0,0
            for j in range(len(n)):
                if n[j][i] == 0 and pool[j] == 1:
                    a += 1
                elif n[j][i] == 1 and pool[j] == 1:
                    b += 1
            #print(a,b)
            if k == 0:
                eq = greater(a,b)
            elif k == 1:
                eq = lessThanEqual(a,b)
            if eq:
                for j in range(len(n)):
                    if n[j][i] == 1:
                        pool[j] = 0
            else:
                for j in range(len(n)):
                    if n[j][i] == 0:
                        pool[j] = 0
            #print(pool,sum(pool))
            if sum(pool) == 1:
                break
        for i in range(len(n)):
            if pool[i] == 1:
                if k == 0:
                    ox = n[i]
                elif k == 1:
                    co = n[i]
    #print(ox,co)
    ox2 = "".join([str(int) for int in ox])
    co2 = "".join([str(int) for int in co])
    print(ox2,co2)
    x = int(ox2,2)
    y = int(co2,2)
    print(x,y)
    print(x*y)
main()
